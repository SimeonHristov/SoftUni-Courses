package com.company.Lab03.Arrays;

import java.util.Scanner;

public class EqualArrays06 {

    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] firstArrayString = input.split(" ");

        int[] firstArray = new int[firstArrayString.length];
        for (int i = 0; i < firstArray.length; i++) {
            firstArray[i] = Integer.parseInt(firstArrayString[i]);
        }


        input = scanner.nextLine();
        String[] secondArrayString = input.split(" ");

        int[] secondArray = new int[secondArrayString.length];
        for (int i = 0; i < secondArray.length; i++) {
            secondArray[i] = Integer.parseInt(secondArrayString[i]);
        }

        boolean isIdentical = true;
        int difference = 0;
        if (firstArray.length == secondArray.length){
        for (int i = 0; i < firstArray.length; i++) {
            if (firstArray[i] != secondArray[i]){
                isIdentical = false;
                difference = i;
                break;
            }
        }

        if (isIdentical){
            int sum = 0;
            for (int number: firstArray){
                sum+=number;
            }
            System.out.printf("Arrays are identical. Sum: %d",sum);
        } else {
            System.out.printf("Arrays are not identical. Found difference at %d index.",difference);
        }

        }
    }
}
