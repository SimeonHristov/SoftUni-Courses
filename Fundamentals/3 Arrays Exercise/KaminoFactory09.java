package com.company.Exercise03.Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class KaminoFactory09 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // string line of numbers to int[]  --  int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int lenght = Integer.parseInt(scanner.nextLine());
        String sequence = scanner.nextLine();

        // subsequence of 1s
        // leftmost starting index
        // greater sum of elements


        while (!sequence.equals("Clone them!")) {

            int[] numbers = Arrays.stream(sequence.split("!")).mapToInt(Integer::parseInt).toArray();

            for (int num: numbers) {
                System.out.println(num);
            }
            sequence = scanner.nextLine();
        }

    }
}
