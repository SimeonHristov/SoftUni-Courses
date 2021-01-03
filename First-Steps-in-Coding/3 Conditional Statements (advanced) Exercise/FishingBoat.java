package Exercise03;

import java.util.Scanner;

public class FishingBoat {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int budget = Integer.parseInt(scanner.nextLine()); // цяло число в интервала [1…8000]
        String season = scanner.nextLine(); // "Spring", "Summer", "Autumn", "Winter"
        int fishermen = Integer.parseInt(scanner.nextLine());

        double springRent = 3000;
        double summerRent = 4200;
        double autumnRent = 3000;
        double winterRent = 2600;
        //double discount = 0;
        //double additionalDiscount = 0;
        double totalPrice = 0;

        if (fishermen <= 6) {
            if (season.equals("Spring") || season.equals("Autumn")) {
                totalPrice = 3000 * 0.90;
            } else if (season.equals("Summer")) {
                totalPrice = 4200 * 0.90;
            } else if (season.equals("Winter")) {
                totalPrice = 2600 * 0.90;
            }
        } else if (fishermen >= 7 && fishermen <= 11) {
            if (season.equals("Spring") || season.equals("Autumn")) {
                totalPrice = 3000 * 0.85;
            } else if (season.equals("Summer")) {
                totalPrice = 4200 * 0.85;
            } else if (season.equals("Winter")) {
                totalPrice = 2600 * 0.85;
            }
        } else if (fishermen >= 12) {
            if (season.equals("Spring") || season.equals("Autumn")) {
                totalPrice = 3000 * 0.85;
            } else if (season.equals("Summer")) {
                totalPrice = 4200 * 0.85;
            } else if (season.equals("Winter")) {
                totalPrice = 2600 * 0.85;
            }
        }

        if (!season.equals("Autumn") && (fishermen % 2) == 0) {
            totalPrice = totalPrice * 0.95;
        }

        if (budget >= totalPrice) {
            System.out.printf("Yes! You have %.2f leva left.", budget - totalPrice);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.",totalPrice-budget);
        }

    }
}
