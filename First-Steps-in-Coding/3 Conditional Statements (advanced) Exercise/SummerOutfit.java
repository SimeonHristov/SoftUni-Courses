package Exercise03;

import java.util.Scanner;

public class SummerOutfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int degrees = Integer.parseInt(scanner.nextLine());
        String timeOfDay = scanner.nextLine();

        if (degrees >= 10 && degrees <= 18) {
            if (timeOfDay.equals("Morning")) {
                System.out.printf("It's %d degrees, get your Sweatshirt and Sneakers.",degrees);
            } else if (timeOfDay.equals("Afternoon")) {
                System.out.printf("It's %d degrees, get your Shirt and Moccasins.",degrees);
            } else if (timeOfDay.equals("Evening")) {
                System.out.printf("It's %d degrees, get your Shirt and Moccasins.",degrees);
            }
        } else if (degrees > 18 && degrees <= 24) {
            if (timeOfDay.equals("Morning")) {
                System.out.printf("It's %d degrees, get your Shirt and Moccasins.", degrees);
            } else if (timeOfDay.equals("Afternoon")) {
                System.out.printf("It's %d degrees, get your T-Shirt and Sandals.", degrees);
            } else if (timeOfDay.equals("Evening")) {
                System.out.printf("It's %d degrees, get your Shirt and Moccasins.", degrees);
            }
        } else if (degrees >= 25) {
            if (timeOfDay.equals("Morning")) {
                System.out.printf("It's %d degrees, get your T-Shirt and Sandals.", degrees);
            } else if (timeOfDay.equals("Afternoon")) {
                System.out.printf("It's %d degrees, get your Swim Suit and Barefoot.", degrees);
            } else if (timeOfDay.equals("Evening")) {
                System.out.printf("It's %d degrees, get your Shirt and Moccasins.", degrees);
            }
        }

        //Print : It's {градуси} degrees, get your {облекло} and {обувки}.It's {градуси} degrees, get your {облекло} and {обувки}.
    }
}
