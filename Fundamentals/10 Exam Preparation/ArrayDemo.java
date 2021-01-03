package com.company.MidExamREAL07112020;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayDemo {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        int entryPoint = Integer.parseInt(scanner.nextLine());




    }
}