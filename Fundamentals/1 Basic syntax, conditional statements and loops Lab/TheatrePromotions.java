package com.company.Lab01;

import java.util.Scanner;

public class TheatrePromotions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String weekday = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());


        if (age >= 0 && age <= 18){
            switch (weekday){
                case "Weekday":
                    System.out.print("12"+"$");
                    break;
                case "Weekend":
                    System.out.print("15"+"$");
                    break;
                case "Holiday":
                    System.out.print("5"+"$");
                    break;
            }
        } else if (age > 18 && age <= 64) {
            switch (weekday) {
                case "Weekday":
                    System.out.print("18" + "$");
                    break;
                case "Weekend":
                    System.out.print("20" + "$");
                    break;
                case "Holiday":
                    System.out.print("12" + "$");
                    break;
            }
        } else if (age > 64 && age <= 122) {
            switch (weekday) {
                case "Weekday":
                    System.out.print("12" + "$");
                    break;
                case "Weekend":
                    System.out.print("15" + "$");
                    break;
                case "Holiday":
                    System.out.print("10" + "$");
                    break;
            }
        } else {
            System.out.println("Error!");
        }
    }
}
