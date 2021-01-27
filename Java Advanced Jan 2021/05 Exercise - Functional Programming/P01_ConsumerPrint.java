package _10_FunctionalProgramming_EXERCISE;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Scanner;
import java.util.function.Consumer;

public class P01_ConsumerPrint {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<String> consumer = name -> System.out.println(name);

        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(consumer);



    }
}
