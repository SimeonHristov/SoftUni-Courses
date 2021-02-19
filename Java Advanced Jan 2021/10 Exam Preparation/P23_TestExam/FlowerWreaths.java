package _18_ExamPreparation.P23_TestExam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(lilies::push);

        ArrayDeque<Integer> roses = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(roses::offer);

        int flowerWreaths = 0;
        int flowers = 0;

        while (!lilies.isEmpty() && !roses.isEmpty()) {
            int currentLilly = lilies.poll();
            int currentRose = roses.pop();
            int sum = currentLilly + currentRose;

            if (sum > 15) {
                lilies.offer(currentLilly - 2);
                roses.push(currentRose);
            } else if (sum == 15) {
                flowerWreaths++;
            } else if (sum < 15) {
                flowers += sum;
            }
        }

        flowerWreaths += (flowers / 15);

        if (flowerWreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!",flowerWreaths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - flowerWreaths);
        }
    }
}
