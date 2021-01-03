package com.company.Exercise02;

import java.util.Scanner;

public class SumChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numLines = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int i = 0; i < numLines ; i++) {
            char currentChar = scanner.nextLine().charAt(0);

            sum += currentChar;


        }
        System.out.printf("The sum equals: %d",sum);
    }

}
