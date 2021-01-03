package exam22_August;

import java.util.Scanner;

public class Aquapark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine();
        int duration = Integer.parseInt(scanner.nextLine());
        int people = Integer.parseInt(scanner.nextLine());
        String timeOfDay = scanner.nextLine();

        //TODO discount

        double pricePerPerson =0;
        double totalPrice = 0;

        if (month.equals("march") || month.equals("april") || month.equals("may")){
            switch (timeOfDay){
                case "day":
                    //price = people * 10.50;
                    pricePerPerson = 10.50;

                    break;
                case "night":
                   // price = people * 8.4;
                    pricePerPerson = 8.4;

                    break;
            }
        } else if (month.equals("june") || month.equals("july") || month.equals("august")){
            switch (timeOfDay){
                case "day":
                   // price = people * 12.60;
                    pricePerPerson = 12.60;

                    break;
                case "night":
                   // price = people * 10.20;
                    pricePerPerson = 10.20;

                    break;
            }
        }

        if (people >= 4) {
            pricePerPerson = pricePerPerson * 0.9;
        }
        if (duration>= 5){
            pricePerPerson = pricePerPerson/2;
        }
        totalPrice=pricePerPerson*people*duration;
        System.out.printf("Price per person for one hour: %.2f%n",pricePerPerson);
        System.out.printf("Total cost of the visit: %.2f",totalPrice);
    }
}
