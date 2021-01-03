package com.company.Lab03.Arrays;

import java.util.Scanner;

public class SumEvenNumbers03 {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String array = scanner.nextLine();
    String[] numbersAsStrings = array.split(" ");
    int evenSum = 0;

    int[] intArray = new int[numbersAsStrings.length];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = Integer.parseInt(numbersAsStrings[i]);
            if (intArray[i] % 2 ==0) {
                evenSum+=intArray[i];
            }
        }

        System.out.println(evenSum);

    }
}
