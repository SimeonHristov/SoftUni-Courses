package com.company.Lab04.Methods;

import java.util.Scanner;

public class PrintingTriangle03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int input = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= input; i++) {
            printLine(1,i);
        }

        for (int i = input -1 ; i >= 1 ; i--) {
            printLine(1,i);
        }

    }

    public static void printLine(int start, int end) {

        for (int i = start; i <= end ; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
//
//    //Prints upper half pattern
//        for (int i = 1; i <= input; i++) {
//        for (int j = 1; j <= i ; j++) {
//            System.out.print(j + " ");
//        }
//        System.out.println();
//    }
//
//    //prints lower half pattern
//        for (int i = input-1; i >= 1; i--)
//    {
//        for (int j = 1; j <= i; j++)
//        {
//            System.out.print(j+" ");
//        }
//        System.out.println();
//    }



}
