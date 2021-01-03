package com.company.Lab02;

import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        for (int i = 1; i <= n; i++) {
            int sumOfdigits = 0;
            int number = i;
            while (number>0) {
                sumOfdigits += number % 10;
                number  = number/10;
            }

            if (sumOfdigits == 5 || sumOfdigits == 7 || sumOfdigits == 11){
                System.out.println(i + " -> True");
            } else {
                System.out.println(i + " -> False");
            }
        }
    }
}
