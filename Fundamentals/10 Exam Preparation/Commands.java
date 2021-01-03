package com.company.MidExamREAL07112020;

//import java.util.*;
//import java.util.stream.Collectors;
//import java.util.Arrays;

import java.util.*;
import java.util.stream.Collectors;

public class Commands {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {
                case "reverse":
                    int start = Integer.parseInt(tokens[2]);
                    int count = Integer.parseInt(tokens[4]);

                    for (int i = 0; i < count; i++) {
                        int temp = numbers.get(start);
                        numbers.remove(start);
                        numbers.add((start + count - 1 - i), temp);
                    }
                    break;
                case "sort":
                    int sortStart = Integer.parseInt(tokens[2]);
                    int sortEnd = sortStart + Integer.parseInt(tokens[4]);
                    //Collections.sort(numbers.subList(sortStart, sortEnd));
                    numbers.subList(sortStart, (sortEnd+1)).sort(Comparator.naturalOrder());

                    break;
                case "remove":
                    int itemsToRemove = Integer.parseInt(tokens[1]);
                    for (int i = 0; i < itemsToRemove; i++) {
                        numbers.remove(0);
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}
