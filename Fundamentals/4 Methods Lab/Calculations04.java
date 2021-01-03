package com.company.Lab04.Methods;

import java.util.Scanner;

public class Calculations04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());


        if (input.equals("add")) {
            add(n1,n2);
        } else if (input.equals("multiply")) {
            multiply(n1,n2);
        } else if (input.equals("subtract")) {
            subtract(n1,n2);
        } else if (input.equals("divide")) {
            divide(n1,n2);
        }
    }

    public static void add (int n1, int n2) {
        System.out.println(n1 + n2);
    }

    public static void multiply (int n1, int n2) {
        System.out.println(n1 * n2);
    }

    public static void subtract (int n1, int n2) {
        System.out.println(n1 - n2);
    }

    public static void divide (int n1, int n2) {
        System.out.println(n1 / n2);
    }

}
