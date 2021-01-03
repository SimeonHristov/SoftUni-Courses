package com.company.FinalExamPrep04April2020;

import java.util.Scanner;

public class WorldTour01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stops = scanner.nextLine();
        StringBuilder sb = new StringBuilder(stops);

        String command = scanner.nextLine();

        while (!command.equals("Travel")) {
            String[] commandParts = command.split(":");

            switch (commandParts[0]) {
                case "Add Stop":
                    int insertIndex = Integer.parseInt(commandParts[1]);
                    if (insertIndex >= 0 && insertIndex < sb.length()) {
                        sb.insert(insertIndex, commandParts[2]);
                    }
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(commandParts[1]);
                    int endIndex = Integer.parseInt(commandParts[2]);
                    if (startIndex >= 0 && startIndex < sb.length() && endIndex >= 0 && endIndex < sb.length()) {
                        sb.replace(startIndex, endIndex + 1, "");
                    }
                    break;
                case "Switch":
                    String oldString = commandParts[1];
                    String newString = commandParts[2];
                    sb = new StringBuilder(sb.toString().replace(oldString,newString));

//                    while (sb.indexOf(oldString) != -1) {
//                        sb.replace(sb.indexOf(oldString), sb.indexOf(oldString)+oldString.length(), newString);
//                    }
                    break;
                default:
                    System.out.println("Wrong command - Try again!");
                    break;

            }
            System.out.println(sb);
            command = scanner.nextLine();
        }

        System.out.println("Ready for world tour! Planned stops: " + sb);
    }

}
