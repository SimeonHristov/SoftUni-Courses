package StacksAndQueuesLAB;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Integer> indexesOfOpenBrackets = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char curChar = input.charAt(i);
            if (curChar == '(') {
                indexesOfOpenBrackets.push(i);
            } else if (curChar == ')') {
                System.out.println(input.substring(indexesOfOpenBrackets.pop(), i + 1));
            }
        }
    }
}
