package testExam28_29March;

import java.util.Scanner;

public class XmasTournament {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());

        double totalMoney = 0;
        int dayWon = 0;
        int dayLost = 0;


        for (int i = 1; i <= days; i++) {
            String input = scanner.nextLine();
            int wins = 0;
            int loses = 0;
            double moneyWonPerDay = 0;

            while (!input.equals("Finish")) {
                String result = scanner.nextLine();

                if (result.equals("win")) {
                    moneyWonPerDay += 20;
                    wins++;
                } else {
                    loses++;
                }
                input = scanner.nextLine();
            }
            if (wins > loses) {
                moneyWonPerDay *= 1.1;
                dayWon++;
            } else {
                dayLost++;
            }
            totalMoney += moneyWonPerDay;
        }
        if (dayWon > dayLost){
            totalMoney *= 1.2;
            System.out.printf("You won the tournament! Total raised money: %.2f",totalMoney);
        } else {
            System.out.printf("You lost the tournament! Total raised money: %.2f",totalMoney);
        }

    }
}

