package com.company.Lab01;

import java.util.Scanner;

public class SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        int count = 0;
        int sum = 0;

        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (count >= input){
                break;
            }
            if (i % 2 != 0){
                System.out.println(i);
                count++;
                sum = sum + i;
            }
        }

        System.out.println("Sum: "+sum);


    }
}
