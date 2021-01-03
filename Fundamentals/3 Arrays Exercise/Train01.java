package com.company.Exercise03.Arrays;

import java.util.Scanner;

public class Train01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int wagons = scanner.nextInt();
        int[] trains = new int [wagons];
        int sumPeople = 0;

        for (int i = 0; i < wagons ; i++) {
            trains[i] = scanner.nextInt();
            sumPeople+= trains[i];
        }

        for (int i = 0; i < trains.length ; i++) {
            System.out.print(trains[i] + " ");

        }
        System.out.println();
        System.out.println(sumPeople);
    }
}
