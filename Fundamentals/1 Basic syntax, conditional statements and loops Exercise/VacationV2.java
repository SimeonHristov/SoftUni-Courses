package com.company.Exercise01;

import java.util.Scanner;

    public class VacationV2 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int people = Integer.parseInt(scanner.nextLine());
            String groupType = scanner.nextLine();
            String weekDay = scanner.nextLine();
            //double pricePerPerson = 0;
            double totalPrice = 0;

        switch (groupType){
            case "Students":
                switch (weekDay){
                    case "Friday":
                        totalPrice = people * 8.45;
                        break;
                    case "Saturday":
                        totalPrice = people * 9.80;
                        break;
                    case "Sunday":
                        totalPrice = people * 10.46;
                        break;
                }
                if (people >= 30){
                    totalPrice *= 0.85;
                }
                break;
            case "Business":
                if (people >= 100){
                    people -= 10;
                }
                switch (weekDay){
                    case "Friday":
                        totalPrice = people * 10.90;
                        break;
                    case "Saturday":
                        totalPrice = people * 15.60;
                        break;
                    case "Sunday":
                        totalPrice = people * 16;
                        break;
                }
            case "Regular":
                switch (weekDay){
                    case "Friday":
                        totalPrice = people * 15;
                        break;
                    case "Saturday":
                        totalPrice = people * 20;
                        break;
                    case "Sunday":
                        totalPrice = people * 22.50;
                        break;
                }
                if (people >= 10 && people <= 20){
                    totalPrice *= 0.95;
                }
                break;
        }

            System.out.printf("Total price: %.2f",totalPrice);


    }
}
