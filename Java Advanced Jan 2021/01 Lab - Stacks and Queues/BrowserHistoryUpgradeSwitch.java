package StacksAndQueuesLAB_01;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BrowserHistoryUpgradeSwitch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String output = "";
        Deque<String> stack = new ArrayDeque<>();
        Deque<String> queue = new ArrayDeque<>();
        String input = scanner.nextLine();
        while (!input.equals("Home")) {
            switch (input) {
                case "forward":
                    if (queue.isEmpty()) {
                        output = "no next URLs";

                    } else {
                        output = queue.poll();
                        stack.push(output);
                    }
                    break;
                case "back":
                    if (stack.size() < 2) {
                        output = "no previous URLs";
                    } else {
                        output = stack.pop();
                        queue.addFirst(output);
                        output = stack.peek();
                    }
                    break;
                default:
                    stack.push(input);
                    output = input;
                    queue.clear();
                    break;
            }
            System.out.println(output);
            input = scanner.nextLine();

        }

    }
}