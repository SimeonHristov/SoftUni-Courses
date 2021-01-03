package Lab02;

import java.util.Scanner;
import java.util.function.Predicate;

public class ToyShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double tripPrice = Double.parseDouble(scanner.nextLine());
        int puzzleCount = Integer.parseInt(scanner.nextLine());
        int dollCount = Integer.parseInt(scanner.nextLine());
        int bearCount = Integer.parseInt(scanner.nextLine());
        int minionCount = Integer.parseInt(scanner.nextLine());
        int truckCount = Integer.parseInt(scanner.nextLine());

        double puzzlePrice = 2.60;
        double dollPrice = 3.00;
        double bearPrice = 4.10;
        double minionPrice = 8.20;
        double truckPrice = 2.00;

        int orderCount = puzzleCount + dollCount + bearCount + minionCount + truckCount;
        double totalPrice = (puzzleCount * puzzlePrice) + (dollCount * dollPrice) + (bearCount * bearPrice) + (minionCount * minionPrice) + (truckCount * truckPrice);

        if (orderCount >= 50) {
            totalPrice = totalPrice - totalPrice * 0.25;
        }
        //price if discount applied

        totalPrice = totalPrice - totalPrice * 0.10;
        //price after rent

        if (totalPrice >= tripPrice) {
            System.out.printf("Yes! %.2f lv left.",Math.abs(tripPrice - totalPrice));
        } else {
            System.out.printf("Not enough money! %.2f lv needed.", Math.abs(tripPrice - totalPrice));
        }
    }
}
