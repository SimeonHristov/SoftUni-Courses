package com.company.MidExamREAL07112020;

import java.time.chrono.MinguoDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AngryPet {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int entryPoint = Integer.parseInt(scanner.nextLine());
        String itemType = scanner.nextLine();
        String priceType = scanner.nextLine();
        int leftDmg = 0;
        int rightDmg = 0;


        for (int i = 0; i < entryPoint; i++) {
            switch (itemType) {
                case "cheap":
                    if (priceType.equals("positive")) {
                        if (numbers.get(i) < numbers.get(entryPoint) && numbers.get(i) >= 0) {
                            leftDmg += numbers.get(i);
                        }
                    } else if (priceType.equals("negative")) {
                        if (numbers.get(i) < numbers.get(entryPoint) && numbers.get(i) < 0) {
                            leftDmg += numbers.get(i);
                        }
                    } else if ((numbers.get(i) < numbers.get(entryPoint))) {
                        leftDmg += numbers.get(i);
                    }
                    continue;
                case "expensive":
                    if (priceType.equals("positive")) {
                        if (numbers.get(i) >= numbers.get(entryPoint) && numbers.get(i) >= 0) {
                            leftDmg += numbers.get(i);
                        }
                    } else if (priceType.equals("negative")) {
                        if (numbers.get(i) >= numbers.get(entryPoint) && numbers.get(i) < 0) {
                            leftDmg += numbers.get(i);
                        }
                    } else if ((numbers.get(i) >= numbers.get(entryPoint))) {
                        leftDmg += numbers.get(i);
                    }
                    break;
            }
        }

        for (int i = entryPoint + 1; i < numbers.size(); i++) {
            switch (itemType) {
                case "cheap":
                    if (priceType.equals("positive")) {
                        if (numbers.get(i) < numbers.get(entryPoint) && numbers.get(i) >= 0) {
                            rightDmg += numbers.get(i);
                        }
                    } else if (priceType.equals("negative")) {
                        if (numbers.get(i) < numbers.get(entryPoint) && numbers.get(i) < 0) {
                            rightDmg += numbers.get(i);
                        }
                    } else if ((numbers.get(i) < numbers.get(entryPoint))) {
                        rightDmg += numbers.get(i);
                    }
                    break;
                case "expensive":
                    if (priceType.equals("positive")) {
                        if (numbers.get(i) >= numbers.get(entryPoint) && numbers.get(i) >= 0) {
                            rightDmg += numbers.get(i);
                        }
                    } else if (priceType.equals("negative")) {
                        if (numbers.get(i) >= numbers.get(entryPoint) && numbers.get(i) < 0) {
                            rightDmg += numbers.get(i);
                        }
                    } else if ((numbers.get(i) >= numbers.get(entryPoint))) {
                        rightDmg += numbers.get(i);
                    }
                    break;

            }
        }

        if (leftDmg >= rightDmg) {
            System.out.println("Left - " + (leftDmg));
        } else {
            System.out.println("Right - " + (rightDmg));
        }

    }
}
