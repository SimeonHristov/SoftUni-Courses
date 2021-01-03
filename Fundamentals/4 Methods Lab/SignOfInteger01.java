package com.company.Lab04.Methods;

import java.util.Scanner;

public class SignOfInteger01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printSign(Integer.parseInt(scanner.nextLine()));

    }

    public static void printSign(int number) {

        if (number < 0) {
            System.out.printf("The number %d is negative.", number);
        } else if (number == 0) {
            System.out.printf("The number %d is zero.", number);
        } else {
            System.out.printf("The number %d is positive.", number);
        }
    }
}

