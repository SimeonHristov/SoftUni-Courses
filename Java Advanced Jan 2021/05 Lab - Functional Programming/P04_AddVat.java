package _09_FunctionalProgramming_LAB;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P04_AddVat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UnaryOperator<Double> addVat = value -> value * 1.2;

        System.out.println("Prices with VAT:");

        String values = (String) Arrays.stream(scanner.nextLine().split(", "))
                .map(e -> String.format("%.2f", addVat.apply(Double.parseDouble(e))))
                .collect(Collectors.joining(System.lineSeparator()));

        System.out.println(values);
    }
}
