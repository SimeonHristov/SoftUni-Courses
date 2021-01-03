package com.company.Exercise03.Arrays;

import java.util.Scanner;

public class EqualSums06 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String [] inputNumbers = input.split(" ");

        int [] numbers = new int [inputNumbers.length];
        for (int i = 0; i < inputNumbers.length; i++) {
            numbers[i] = Integer.parseInt(inputNumbers[i]);
        }


        //if numbers[0] || numbers[inputNumbers.length-1]
        //System.out.println('0');

        boolean isEqual = false;
        for (int i = 0; i < numbers.length; i++) {
            int leftSum = 0;
            int rightSum = 0;
            //int currentIndex = i;

            for (int j = i-1; j>=0 ; j--) {
                leftSum += numbers[j];
            }
            for (int j = i + 1; j < numbers.length ; j++) {
                rightSum += numbers[j];
            }

            if (leftSum==rightSum){
                System.out.println(i);
                isEqual=true;
                break;
            }
        }

        if (!isEqual){
            System.out.println("no");
        }
    }
}
