package com.company.MidExam5July2020;

import java.util.*;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sumNum = 0;
        boolean toPrint = false;
        for (int i = 0; i <numbers.length ; i++) {
            sumNum += numbers[i];
        }
        double averageNum = sumNum * 1.0/numbers.length;

        List<Integer> numbersToList = new ArrayList();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > averageNum) {
                numbersToList.add(numbers[i]);
                toPrint = true;
            }
        }

        Collections.sort(numbersToList);
        Collections.reverse(numbersToList);
        if (!toPrint){
            System.out.println("No");
        } else {
            for (int i = 0; i < numbersToList.size(); i++) {
                if (i > 4) {
                    break;
                }
                System.out.print(numbersToList.get(i) + " ");
            }
        }
    }
}


