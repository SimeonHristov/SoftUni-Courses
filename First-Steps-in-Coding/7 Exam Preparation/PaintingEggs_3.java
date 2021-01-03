package testExam20_21April;

import java.util.Scanner;

public class PaintingEggs_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String eggSize = scanner.nextLine();
        String eggColor = scanner.nextLine();
        int eggCrates = Integer.parseInt(scanner.nextLine());
        double income = 0;

        if (eggSize.equals("Large")) {
            switch (eggColor){
                case "Red":
                    income = eggCrates * 16;
                    break;
                case "Green":
                    income = eggCrates * 12;
                    break;
                case "Yellow":
                    income = eggCrates * 9;
                    break;
            }
        } else if (eggSize.equals("Medium")) {
            switch (eggColor){
                case "Red":
                    income = eggCrates * 13;
                    break;
                case "Green":
                    income = eggCrates * 9;
                    break;
                case "Yellow":
                    income = eggCrates * 7;
                    break;
            }
        } else if (eggSize.equals("Small")) {
            switch (eggColor) {
                case "Red":
                    income = eggCrates * 9;
                    break;
                case "Green":
                    income = eggCrates * 8;
                    break;
                case "Yellow":
                    income = eggCrates * 5;
                    break;
            }
        }

        double profit = income * 0.65;

        System.out.printf("%.2f leva.",profit);

    }
}
