package com.company.Exercise01;

import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int lostGames = Integer.parseInt(scanner.nextLine());

        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        double xHeadset = lostGames /2 * headsetPrice;
        double xMouse = lostGames/3 * mousePrice;
        double xKeyboard = lostGames/6 * keyboardPrice;
        double xDisplay = lostGames/12 * displayPrice;

        double rageExp = xHeadset + xMouse + xKeyboard + xDisplay;
        System.out.printf("Rage expenses: %.2f lv.",rageExp);

    }
}
