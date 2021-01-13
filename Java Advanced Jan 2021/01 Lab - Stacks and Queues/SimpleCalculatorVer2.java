package StacksAndQueuesLAB;

import javax.swing.text.AsyncBoxView;
import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculatorVer2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (int i = 0; i < tokens.length; i++) {

            String token = tokens[i];
            if (Character.isDigit(token.charAt(0))){
                numbers.push(Integer.parseInt(token));
            } else {
                int firstNum = Integer.parseInt(tokens[++i]);
                int secondNum = numbers.peek();
                numbers.push(firstNum);

                int result = token.equals("+")
                        ? secondNum + firstNum
                        : secondNum - firstNum;

                numbers.push(result);
            }
        }

        System.out.println(numbers.peek());

    }
}
