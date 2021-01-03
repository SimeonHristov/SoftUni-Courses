package com.company.Exercise05.Lists;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Train01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        String[] lineAsNumbers = line.split(" ");

        List<Integer> wagons = new ArrayList<>();
        for (int i = 0; i < lineAsNumbers.length ; i++) {
            int number = Integer.parseInt(lineAsNumbers[i]);
            wagons.add(number);
        }

        int maxCapacity = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();
        while  (!input.equals("end")) {
            String[] commands = input.split("\\s+");

            if (commands[0].equals("Add")) {
                int passengers = Integer.parseInt(commands[1]);
                wagons.add(passengers);
            } else {
                int passengers = Integer.parseInt(commands[0]);
                for (int i = 0; i < wagons.size() ; i++) {
                    int totalPassengers = wagons.get(i)+ passengers;
                    if (totalPassengers <= maxCapacity){
                        wagons.set(i, totalPassengers);
                        break;
                    }
                }
            }
            input = scanner.nextLine();
        }

        for (Integer wagon : wagons) {
            System.out.print(wagon + " ");
        }
        /*
        for (Integer number : wagons) {
            System.out.println(number);
        }
        */
    }
}

