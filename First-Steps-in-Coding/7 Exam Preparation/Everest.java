package exam22_August;

import java.util.Scanner;

public class Everest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int currentProgress = 5364;
        int everestHeight = 8848;
        int currentDay = 1;
        boolean isFailed = false;
        boolean goalReached = false;

        while (!input.equals("END")) {
            int metersClimbed = Integer.parseInt(scanner.nextLine());
            if (input.equals("Yes")) {
                currentDay++;
            }
            if (currentDay > 5) {
                isFailed = true;
                break;
            }

            currentProgress += metersClimbed;
            if (currentProgress > everestHeight) {
                goalReached = true;
                break;
            }

            input = scanner.nextLine();

        }

        if (isFailed) {
            System.out.println("Failed!");
            System.out.println(currentProgress);
        }
        if (goalReached) {
            System.out.printf("Goal reached for %d days!", currentDay);
        }

        if (!goalReached && !isFailed) {
            System.out.println("Failed!");
            System.out.println(currentProgress);
        }
    }
}

