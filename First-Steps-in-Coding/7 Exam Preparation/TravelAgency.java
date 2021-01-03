package exam30_August;

import java.util.Scanner;

public class TravelAgency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int ticketCount = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());
        int ticketCost = Integer.parseInt(scanner.nextLine());
        int moneyNeeded = ticketCost * ticketCount;

        if (budget<moneyNeeded){
            System.out.printf("The budget of %d$ is not enough. Your client can't buy %d tickets with this budget!",budget,ticketCount);
        } else  {
            System.out.printf("You can sell your client %d tickets for the price of %d$!%n",ticketCount,moneyNeeded);
            System.out.printf("Your client should become a change of %d$!",budget-moneyNeeded);
        }




    }
}
