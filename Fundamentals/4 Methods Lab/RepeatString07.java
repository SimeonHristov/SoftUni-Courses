package com.company.Lab04.Methods;

import java.util.Scanner;

public class RepeatString07 {

    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            String input = scanner.nextLine();
            int repetitions = Integer.parseInt(scanner.nextLine());

            String result = repeatString(input, repetitions);

            System.out.println(result);
    }

    public static String repeatString(String input, int repetitions){
        String result = "";

        for (int i = 0; i < repetitions; i++) {
            result += input;
        }

        return result;

    }
}
