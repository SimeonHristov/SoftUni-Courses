package com.company.Exercise05.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ListOperations04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    String[] numbers = scanner.nextLine().split("\\s+");
    ArrayList<String> numbersList = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            numbersList.add(numbers[i]);
        }

    String input = scanner.nextLine();

    while (!input.equals("End")) {
        String[] operation = input.split("\\s+");

        if (operation[0].equals("Add")) {
            numbersList.add(operation[1]);
        } else if (operation[0].equals("Insert")) {
            int index = Integer.parseInt(operation[2]);
            if (index >= 0 && index<numbersList.size()) {
                numbersList.add(index, operation[1]);
            } else {
                System.out.println("Invalid index");
            }
        } else if (operation[0].equals("Remove")) {
            int index = Integer.parseInt(operation[1]);
            if (index >=0 && index<numbersList.size()) {
                numbersList.remove(index);
            } else {
                System.out.println("Invalid index");
            }
        } else if (operation[1].equals("left")){
            int count = Integer.parseInt(operation[2]);
            for (int i = 0; i < count ; i++) {
                Collections.rotate(numbersList, -1);
            }
        } else if (operation[1].equals("right")){
            int count = Integer.parseInt(operation[2]);
            for (int i = 0; i < count ; i++) {
                Collections.rotate(numbersList, +1);
            }
        }
        input = scanner.nextLine();
    }

        for (String number : numbersList) {
            System.out.print(number + " ");
        }
    }
}
