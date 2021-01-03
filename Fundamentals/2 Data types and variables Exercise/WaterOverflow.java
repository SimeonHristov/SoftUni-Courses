package com.company.Exercise02;

import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int totalLitres = 0;

        for (int i = 0; i < n; i++) {
            int currentLitres = Integer.parseInt(scanner.nextLine());
            if (currentLitres + totalLitres > 255){
                System.out.println("Insufficient capacity!");
            } else {
                 totalLitres += currentLitres;
            }
        }
        System.out.println(totalLitres);
    }
}
