import com.sun.security.jgss.GSSUtil;
import entities.Address;
import entities.Employee;
import entities.Project;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

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
                case 8 -> exerciseEight(); //Get Employee with Project
                case 9 -> exerciseNine(); //Find latest 10 Projects
                case 10-> exerciseTen(); //Increase Salaries
                case 11 -> exerciseEleven(); //Find Employees by First Name
                case 12 -> exerciseTwelve(); //Employees Maximum Salaries
                case 13 -> exerciseThirteen(); //Remove Towns
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }


    private void exerciseTwelve() {
        entityManager.createQuery("SELECT d.name, max(emp.salary) FROM Employee as emp " +
                "JOIN emp.department as d " +
                "GROUP BY d.name " +
                "HAVING max(emp.salary) < 30000 OR max(emp.salary) > 70000 " +
                "ORDER BY d.id", Object[].class)
                .getResultList()
                .forEach(x -> System.out.printf("%s - %s%n", x[0], x[1]));
    }

    private void exerciseThirteen() throws IOException {
        System.out.println("Please provide town name: ");
        String townName = reader.readLine();

        try {
            Town town = entityManager.createQuery("SELECT t FROM Town as t WHERE t.name =:name", Town.class)
                    .setParameter("name", townName)
                    .getSingleResult();
            List<Address> addresses = entityManager
                    .createQuery("SELECT add FROM Address as add WHERE add.town = :town", Address.class)
                    .setParameter("town", town)
                    .getResultList();
            entityManager.getTransaction().begin();
            entityManager.createQuery("UPDATE Employee as emp SET emp.address = null WHERE emp.address in :addresses")
                    .setParameter("addresses", addresses)
                    .executeUpdate();
            for (Address add : addresses) {
                entityManager.remove(add);
            }
            entityManager.remove(town);
            entityManager.getTransaction().commit();
            System.out.printf("%d addresses in %s deleted%n", addresses.size(), townName);
        } catch (NoResultException e) {
            System.out.println("No such town");
        }
    }

    private void exerciseEleven() throws IOException {
        System.out.println("Please provide first two letters of employee's first_name: ");
        String start = reader.readLine();

        entityManager.createQuery("SELECT emp FROM Employee as emp WHERE emp.firstName LIKE CONCAT(:str, '%')",
                Employee.class)
                .setParameter("str", start)
                .getResultList()
                .forEach(x -> System.out.printf("%s %s - %s - ($%.2f)%n",
                        x.getFirstName(), x.getLastName(), x.getJobTitle(), x.getSalary()));
    }

    private void exerciseTen() {
        List<Employee> employees = entityManager
                .createQuery("SELECT emp FROM Employee as emp JOIN emp.department as d " +
                                "WHERE d.name in ('Engineering', 'Tool Design', 'Marketing', 'Information Services')" +
                                "ORDER BY emp.id",
                        Employee.class)
                .getResultList();
        entityManager.getTransaction().begin();
        for (Employee emp : employees) {
            emp.setSalary(emp.getSalary().multiply(new BigDecimal(1.12)));
            System.out.printf("%s %s ($%.2f)%n", emp.getFirstName(), emp.getLastName(), emp.getSalary());
        }
        entityManager.getTransaction().commit();
        }

    private void exerciseNine() {
        StringBuilder projects = new StringBuilder();

        entityManager
                .createQuery("SELECT p FROM Project AS p ORDER BY p.startDate DESC", Project.class)
                .setMaxResults(10)
                .getResultList()
                .stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(project -> projects
                        .append("Project name: ").append(project.getName()).append(System.lineSeparator())
                        .append("\tProject Description: ").append(project.getDescription()).append(System.lineSeparator())
                        .append("\tProject Start Date: ").append(project.getStartDate()).append(System.lineSeparator())
                        .append("\tProject End Date: ").append(project.getEndDate()).append(System.lineSeparator()));

        System.out.println(projects.toString().trim());
    }

    private void exerciseEight() throws IOException {
        System.out.print("Enter employee id: ");
        Integer id = Integer.valueOf(reader.readLine());

       Employee employee = entityManager
                    .createQuery("SELECT e FROM Employee AS e WHERE e.id = :id", Employee.class)
                    .setParameter("id", id)
                    .getSingleResult();

            StringBuilder sb = new StringBuilder();

            sb.append(employee.getFirstName()).append(" ").append(employee.getLastName())
                    .append(" - ").append(employee.getJobTitle()).append(System.lineSeparator());

            employee.getProjects().stream()
                    .sorted(Comparator.comparing(Project::getName))
                    .forEach(project -> sb.append("\t").append(project.getName()).append(System.lineSeparator()));

            System.out.println(sb.toString().trim());
    }

    private void exerciseSeven() {
        List<Address> addressList = entityManager
                .createQuery("SELECT a FROM Address  a " +
                "ORDER BY a.employees.size DESC",Address.class)
                .setMaxResults(10)
                .getResultList();

        addressList.stream()
                .forEach(a -> System.out.printf("%s, %s - %d employees%n"
                        , a.getText()
                        ,a.getTown() == null ? "Unknown" : a.getTown().getName()
                        ,a.getEmployees().size()));
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
