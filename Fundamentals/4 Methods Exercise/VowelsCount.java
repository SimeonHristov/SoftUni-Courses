package com.company.Exercise04.Methods;

import com.sun.jdi.PathSearchingVirtualMachine;

import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().toLowerCase();
        System.out.println(vowelsCount(input));

    }

    public static int vowelsCount (String input){
        int vowelsCount = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'a' ||
                    input.charAt(i) == 'e' ||
                    input.charAt(i) == 'i' ||
                    input.charAt(i) == 'o' ||
                    input.charAt(i) == 'u') {
                vowelsCount++;
            }

        }

        return vowelsCount;
    }
}
