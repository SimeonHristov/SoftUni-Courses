package _18_ExamPreparation.P05_LootBox;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> queueBox = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> stackBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(e -> stackBox.push(e));

        int claimedItems = 0;

        while (!queueBox.isEmpty() && !stackBox.isEmpty()) {
            int firstItem = queueBox.peek();
            int secondItem = stackBox.pop();
            int sum = firstItem + secondItem;

            if (sum % 2 == 0) {
                claimedItems += sum;
                queueBox.poll();
            } else {
                queueBox.offer(secondItem);
            }
        }

        if (queueBox.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else if (stackBox.isEmpty()) {
            System.out.println("Second lootbox is empty");
        }

        if (claimedItems >= 100) {
            System.out.println("Your loot was epic! Value: " + claimedItems);
        } else {
            System.out.println("Your loot was poor... Value: " + claimedItems);
        }

//        System.out.println(claimedItems);
    }
}
