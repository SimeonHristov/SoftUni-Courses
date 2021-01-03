package com.company.MidExam07April2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();
        int targetsShot = 0;
        boolean isShot = false;

        while (!input.equals("End")) {
            int targetIndex = Integer.parseInt(input);

            if (targetIndex >= 0 && targetIndex < numbers.size()) {
                int increaseDecrease = numbers.get(targetIndex);
                //TODO !isShot
                numbers.set(targetIndex, -1);
                targetsShot++;
                isShot = true;

                for (int i = 0; i < numbers.size(); i++) {
                    if (i != targetIndex){
                        if (numbers.get(i) > increaseDecrease){
                            numbers.set(i, numbers.get(i)-increaseDecrease);
                        } else {
                            numbers.set(i, numbers.get(i)+increaseDecrease);
                        }
                    }
                }
            }



            input = scanner.nextLine();
        }

        System.out.println(numbers.get(0));
    }
}
