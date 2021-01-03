package com.company.Exercise05.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> handOne = Arrays.stream(scanner.nextLine()
                .split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> handTwo = Arrays.stream(scanner.nextLine()
                .split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toList());


        while (!(handOne.isEmpty() || handTwo .isEmpty())){
            int currentNumberHandOne = handOne.get(0);
            int currentNumberHandTwo = handTwo.get(0);

            handOne.remove(0);
            handTwo.remove(0);
            if (currentNumberHandOne > currentNumberHandTwo){
                handOne.add(currentNumberHandOne);
                handOne.add(currentNumberHandTwo);
            }else if (currentNumberHandTwo > currentNumberHandOne) {
                handTwo.add(currentNumberHandTwo);
                handTwo.add(currentNumberHandOne);
            }


        }
        int sum = 0;

        if (!handOne.isEmpty()) {
            for (Integer integer : handOne) {
                sum+=integer;
            }
            System.out.printf("First player wins! Sum: %d",sum);
        } else if (!handTwo.isEmpty()){
            for (Integer integer : handTwo  ) {
                sum+=integer;
        }
        System.out.printf("Second player wins! Sum: %d",sum);
    }
}
}


