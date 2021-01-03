package com.company.Lab08.TextProcessing;

import jdk.swing.interop.SwingInterOpUtils;

import java.lang.reflect.Array;
import java.util.Scanner;

public class ReverseStrings01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        //StringBuilder inputModified = new StringBuilder();


        while (!input.equals("end")) {
            String reversed = "";
            for (int i = input.length()-1; i >= 0 ; i--) {
                char x = input.charAt(i);
                reversed+= x;
            }

            System.out.printf("%s = %s%n",input,reversed);
            input = scanner.nextLine();
        }

        //System.out.println(inputModified);
    }
}
