package com.company.Exercise02;

import java.util.Scanner;

public class TriplesOfLatinLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        String result = "";

        for (int i = 0; i < input ; i++) {
            for (int j = 0; j < input; j++) {
                for (int k = 0; k < input; k++) {

            char firstChar = (char) ('a' + i);
            char secondChar = (char) ('a' + j);
            char thirdChar = (char) ('a' + k);

            System.out.printf("%c%c%c%n",firstChar,secondChar,thirdChar);
                }
            }
        }

    }
}



