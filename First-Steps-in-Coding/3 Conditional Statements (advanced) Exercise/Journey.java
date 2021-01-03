package Exercise03;

import java.util.Scanner;

public class Journey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String destination = "";
        double pettyCash = 0;
        String place = "";

        if (budget <= 100) {
            destination = "Bulgaria";
            if (season.equals("summer")) {
                pettyCash = budget * 0.30;
                place = "Camp";
                System.out.printf("Somewhere in %s%n%s - %.2f",destination,place,pettyCash);
            } else {
                pettyCash = budget * 0.70;
                place = "Hotel";
                System.out.printf("Somewhere in %s%n%s - %.2f",destination,place,pettyCash);
            }
        } else if (budget <= 1000) {
            destination = "Balkans";
            if (season.equals("summer")) {
                pettyCash = budget * 0.40;
                place = "Camp";
                System.out.printf("Somewhere in %s%n%s - %.2f",destination,place,pettyCash);
            } else {
                pettyCash = budget * 0.80;
                place = "Hotel";
                System.out.printf("Somewhere in %s%n%s - %.2f",destination,place,pettyCash);
            }
        } else {
            destination = "Europe";
            pettyCash = budget * 0.90;
            place = "Hotel";
            System.out.printf("Somewhere in %s%n%s - %.2f",destination,place,pettyCash);
        }
    }
}



//        Изход
//        На конзолата трябва да се отпечатат два реда.
        //•	Първи ред – "Somewhere in [дестинация]“ измежду "Bulgaria", "Balkans" и "Europe"
        //•	Втори ред – "{Вид почивка} – {Похарчена сума}"
//        o	Почивката може да е между "Camp" и "Hotel"
//        o	Сумата трябва да е закръглена с точност до вторият знак след запетаята.



