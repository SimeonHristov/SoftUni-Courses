package com.company.Lab03.Arrays;

import java.util.Scanner;

public class CondenseArrayToNumber07 {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String input = scanner.nextLine();
    String[] inputSplit = input.split(" ");

    int inputAsNumbers[] = new int [inputSplit.length];
        for (int i = 0; i < inputSplit.length; i++) {
            inputAsNumbers[i] = Integer.parseInt(inputSplit[i]);
        }

        while (inputAsNumbers.length > 1) {
            int[] condensed = new int[inputAsNumbers.length - 1];
            for (int i = 0; i < condensed.length; i++) {
                condensed[i] = inputAsNumbers[i] + inputAsNumbers[i + 1];
            }
            inputAsNumbers = condensed;
        }
        System.out.println(inputAsNumbers[0]);
    }
}
