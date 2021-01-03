package com.company.MidExam5July2020;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] command = input.split("\\s+");

            switch (command[0]){
                case "swap":
                    swap(numbers,Integer.parseInt(command[1]),Integer.parseInt(command[2]));
                    break;
                case "multiply":
                    multiply(numbers,Integer.parseInt(command[1]),Integer.parseInt(command[2]));
                    break;
                case "decrease":
                    decrease(numbers);
                    break;


            }
            input = scanner.nextLine();
        }

    printArray(", ", numbers);
    }
    public static  void swap( int[] numbers,  int a,  int b) {
        int tmp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = tmp;
    }

    public static  void multiply( int[] numbers,  int a,  int b) {
        int tmp = numbers[a] * numbers[b];
        numbers[a] = tmp;
    }

    public static  void decrease( int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i]--;
        }
    }

    public static void printArray(String separator, int[] numbers){
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i < numbers.length -1){
                System.out.print(separator);
            }
        }
        System.out.println();
    }
}
