package testExam20_21April;

import java.util.Scanner;

public class EasterShop_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int eggsInStore = Integer.parseInt(scanner.nextLine());
        int eggsSold = 0;
        String input = scanner.nextLine();

        while (!input.equals("Close")){
            int eggs = Integer.parseInt(scanner.nextLine());

            if (input.equals("Buy")){
                if (eggsInStore < eggs) {
                    System.out.println("Not enough eggs in store!");
                    System.out.printf("You can buy only %d.",eggsInStore);
                    return;
                }
                eggsInStore -= eggs;
                eggsSold += eggs;
            } else if (input.equals("Fill")){
                eggsInStore += eggs;
            }


            input = scanner.nextLine();
        }
        System.out.println("Store is closed!");
        System.out.printf("%d eggs sold.",eggsSold);
    }
}
