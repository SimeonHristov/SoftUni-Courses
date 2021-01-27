package _10_FunctionalProgramming_EXERCISE;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P07_FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        //1st option
        Function<List<Integer>, Integer> getLastIndexOfMinElement = list -> list.lastIndexOf(list.stream().min(Integer::compareTo).get());

        System.out.println(getLastIndexOfMinElement.apply(numbers));

        //vxod - 123 10 11 3


        //2nd option
        System.out.println(getMin(numbers));
    }

    //2nd option with Method
    public static  int getMin (List<Integer> list) {
        return list.stream().min(Integer::compareTo).get();
    }
}
