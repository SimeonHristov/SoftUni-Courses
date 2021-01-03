package com.company.Lab08.TextProcessing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RepeatStrigns02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        StringBuilder result = new StringBuilder();
        for (String s : input) {
            int count = s.length();
            for (int i = 0; i < count; i++) {
                result.append(s);
            }
        }

        System.out.println(result);
    }
}
