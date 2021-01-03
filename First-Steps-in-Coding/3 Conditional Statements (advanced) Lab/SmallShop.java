package Lab03;

import java.util.Scanner;

public class SmallShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        String city = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());

        switch (product) {
            case "coffee":
                if (city.equals("Sofia")) {
                System.out.println(quantity * 0.5);
            } else if (city.equals("Plovdiv")) {
                System.out.println(quantity * 0.4);
            } else if (city.equals("Varna")) {
                System.out.println(quantity * 0.45);
            }
                break;
            case "water":
                if (city.equals("Sofia")) {
                System.out.println(quantity * 0.8);
            } else if (city.equals("Plovdiv")) {
                System.out.println(quantity * 0.7);
            } else if (city.equals("Varna")) {
                System.out.println(quantity * 0.7);
            }
                break;
            case "beer":
                if (city.equals("Sofia")) {
                System.out.println(quantity * 1.2);
            } else if (city.equals("Plovdiv")) {
                System.out.println(quantity * 1.15);
            } else if (city.equals("Varna")) {
                System.out.println(quantity * 1.1);
            }
                break;
            case "sweets":
                if (city.equals("Sofia")) {
                System.out.println(quantity * 1.45);
            } else if (city.equals("Plovdiv")) {
                System.out.println(quantity * 1.3);
            } else if (city.equals("Varna")) {
                System.out.println(quantity * 1.35);
            }
                break;
            case "peanuts":
                if (city.equals("Sofia")) {
                System.out.println(quantity * 1.6);
            } else if (city.equals("Plovdiv")) {
                System.out.println(quantity * 1.5);
            } else if (city.equals("Varna")) {
                System.out.println(quantity * 1.55);
            }
                break;
        }
    }
}
