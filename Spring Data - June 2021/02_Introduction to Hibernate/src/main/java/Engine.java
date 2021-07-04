import entities.Address;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.List;

public class Engine implements Runnable{

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final EntityManager entityManager;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void run() {
        System.out.println("Please provide exercise number: ");


        try {
            int exerciseNum = Integer.parseInt(reader.readLine());

            switch (exerciseNum) {
                case 2 -> exerciseTwo(); //Change casing
                case 3 -> exerciseThree(); //Contains Employee
                case 4 -> exerciseFour(); //Employees with Salary over 50 000
                case 5 -> exerciseFive(); //Employees from Department
                case 6 -> exerciseSix(); //Adding a new Address and Updating Employee
                case 7 -> exerciseSeven(); //Addresses with Employee Count
//                case 8 -> exerciseEight(); //Get Employee with Project
//                case 9 -> exerciseNine(); //Find latest 10 Projects
//                case 10-> exerciseTen(); //Increase Salaries
//                case 11 -> exerciseEleven(); //Find Employees by First Name
//                case 12 -> exerciseTwelve(); //Employees Maximum Salaries
//                case 13 -> exerciseThirteen(); //Remove Towns
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }


    }

    private void exerciseSeven() {

    }

    private void exerciseSix() throws IOException {
        System.out.println("Enter Address text: "); //Research and Development (6)
        String addressText = reader.readLine();

        System.out.println("Enter last name of employee to update: "); //Research and Development (6)
        String lastName = reader.readLine();

        Employee employee = entityManager.createQuery("SELECT e FROM Employee e "
                + "WHERE e.lastName = :last_name", Employee.class)
                .setParameter("last_name", lastName)
                .getSingleResult();

        Address address = new Address();
        address.setText(addressText);

        entityManager.getTransaction().begin();
        entityManager.persist(address);
        employee.setAddress(address);
        entityManager.getTransaction().commit();

    }

    private void exerciseFive() throws IOException {
        System.out.println("Enter Department name: "); //Research and Development (6)
        String depName = reader.readLine();

        entityManager.createQuery("SELECT e FROM Employee e " +
                "WHERE e.department.name = :departmentName "
                + "ORDER BY e.salary, e.id", Employee.class)
                .setParameter("departmentName", depName)
                .getResultStream()
                .forEach(employee -> {
                    System.out.printf("%s %s from %s - $%.2f%n"
                            , employee.getFirstName()
                            , employee.getLastName()
                            , employee.getDepartment().getName()
                            , employee.getSalary());
                });

    }

    private void exerciseFour() throws IOException {
        System.out.println("Enter salary: ");
        BigDecimal empSalary = BigDecimal.valueOf(Long.parseLong(reader.readLine()) );

        List<Employee> employeeList = entityManager.createQuery("SELECT e FROM Employee e " +
                "WHERE e.salary > :salary", Employee.class)
                .setParameter("salary", empSalary)
                .getResultList();

        for (Employee employee : employeeList) {
            System.out.println(employee.getFirstName());
        }

    }

    private void exerciseThree() throws IOException {
        System.out.println("Enter employee name: ");
        String[] names = reader.readLine().split("\\s+");
        String firstName  = names[0];
        String lastName  = names[1];

        try {
            Employee employee = entityManager.createQuery("SELECT e FROM Employee e " +
                    "WHERE e.firstName =:first AND e.lastName =:last", Employee.class)
                    .setParameter("first",firstName)
                    .setParameter("last",lastName)
                    .getSingleResult();

            System.out.println("Yes");

        } catch (NoResultException e) {
            System.out.println("No");
        }

    }

    private void exerciseTwo() {
        entityManager.getTransaction().begin();
        List<Town> towns = entityManager.createQuery("SELECT t FROM Town t", Town.class).getResultList();
        for (Town town : towns) {
            if (town.getName().length() > 5) {
                entityManager.detach(town);
            }
        }

        for (Town town : towns) {
            if (entityManager.contains(town)) {
                System.out.println(town.getName());
                town.setName(town.getName().toLowerCase());
                entityManager.persist(town);
            }
        }

        entityManager.getTransaction().commit();
    }
}
