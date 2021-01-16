package StacksAndQueuesEXERCISE_02;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] token = scanner.nextLine().split("\\s+");
        String[] numbers = scanner.nextLine().split("\\s+");

        int n = Integer.parseInt(token[0]);
        int s = Integer.parseInt(token[1]);
        int x = Integer.parseInt(token[2]);

        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            numbersStack.push(Integer.parseInt(numbers[i]));
        }

        for (int i = 0; i < s; i++) {
            numbersStack.pop();
        }

        int min = Integer.MAX_VALUE;
        if (numbersStack.contains(x)) {
            System.out.println("true");
        } else {
            if (numbersStack.isEmpty()){
                System.out.println("0");
                return;
            }

            while (!numbersStack.isEmpty()){
                int currentNum = numbersStack.pop();
                if (currentNum < min) {
                    min = currentNum;
                }
            }
            System.out.println(min);
        }


    }
}
