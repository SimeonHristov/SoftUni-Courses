package com.company.Lab07AssociativeArrays07;

import java.util.Arrays;
import java.util.Scanner;

public class Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        List<Integer> nums = Arrays.stream(scanner.nextLine()
//                .split(" "))
//                .map(a -> Integer.parseInt(a))
//                .sorted((x, y) -> Integer.compare(y, x))
//                .limit(3)
//                .collect(Collectors.toList());

//        for (Integer num : nums) {
//            System.out.print(num + " ");
//        }

         Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(a -> Integer.parseInt(a))
                .sorted((x, y) -> Integer.compare(y, x))
                .limit(3)
                .forEach(a -> System.out.print(a + " "));

    }
}
