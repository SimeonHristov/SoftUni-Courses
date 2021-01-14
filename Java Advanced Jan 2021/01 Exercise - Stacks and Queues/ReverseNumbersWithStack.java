package StacksAndQueuesEXERCISE_02;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ReverseNumbersWithStack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();
        List<Integer> inputData = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        for (Integer num : inputData) {
            numbersStack.push(num);
        }

        while (!numbersStack.isEmpty()){
            System.out.print(numbersStack.pop() + " ");
        }

    }
}
