package com.company.Exercise04.Methods;

import java.util.Scanner;

public class CharsInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char first = scanner.nextLine().charAt(0);
        char second = scanner.nextLine().charAt(0);

       getCharInRange(first,second);

    }

    public static void getCharInRange (char first, char second){

        if (first < second) {
            for (char i = (char) (first+1); i < (char) (second) ; i++) {
                System.out.print(i + " ");
            }
        } else {
            for (char i = (char) (second+1); i < (char) (first) ; i++) {
                System.out.print(i + " ");
            }
        }


    }
}
