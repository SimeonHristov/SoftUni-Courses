package testExam20_21April;

import java.util.Scanner;

public class EasterDecoration_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int clients = Integer.parseInt(scanner.nextLine());



        double basketCost = 1.50;
        double wreathCost = 3.80;
        double chocoBunny = 7;
        double averageBill = 0;
        double billAllClients = 0;


        for (int i = 1; i <= clients ; i++) {
            int itemCount = 0;
            double bill = 0;

            String input = scanner.nextLine();
            while (!input.equals("Finish")){
                String itemPurchased = input;
                itemCount++;
                if (itemPurchased.equals("basket")) {
                    bill += basketCost;
                }
                if (itemPurchased.equals("wreath")){
                    bill +=wreathCost;
                }
                if (itemPurchased.equals("chocolate bunny")){
                    bill += chocoBunny;
                }

                input = scanner.nextLine();
            }
            if (itemCount % 2 ==0){
                bill = bill * 0.80;
            }
            billAllClients += bill;
            System.out.printf("You purchased %d items for %.2f leva.%n",itemCount,bill);

        }
        System.out.printf("Average bill per client is: %.2f leva.",billAllClients / clients);
    }
}

