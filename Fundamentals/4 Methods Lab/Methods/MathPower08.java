package com.company.Lab04.Methods;

import java.util.Scanner;

public class MathPower08 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double num = Double.parseDouble(scanner.nextLine());
        double num2 = Double.parseDouble(scanner.nextLine());

        System.out.println(result(num, num2));

    }

    public  static double result (double num,double num2){
        double result = Math.pow(num,num2);
        return result;
    }
}
