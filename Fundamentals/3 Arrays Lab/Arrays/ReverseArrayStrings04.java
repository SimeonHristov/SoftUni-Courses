package com.company.Lab03.Arrays;

import java.util.Scanner;

public class ReverseArrayStrings04 {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] inputAsString = input.split(" ");

        for (int i = inputAsString.length - 1; i >= 0 ; i--) {
            System.out.print(inputAsString[i] + " ");
        }



    }

}
