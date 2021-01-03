package com.company.Exercise03.Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] inputNumbers = input.split(" ");

        int[] numbers = new int[inputNumbers.length];
        for (int i = 0; i < numbers.length ; i++) {
            numbers[i] = Integer.parseInt(inputNumbers[i]);
        }

        int rotations = scanner.nextInt();

        for (int i = 1; i <= rotations; i++) {
            int firstNum = numbers[0];
            for (int j = 0; j < numbers.length -1; j++) {
                numbers[j] = numbers[j+1];
            }
            numbers[numbers.length - 1] = firstNum;
        }

        for (int number: numbers) {
            System.out.print(number + " ");
        }
    }
}
