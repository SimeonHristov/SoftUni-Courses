package Exercise02;

import java.util.Scanner;

public class GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        double extra = Double.parseDouble(scanner.nextLine());
        double clothesPerExtra = Double.parseDouble(scanner.nextLine());

        double clothesTotal = extra * clothesPerExtra;
        double decor = budget * 0.10;

        if (extra > 150) {
            clothesTotal = clothesTotal - clothesTotal * 0.10;
        }

        double totalExpnses = decor + clothesTotal;

        if (totalExpnses > budget) {
            System.out.printf("Not enough money!%n");
            System.out.printf("Wingard needs %.2f leva more.",Math.abs(budget-totalExpnses));
        } else  {
            System.out.printf("Action!%n");
            System.out.printf("Wingard starts filming with %.2f leva left.",Math.abs(budget-totalExpnses));
        }


    }
}
