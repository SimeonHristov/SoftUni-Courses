package com.company.MidExamREAL07112020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WarshipsVerTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pirateShip = Arrays.stream(scanner.nextLine()
                .split("\\>"))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> warShip = Arrays.stream(scanner.nextLine()
                .split("\\>"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int maxHealth =  Integer.parseInt(scanner.nextLine());
        double needsRepair = maxHealth * 0.20;
        boolean hasSinked = false;

        String input = scanner.nextLine();
        while (!input.equals("Retire")){
        String[] tokens = input.split("\\s+");
        String command = tokens[0];

            switch (command){
                case "Fire":
                    int index = Integer.parseInt(tokens[1]);
                    int damage = Integer.parseInt(tokens[2]);
                    int temp = warShip.get(index);
                    if (index >= 0 && index < warShip.size()){
                        if (warShip.get(index) - damage < 0){
                            hasSinked = true;
                            System.out.println("You won! The enemy ship has sunken.");
                            return;
                        }
                        warShip.set(index, (temp-damage));
                    }
                    break;

//                case "Defend":
//                    int startIndex = Integer.parseInt(tokens[1]);
//                    int endIndex = Integer.parseInt(tokens[2]);
//                    int dmg = Integer.parseInt(tokens[3]);
//                    if (startIndex >= 0 && startIndex < pirateShip.size() &&
//                            endIndex >= 0 && endIndex < pirateShip.size()){
//                        for (int i = startIndex; i <= endIndex; i++)
//                        {
//                            pirateShip.set(i, ) -= damage;
//
//                            if (sectionsPirate[i] <= 0)
//                            {
//                                Console.WriteLine("You lost! The pirate ship has sunken.");
//                                lost = true;
//                                break;
//                            }
//                        }
//                    }
//                    break;
                case "Repair":
                    break;
                case "Status":
                    break;
            }

            input = scanner.nextLine();
        }


    }
}


