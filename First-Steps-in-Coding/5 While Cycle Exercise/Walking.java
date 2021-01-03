package Exercise05;

import java.util.Scanner;

public class Walking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    int target = 10000;
    int dailyTotal = 0;

    while (dailyTotal < target) {
        String input = scanner.nextLine();
            if (input.equals("Going home")){
                int currentSteps = Integer.parseInt(scanner.nextLine());
                dailyTotal = dailyTotal + currentSteps;
                break;
            }
             dailyTotal = dailyTotal + Integer.parseInt(input);
       }
        if (dailyTotal >= target) {
            System.out.printf("Goal reached! Good job!%n%d steps over the goal!", Math.abs(dailyTotal - target));
        } else {
            System.out.printf("%d more steps to reach goal.",Math.abs(dailyTotal-target));
        }
    }
}