package Exercise03;

import java.util.Scanner;

public class HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String month = scanner.nextLine();
        int countOnNigth = Integer.parseInt(scanner.nextLine());
        //•    На първия ред е месецът – May, June, July, August, September или October

        double priceApartament = 0;
        double priceStudio = 0;


        if ((countOnNigth > 14) && (month.equals("May") || month.equals("October"))) {
            priceApartament = countOnNigth * 65.0;
            priceApartament = priceApartament - 0.10 * priceApartament;
            priceStudio = countOnNigth * 50;
            priceStudio = priceStudio - 0.30 * priceStudio;

        } else if (month.equals("May") || month.equals("October")) {
            priceApartament = countOnNigth * 65.0;
            priceStudio = countOnNigth * 50;
        }

        if ((countOnNigth > 7 && countOnNigth <= 14) && (month.equals("May") || month.equals("October"))) {

            priceStudio = countOnNigth * 50;
            priceStudio = priceStudio - 0.05 * priceStudio;

        }

        if ((countOnNigth > 14) && (month.equals("June") || month.equals("September"))) {
            priceApartament = countOnNigth * 68.70;
            priceApartament = priceApartament - 0.10 * priceApartament;
            priceStudio = countOnNigth * 75.20;
            priceStudio = priceStudio - 0.20 * priceStudio;

        } else if (month.equals("June") || month.equals("September")) {
            priceApartament = countOnNigth * 68.70;
            priceStudio = countOnNigth * 75.20;
        }


        if ((countOnNigth > 14) && (month.equals("July") || month.equals("August"))) {
            priceApartament = countOnNigth * 77.0;
            priceApartament = priceApartament - 0.10 * priceApartament;
            priceStudio = countOnNigth * 76.0;

        } else if (month.equals("July") || month.equals("August")) {
            priceApartament = countOnNigth * 77.0;
            priceStudio = countOnNigth * 76.0;

        }
        System.out.printf("Apartment: %.2f lv.", priceApartament);
        System.out.println( );
        System.out.printf("Studio: %.2f lv.", priceStudio);


    }
}



