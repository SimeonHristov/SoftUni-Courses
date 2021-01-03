package com.company.Exercise05.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChangeList02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);



        String[] inputAsNumbers = scanner.nextLine().split("\\s+");

        ArrayList<String> numbers = new ArrayList<>();
        for (String number : inputAsNumbers) {
            numbers.add(number);
        }

        String input = scanner.nextLine();
        while (!input.equals("end")) {

            String[] commands = input.split("\\s+");

            if (commands[0].equals("Delete")) {
                while(numbers.contains(commands[1])) {
                    numbers.remove(commands[1]);
                }
            } else if (commands[0].equals("Insert")) {
                String element = commands[1];
                int index = Integer.parseInt(commands[2]);
                if (index < numbers.size()) {
                    numbers.add(index, element);
                }
            }

            input =  scanner.nextLine();
        }

        System.out.print(String.join(" ", numbers));
//        for (Integer number : numbers) {
//            System.out.println(number);
//        }
    }
}
