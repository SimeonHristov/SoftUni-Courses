package _10_FunctionalProgramming_EXERCISE;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P05_ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());

        //1st option
        Collections.reverse(numbers);
        numbers.stream().filter(e -> e % n != 0).forEach(e -> System.out.print(e + " "));

        //2nd option
        Predicate<Integer> predicate = e -> e % n != 0;
        numbers.stream().filter(predicate).forEach(e -> System.out.print(e + " "));

        //3rd option
        Function<List<Integer>, List<Integer>> excludeFunction = list ->
                list.stream().filter(predicate).collect(Collectors.toList());

        numbers = excludeFunction.apply(numbers);
        numbers.stream().filter(e -> e % n != 0).forEach(e -> System.out.print(e + " "));

        //4th option
        Consumer<Integer> consumer = e -> System.out.print(e + " ");
        numbers.stream().filter(e -> e % n != 0).forEach(consumer);
    }
}
