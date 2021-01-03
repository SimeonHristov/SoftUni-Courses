package com.company.Exercise03.Arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class MagicSum08 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int magicNum = Integer.parseInt(scanner.nextLine());
        int magicSum = 0;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                magicSum = numbers[i] + numbers[j];
                if (magicSum==magicNum){
                    System.out.println(numbers[i] + " " + numbers[j]);
                }
            }
              //  System.out.println();
        }


    }
}
