package StacksAndQueuesEXERCISE_02;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        //int max = Integer.MIN_VALUE;

        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            switch (tokens[0]) {
                case "1":
                    numbersStack.push(Integer.parseInt(tokens[1]));
                    break;

                case "2":
                    if (!numbersStack.isEmpty()) {
                        numbersStack.poll();
                    }
                    break;

                case "3":
//                    while (!numbersStack.isEmpty()) {
//                        int currentNum = numbersStack.poll();
//                        if (currentNum > max) {
//                            max = currentNum;
//                        }
//                    }
                    Integer maxNum = Collections.max(numbersStack);
                    System.out.println(maxNum);
                    break;

            }

        }


    }
}
