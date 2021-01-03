package com.company.Lab04.Methods;

import java.util.Scanner;

public class Grades02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printGrade(Double.parseDouble(scanner.nextLine()));


    }


    public static void printGrade(double input) {
        if (input >= 2.00 && input < 3.00) {
            System.out.printf("Fail");
        } else if (input < 3.50) {
            System.out.printf("Poor");
        } else if (input < 4.50) {
            System.out.printf("Good");
        } else if (input < 5.50){
            System.out.printf("Very good");
        } else if (input <= 6.00) {
            System.out.printf("Excellent");
        }
    }
}
