package com.company.Exercise03.Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequeneceOfEqualElements07 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int[] numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();


        int counter = 1;
        int maxCount = 1;
        int index = 0;

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i]==numbers[i+1]){
                counter++;
                //maxCount = counter;
            } else {
               counter = 1;
            }

            if (counter>maxCount){
                maxCount = counter;
                index = numbers[i];
            }

        }

        for (int i = 0; i < maxCount ; i++) {
            System.out.print(index + " ");
        }

        //System.out.println(maxCount + " " + index);
        //2 1 1 2 3 3 2 2 2 1 2 1 1 1 2 3 3 3 3 2 2 2 1 2 1 1 2 3 3 2 2 2 1
    }
}