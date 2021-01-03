package testExam20_21April;

import java.util.Scanner;

public class EasterParty_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int guests = Integer.parseInt(scanner.nextLine());
        double coverCharge = Double.parseDouble(scanner.nextLine());
        double budget = Double.parseDouble(scanner.nextLine());
        double cakePrice = budget * 0.1;

        if (guests > 20){
            coverCharge = coverCharge * 0.75;
        } else if (guests > 15) {
            coverCharge = coverCharge * 0.8;
        } else if (guests >= 10){
            coverCharge = coverCharge * 0.85;
        }

        double partyCost = coverCharge * guests + cakePrice;
        if (budget >= partyCost) {
            System.out.printf("It is party time! %.2f leva left.",budget-partyCost);
        } else {
            System.out.printf("No party! %.2f leva needed.",partyCost-budget);
        }

    }
}
