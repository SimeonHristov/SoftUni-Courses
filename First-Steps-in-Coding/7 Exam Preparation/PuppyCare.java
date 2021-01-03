package testExam28_29March;

import java.util.Scanner;

public class PuppyCare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int foodBought = Integer.parseInt(scanner.nextLine());
        int foodBoughGrams = foodBought * 1000;
        int foodEaten = 0;

        String input = scanner.nextLine();

        while (!input.equals("Adopted")){
            int dailyRation = Integer.parseInt(input);
            foodEaten += dailyRation;
            input = scanner.nextLine();
        }

        if (foodBoughGrams >= foodEaten) {
            System.out.printf("Food is enough! Leftovers: %d grams.",foodBoughGrams-foodEaten);
        } else {
            System.out.printf("Food is not enough. You need %d grams more.",Math.abs(foodBoughGrams-foodEaten));
        }
    }
}
