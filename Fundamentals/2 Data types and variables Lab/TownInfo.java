package com.company.Lab02;

import java.util.Scanner;

public class TownInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String town = scanner.nextLine();
        long population = scanner.nextLong();
        int area = scanner.nextInt();

        System.out.printf("Town %s has population of %d and area %d square km.",town,population,area);
    }
}
