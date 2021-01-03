package com.company.Lab08.TextProcessing;

import java.util.Scanner;

public class DigitsLettersOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String nums = "";
        String letters = "";
        String symbols = "";

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
           if (Character.isDigit(currentChar)) {
            nums += input.charAt(i);
           } else if (Character.isAlphabetic(currentChar)) {
               letters += input.charAt(i);
           } else {
               symbols += input.charAt(i);
           }
        }

        System.out.println(nums);
        System.out.println(letters);
        System.out.println(symbols);


//
//        •	Use loop to iterate through all characters in the text. If the char is digit print it, otherwise ignore it.
//        o	Use Character.isDigit(char symbol)
//•	Do the same for the letters and other chars
//        o	Find something like isDigit method for the letters.



    }

}
