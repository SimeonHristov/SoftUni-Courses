package _09_FunctionalProgramming_LAB;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.IntStream;

public class P02_SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


     String input = scanner.nextLine();

        Function<String, Long> getCount = str -> {
            return  Arrays.stream(str.split(", ")).mapToInt(Integer::parseInt).count();
        };

        Function<String, Integer> getSum = str -> {
            return  Arrays.stream(str.split(", ")).mapToInt(Integer::parseInt).sum();
        };

      System.out.println("Count = " + getCount.apply(input));
      System.out.println("Sum = " + getSum.apply(input));


    }
}
