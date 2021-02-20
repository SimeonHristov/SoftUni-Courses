package _18_ExamPreparation.Exam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<Integer> firstBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(firstBox::offer);

        ArrayDeque<Integer> secondBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(secondBox::push);

        int clamedItems = 0;

        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {
            int itemFirstBox = firstBox.peek();
            int itemSecondBox = secondBox.pop();
            int sum = itemFirstBox + itemSecondBox;

            if (sum % 2 ==0){
                clamedItems+= sum;
                firstBox.poll();
            } else {
                firstBox.offerLast(itemSecondBox);
            }
        }

        if (firstBox.isEmpty()) {
            System.out.println("First magic box is empty.");
        } else {
            System.out.println("Second magic box is empty.");
        }

        if (clamedItems >= 90) {
            System.out.printf("Wow, your prey was epic! Value: %d",clamedItems);
        } else {
            System.out.printf("Poor prey... Value: %d",clamedItems);
        }

    }
}
