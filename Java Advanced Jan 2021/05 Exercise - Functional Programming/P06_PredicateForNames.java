package _10_FunctionalProgramming_EXERCISE;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class P06_PredicateForNames {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());

        String[] names = scanner.nextLine().split("\\s+");

        Predicate<String> lengthPredicate = name -> name.length() <= length;

        Arrays.stream(names).filter(lengthPredicate).forEach(e -> System.out.println(e));

    }
}


