package com.company.Exercise08.TextProcessing;

import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //System.out.println('c' - 'a' + 1);
        String[] tokens = scanner.nextLine().split("\\s+");
        double sum = 0;

        for (String input : tokens) {
            char firstLetter = input.charAt(0);
            char secondLetter = input.charAt(input.length() - 1);
            double number = Double.parseDouble(input.substring(1, input.length() - 1));

            int firstLetterPosition = getLetterAlphabeticPosition(firstLetter);
            int secondLetterPosition = getLetterAlphabeticPosition(secondLetter);

            if (Character.isUpperCase(firstLetter)) {
                sum += number/ firstLetterPosition;
            } else {
                sum += number * firstLetterPosition;
            }

            if (Character.isUpperCase(secondLetter)) {
                sum -= secondLetterPosition;
            } else {
                sum += secondLetterPosition;
            }
        }

        System.out.printf("%.2f", sum);


    }

    private static int getLetterAlphabeticPosition(char c) {
        char targetChar = Character.toLowerCase(c);
        char initialChar = 'a';
        int position = targetChar - initialChar + 1;

        return position;
    }
}
