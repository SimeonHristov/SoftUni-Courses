package StacksAndQueuesLAB_01;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MathHotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] tokens = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());
        int count = 1;

        ArrayDeque<String> children = new ArrayDeque<>();
        Collections.addAll(children, tokens);
        while (children.size() > 1) {
            for (int i = 1; i < n; i++) {
                children.offer(children.poll());
            }
            if (isPrime(count)) {
                System.out.println("Prime " + children.peek());
            } else {
                System.out.println("Removed " + children.poll());
            }
            count++;
        }
        String lastName = children.poll();
        System.out.println("Last is " + lastName);
    }

    private static boolean isPrime(int count) {
        boolean result = true;
        if (count == 0 || count == 1) {
            result = false;
        } else {
            for (int i = 2; i < Math.sqrt(count); i++) {
                if (count % i == 0) {
                    result = false;
                }

            }
        }
        return result;
    }
}
