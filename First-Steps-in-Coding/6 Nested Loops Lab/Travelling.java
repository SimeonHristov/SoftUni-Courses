package Lab06;

import java.util.Scanner;

public class Travelling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String destination = scanner.nextLine();
        int minBudget = Integer.parseInt(scanner.nextLine());
        int savings = 0;


        while (!destination.equals("End")) {
            int amount = Integer.parseInt(scanner.nextLine());
            savings =+ amount;
            if (savings > minBudget) {
                System.out.printf("Going to %s%n", destination);
                destination = scanner.nextLine();
                minBudget = Integer.parseInt(scanner.nextLine());
            }

        }

    }
}
