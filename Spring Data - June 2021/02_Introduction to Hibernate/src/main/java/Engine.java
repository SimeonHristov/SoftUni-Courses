import entities.Town;
import net.bytebuddy.asm.MemberSubstitution;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
//                case 3 -> exerciseThree(); //Contains Employee
//                case 4 -> exerciseFour(); //Employees with Salary over 50 000
//                case 5 -> exerciseFive(); //Employees from Department
//                case 6 -> exerciseSix(); //Adding a new Address and Updating Employee
//                case 7 -> exerciseSeven(); //Addresses with Employee Count
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
