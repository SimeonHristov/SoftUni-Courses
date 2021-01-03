package com.company.Exercise03.Arrays;

import java.util.Scanner;

public class TopIntegers05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String [] inputNumbers = input.split( " ");

        int [] numbers = new int [inputNumbers.length];
        for (int i = 0; i < inputNumbers.length; i++) {
            numbers[i] = Integer.parseInt(inputNumbers[i]);
        }


        for (int i = 0; i < numbers.length; i++) {
            boolean isTop = true;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] <= numbers[j]) {
                    isTop = false;
                }
            }
        if (isTop) {
            System.out.print(numbers[i] + " ");
        }
    }



    }
}
