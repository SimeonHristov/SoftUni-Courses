package com.company.Lab06.ObjectClasses;

import java.math.BigInteger;
import java.util.Scanner;

public class SumBigNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger x = new BigInteger(scanner.nextLine());
        BigInteger y = new BigInteger(scanner.nextLine());

        BigInteger sum = x.add(y);
        System.out.println(sum);
    }
}
