package Exercise03;

import java.util.Scanner;

public class FishBoatVer3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        int fishermen = Integer.parseInt(scanner.nextLine());

        double price = 0;


        if (season.equals("Summer") || season.equals("Autumn")){
            price = 4200 ;
        } else if (season.equals("Spring")) {
            price = 3000 ;
        } else if (season.equals("Winter")) {
            price = 2600;
        }

        if (fishermen <=6) {
            price = price * 0.9;
        } else if (fishermen <=11) {
            price = price * 0.85;
        } else {
            price = price * 0.75;
        }

        if (fishermen % 2 == 0 && !season.equals("Autumn")) {
            price = price * 0.95;
        }

        if (budget >= price) {
            System.out.printf("Yes! You have %.2f leva left.", Math.abs(budget-price));
        } else  {
            System.out.printf("Not enough money! You need %.2f leva.",Math.abs(budget-price));
        }
}

}