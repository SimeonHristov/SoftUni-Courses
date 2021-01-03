package Exercise01;

import java.util.Scanner;

public class CharityCampaign {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int campaignDays = Integer.parseInt(scan.nextLine());
        int bakers = Integer.parseInt(scan.nextLine());
        int cakes = Integer.parseInt(scan.nextLine());
        int waffles = Integer.parseInt(scan.nextLine());
        int pancakes = Integer.parseInt(scan.nextLine());
        int sumCakes = cakes * 45;
        double sumWaffles = waffles * 5.80;
        double sumPancakes = pancakes * 3.20;
        double dayTotalSum = (sumCakes+sumPancakes+sumWaffles)*bakers;
        double campaignSum = (dayTotalSum*campaignDays);
        double sumAfterExpenses = campaignSum - campaignSum /8;
        System.out.printf("%.2f", sumAfterExpenses);

    }
}
