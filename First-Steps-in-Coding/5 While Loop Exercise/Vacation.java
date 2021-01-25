package Exercise05;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double requiredFunds = Double.parseDouble(scanner.nextLine());
        double availableFunds = Double.parseDouble(scanner.nextLine());

        int days = 0;
        int daysSpend = 0;

        while (availableFunds < requiredFunds) {
            String action = scanner.nextLine();
            double funds = Double.parseDouble(scanner.nextLine());
            days++;

            if (action.equals("save")) {
                availableFunds = availableFunds + funds;
                daysSpend = 0;
            } else if (action.equals("spend")) {
                if (availableFunds < funds) {
                    availableFunds = 0;
                } else {
                    availableFunds = availableFunds - funds;
                }
                //availableFunds = availableFunds - funds;
                daysSpend++;
                if (daysSpend >= 5) {
                    System.out.printf("You can't save the money.%n%d", days);
                    return;
                }
            }
        }

        System.out.printf("You saved the money for %d days.",days);
    }
}








