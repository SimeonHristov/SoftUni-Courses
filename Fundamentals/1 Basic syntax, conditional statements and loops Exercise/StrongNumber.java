package com.company.Exercise01;

import java.util.Scanner;

public class StrongNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        int number = input; //TODO check if number = sumFactorial
        int factorialMultiply = 0;
        int factorial = 0;
        int factorialSum = 0;
        int currentNumber = 0;

        while(input != 0)
        {
            factorialMultiply = 1;
            factorial = 1;
            currentNumber = input % 10;

            while(factorialMultiply <= currentNumber)
            {
                factorial = factorial * factorialMultiply;
                factorialMultiply++;
            }
            factorialSum = factorialSum + factorial;
            input = input / 10;
        }

        if(factorialSum == number)
            System.out.println("yes");
        else
            System.out.println("no");

        System.out.println();
    }
}