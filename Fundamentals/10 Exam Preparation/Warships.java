package com.company.MidExamREAL07112020;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Warships {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] pirateShip = scanner.nextLine().split(">");
        String[] warShip = scanner.nextLine().split(">");

        List<Integer> pirates = new ArrayList<>();
        List<Integer> warriors = new ArrayList<>();

        for (int i = 0; i < pirateShip.length; i++) {
            pirates.add(Integer.parseInt(pirateShip[i]));
        }

        for (int i = 0; i < warShip.length; i++) {
            warriors.add(Integer.parseInt(warShip[i]));
        }
        int maxHealth = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();
        boolean shouldBrake = false;

        while (!command.equals("Retire")) {
            String[] tokens = command.split(" ");
            String whatToDo = tokens[0];

            if (whatToDo.equals("Fire")) {
                int index = Integer.parseInt(tokens[1]);
                int dmg = Integer.parseInt(tokens[2]);

                if (index >= 0 && index < warriors.size()) {
                    int sum = warriors.get(index) - dmg;
                    if (sum <= 0) {
                        System.out.println("You won! The enemy ship has sunken.");
                        shouldBrake = true;

                    } else {
                        warriors.remove(index);
                        warriors.add(index, sum);
                    }

                }

                if (shouldBrake) {
                    break;
                }

            } else if (whatToDo.equals("Defend")) {
                int startIndex = Integer.parseInt(tokens[1]);
                int endIndex = Integer.parseInt(tokens[2]);
                int dmg = Integer.parseInt(tokens[3]);

                if (startIndex >= 0 && startIndex < pirates.size()) {
                    if (endIndex >= 0 && endIndex < pirates.size()) {
                        for (int i = startIndex; i <= endIndex; i++) {
                            int sum = 0;
                            sum = pirates.get(i) - dmg;
                            if (sum <= 0) {
                                System.out.println("You lost! The pirate ship has sunken.");
                                shouldBrake = true;
                                break;
                            }
                            pirates.remove(i);
                            pirates.add(i, sum);
                        }
                    }
                }


                if (shouldBrake) {
                    break;
                }

            } else if (whatToDo.equals("Repair")) {
                int index = Integer.parseInt(tokens[1]);
                int health = Integer.parseInt(tokens[2]);

                if (index >= 0 && index < pirates.size()) {
                    int sum = health + pirates.get(index);
                    if (sum <= maxHealth) {
                        pirates.remove(index);
                        pirates.add(index, sum);
                    } else {
                        pirates.remove(index);
                        pirates.add(index, maxHealth);
                    }
                }

            } else if (whatToDo.equals("Status")) {
                int pirateSum = 0;

                for (int i = 0; i < pirates.size(); i++) {
                    if (pirates.get(i) < maxHealth * 0.2) {
                        pirateSum++;
                    }

                }
                System.out.println(pirateSum + " sections need repair.");

            }


            command = scanner.nextLine();
        }


        if (!shouldBrake) {
            int pirateSum = 0;
            int warriorsSum = 0;

            for (int i = 0; i < pirates.size(); i++) {
                pirateSum += pirates.get(i);
            }


            for (int i = 0; i < warriors.size(); i++) {
                warriorsSum += warriors.get(i);
            }

            System.out.println("Pirate ship status: " + pirateSum);
            System.out.println("Warship status: " + warriorsSum);
        }
    }
}
