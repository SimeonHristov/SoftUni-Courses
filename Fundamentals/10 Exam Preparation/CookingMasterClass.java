package com.company.MidExamREAL07112020;

import java.io.Console;
import java.sql.SQLOutput;
import java.util.Scanner;

public class CookingMasterClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double priceFlour = Double.parseDouble(scanner.nextLine());
        double priceEgg = Double.parseDouble(scanner.nextLine());
        double priceApron = Double.parseDouble(scanner.nextLine());

        int freePackages = students / 5;
        double neededItems = priceApron * Math.ceil(students * 1.2) + priceEgg * 10 * (students)
                + priceFlour * (students - freePackages);
        if (neededItems <= budget)
        {
            System.out.printf("Items purchased for %.2f$.",neededItems);
        }
        else
        {
            double neededMoney = neededItems - budget;
            System.out.printf("%.2f$ more needed.",neededMoney);

        }
    }

}
