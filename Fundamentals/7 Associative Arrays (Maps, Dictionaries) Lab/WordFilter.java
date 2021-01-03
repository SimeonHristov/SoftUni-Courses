package com.company.Lab07AssociativeArrays07;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WordFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine()
        .split(" "))
        .filter(a -> a.length() % 2 == 0).collect(Collectors.toList());

        for (String s : input) {
            System.out.println(s);
        }
    }
}
