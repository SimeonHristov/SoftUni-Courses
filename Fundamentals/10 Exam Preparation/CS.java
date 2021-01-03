package com.company.MidExam07April2020;

import java.util.Scanner;

public class CS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        int battlesWon = 0;

        String input = scanner.nextLine();

        while (!input.equals("End of battle")) {
            int distance = Integer.parseInt(input);

            if (energy >= distance) {
                battlesWon++;
                if (battlesWon % 3 == 0) {
                    energy += battlesWon;
                }
                energy -= distance;
            } else {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", battlesWon, energy);
                return;
            }

            input = scanner.nextLine();
        }
        System.out.printf("Won battles: %d. Energy left: %d",battlesWon,energy);
    }
}
