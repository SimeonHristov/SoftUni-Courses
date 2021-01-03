package exam30_August;

import java.util.Scanner;

public class KartRankList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        //int min = Integer.parseInt(scanner.nextLine());
        //int sec = Integer.parseInt(scanner.nextLine());


        int goldCardCount = 0;
        int silverCardCount = 0;
        int bronzeCardCount = 0;
        String winner = "";
        int bestTime = Integer.MAX_VALUE;
        int winnerMin = 0;
        int winnerSec = 0;

        while (!name.equals("Finish")){
            int min = Integer.parseInt(scanner.nextLine());
            int sec = Integer.parseInt(scanner.nextLine());
            int totalTime = min * 60 + sec;

            if (totalTime < 55){
                goldCardCount++;
            } else if (totalTime <= 85){
                silverCardCount++;
            } else if (totalTime <=120){
                bronzeCardCount++;
            }

            if (totalTime < bestTime){
                bestTime = totalTime;
                winner = name;
                winnerMin = min;
                winnerSec = sec;
            }


            name = scanner.nextLine();
        }

        System.out.printf("With %d minutes and %d seconds %s is the winner of the day!%n",winnerMin,winnerSec,winner);
        System.out.printf("Today's prizes are %d Gold %d Silver and %d Bronze cards!",goldCardCount,silverCardCount,bronzeCardCount);

    }
}
