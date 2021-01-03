package com.company.Lab01;

import java.util.Scanner;

public class MultiplicationTableV2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        int multiplier = Integer.parseInt(scanner.nextLine());

        for (int i = multiplier; i <= 10 ; i++) {
            System.out.printf("%d X %d = %d%n",input,i,input*i);
        }

        if (multiplier>10){
            System.out.printf("%d X %d = %d",input,multiplier,input*multiplier);
        }
    }

}

