package com.company.Exercise05.Lists;

import java.util.ArrayList;
import java.util.Scanner;

public class HouseParty03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int invites = Integer.parseInt(scanner.nextLine());
        ArrayList<String> people = new ArrayList<>();

        for (int i = 0; i < invites; i++) {
            String input = scanner.nextLine();
            String[] goingOrNot = input.split("\\s+");

            if (goingOrNot[2].equals("not")) {
                if (!people.contains(goingOrNot[0])){
                    System.out.println(goingOrNot[0]+ " is not in the list!");
                } else {
                    people.remove(goingOrNot[0]);
                }
            } else {
                if (people.contains(goingOrNot[0])){
                    System.out.println(goingOrNot[0] + " is already in the list!");;
                } else {
                    people.add(goingOrNot[0]);
                }
            }
        }

        for (String person : people) {
            System.out.println(person);
        }
    }
}
