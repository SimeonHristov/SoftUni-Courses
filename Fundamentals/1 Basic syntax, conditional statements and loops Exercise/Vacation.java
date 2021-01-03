package com.company.Exercise01;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        String groupType = scanner.nextLine().toLowerCase();
        String weekDay = scanner.nextLine().toLowerCase();
        double pricePerPerson = 0;
        double totalPrice = 0;

       if (weekDay.equals("friday")) {
           if (groupType.equals("students")){
               pricePerPerson = 8.45;
               } else if (groupType.equals("business")) {
               pricePerPerson = 10.90;
               }else if (groupType.equals("regular")){
               pricePerPerson = 8.45;
           }
        } else if (weekDay.equals("saturday")) {
           if (groupType.equals("students")) {
               pricePerPerson = 9.80;
           } else if (groupType.equals("business")) {
               pricePerPerson = 15.60;
           } else if (groupType.equals("regular")) {
               pricePerPerson = 20;
           }
       } else if (weekDay.equals("sunday")) {
           if (groupType.equals("students")) {
               pricePerPerson = 10.46;
           } else if (groupType.equals("business")) {
               pricePerPerson = 16;
           } else if (groupType.equals("regular")) {
               pricePerPerson = 22.50;
           }
       }

       if (people >= 30 && groupType.equals("students")) {
           totalPrice = (pricePerPerson * people) * 0.85;
           System.out.printf("Total price: %.2f",totalPrice);
       } else if (people >= 100 && groupType.equals("business")) {
           totalPrice = pricePerPerson * (people - 10);
           System.out.printf("Total price: %.2f", totalPrice);
       } else if (people >= 10 && people <= 20 && groupType.equals("regular")) {
           totalPrice = (pricePerPerson * people) * 0.95;
           System.out.printf("Total price: %.2f", totalPrice);
       } else {
           System.out.printf("Total price: %.2f",pricePerPerson*people);
       }
    }
}

