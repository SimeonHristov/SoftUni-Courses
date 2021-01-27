package _09_FunctionalProgramming_LAB;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.SplittableRandom;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P03_CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        String[] input = scanner.nextLine().split("\\s+");

        Predicate<String> checkUpperCase = str -> str != null
                && !str.isEmpty() && Character.isUpperCase(str.charAt(0));


        List<String> upperCaseWords = Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(checkUpperCase)
                .collect(Collectors.toList());

        System.out.println(upperCaseWords.size());
        System.out.println(upperCaseWords.stream().collect(Collectors.joining(System.lineSeparator())));
    }
}
