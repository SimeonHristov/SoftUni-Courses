package com.company.Lab04.Methods;

import java.util.Scanner;

public class MultiplyEvensByOdds10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int result = getMultipleOfEvensAndOdds(number);

        System.out.println(result);
    }

    public static int getMultipleOfEvensAndOdds (int number){
        int evenSum = getSumEvens(number);
        int oddSum = getSumOdds(number);

        return evenSum * oddSum;
    }

    public static int getSumEvens (int number){
        int evenSum = 0;
        while (number > 0)
        {
            int lastDigit = number % 10;
            number = number / 10;

            if (lastDigit % 2 == 0)
            {
                evenSum += lastDigit;
            }
        }

        return evenSum;

    }

    public static int getSumOdds (int number){
        int oddSum = 0;
        while (number > 0)
        {
            int lastDigit = number % 10;
            number = number / 10;

            if (lastDigit % 2 == 0)
            {
                oddSum += lastDigit;
            }
        }

        return oddSum;
    }
}
