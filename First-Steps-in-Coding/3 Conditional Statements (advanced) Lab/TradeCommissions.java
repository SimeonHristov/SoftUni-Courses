package Lab03;

import java.util.Scanner;

public class TradeCommissions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String city = scanner.nextLine();
        double volume = Double.parseDouble(scanner.nextLine());
        double percent = 0;
        //double commission = volume * percent;

        if (volume >= 0 && volume <= 500) {
            switch (city) {
                case "Sofia":
                    percent = 0.05;
                    System.out.printf("%.2f",volume*percent);
                    break;
                case "Varna":
                    percent = 0.045;
                    System.out.printf("%.2f",volume*percent);
                    break;
                case "Plovdiv":
                    percent = 0.055;
                    System.out.printf("%.2f",volume*percent);
                    break;
                default:
                    System.out.println("error");
            }
        } else if (volume > 500 && volume <= 1000) {
            switch (city) {
                case "Sofia":
                    percent = 0.07;
                    System.out.printf("%.2f",volume*percent);
                    break;
                case "Varna":
                    percent = 0.075;
                    System.out.printf("%.2f",volume*percent);
                    break;
                case "Plovdiv":
                    percent = 0.08;
                    System.out.printf("%.2f",volume*percent);
                    break;
                default:
                    System.out.println("error");
            }
        } else if (volume > 1000 && volume <= 10000) {
            switch (city) {
                case "Sofia":
                    percent = 0.08;
                    System.out.printf("%.2f", volume*percent);
                    break;
                case "Varna":
                    percent = 0.10;
                    System.out.printf("%.2f", volume*percent);
                    break;
                case "Plovdiv":
                    percent = 0.12;
                    System.out.printf("%.2f", volume*percent);
                    break;
                default:
                    System.out.println("error");
            }
        } else if (volume > 10000) {
            switch (city) {
                case "Sofia":
                    percent = 0.12;
                    System.out.printf("%.2f", volume*percent);
                    break;
                case "Varna":
                    percent = 0.13;
                    System.out.printf("%.2f", volume*percent);
                    break;
                case "Plovdiv":
                    percent = 0.145;
                    System.out.printf("%.2f", volume*percent);
                    break;
                default:
                    System.out.println("error");
            }
        } else {
            System.out.println("error");
        }
    }
}
