package com.company.Lab04.Methods;

import javax.swing.*;
import java.util.Scanner;

public class MathOperations11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = Integer.parseInt(scanner.nextLine());
        char operator = scanner.nextLine().charAt(0);
        int n2 = Integer.parseInt(scanner.nextLine());

        System.out.println(result(n1, operator,n2));
    }

    public static int result (int n1, char operator, int n2) {
        int result = 0;
        if (operator=='/') {
            result  =n1/n2;
        } else if (operator=='*') {
            result  =n1*n2;
        } else if (operator=='+') {
            result  =n1+n2;
        } else if (operator=='-') {
            result  =n1-n2;
        }

        return  result;
    }
}
