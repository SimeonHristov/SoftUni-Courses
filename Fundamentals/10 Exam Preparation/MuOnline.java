package com.company.MidExam29February2020;

import java.util.Scanner;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int health = 100;
        int currentHealth = 100;
        int bitcoins = 0;
        int heal = 0;
        boolean isCompleted = false;
        String[] rooms = scanner.nextLine().split("\\|");

        for (int i = 0; i < rooms.length; i++) {
            String[] tokens = rooms[i].split("\\s+");
            String command = tokens[0];
            int value = Integer.parseInt(tokens[1]);
            int bestRoom = i +1;

            switch (command) {
                case "potion":
                    if (currentHealth + value > 100) {
                        heal= health - currentHealth;
                        currentHealth = 100;

                        System.out.printf("You healed for %d hp.%n",heal);
                        System.out.printf("Current health: %d hp.%n",currentHealth);
                    } else{
                        heal= value;
                        currentHealth += value;
                        System.out.printf("You healed for %d hp.%n",heal);
                        System.out.printf("Current health: %d hp.%n",currentHealth);
                    }
                    break;
                case "chest":
                    bitcoins += value;
                    System.out.printf("You found %d bitcoins.%n",value);
                    break;
                default:
                    if (currentHealth - value > 0) {
                        currentHealth -= value;
                        System.out.printf("You slayed %s.%n",tokens[0]);
                    } else {
                        System.out.printf("You died! Killed by %s.%n",tokens[0]);
                        System.out.printf("Best room: %d", bestRoom);
                        return;
                    }
                    break;
            }
            if (i == rooms.length -1){
                isCompleted = true;
            }
        }

        if (isCompleted) {
            System.out.println("You've made it!");
            System.out.println("Bitcoins: " + bitcoins);
            System.out.println("Health: " + currentHealth);
        }
    }
}
