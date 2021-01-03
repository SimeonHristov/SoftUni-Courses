package com.company.Lab02;

import java.util.Scanner;

public class PoundToDollars {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double num = Double.parseDouble(scanner.nextLine());

        double converted = num * 1.31 ;

        System.out.printf("%.3f",converted);
    }
}
