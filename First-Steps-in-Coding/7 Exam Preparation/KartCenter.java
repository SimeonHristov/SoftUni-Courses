package exam30_August;

import java.util.Scanner;

public class KartCenter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double sum = Double.parseDouble(scanner.nextLine());
        String laps = scanner.nextLine();
        String fanCard = scanner.nextLine();
        String kartType = scanner.nextLine();

        double price = 0;

        if (laps.equals("five")){
            switch (kartType){
                case "Child":
                    price = 7;
                    break;
                case "Junior":
                    price = 9;
                    break;
                case "Adult":
                    price = 12;
                    break;
                case "Profi":
                    price = 18;
                    break;
            }
        } else if (laps.equals("ten")) {
            switch (kartType){
                case "Child":
                    price = 11;
                    break;
                case "Junior":
                    price = 16;
                    break;
                case "Adult":
                    price = 21;
                    break;
                case "Profi":
                    price = 32;
                    break;
            }
        }

        if (fanCard.equals("yes")){
            price = price * 0.8;
        }

        if (sum >= price){
            System.out.printf("You bought %s ticket for %s laps. Your change is %.2flv.",kartType,laps,sum-price);
        } else {
            System.out.printf("You don't have enough money! You need %.2flv more.",price-sum);
        }
    }
}
