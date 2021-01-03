package com.company.Lab01;

import java.util.Scanner;

public class RefactorSumOddNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = Integer.parseInt(sc.nextLine());
        int count = 0;
        int sum = 0;

        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (count >= n){
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
