package testExam20_21April;

import java.util.Collections;
import java.util.Scanner;

public class EasterEggs_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int coloredEggs = Integer.parseInt(scanner.nextLine());
        int redEggs = 0;
        int orangeEggs = 0;
        int blueEggs = 0;
        int greenEggs = 0;


        for (int i = 1; i <= coloredEggs ; i++) {
            String eggColor = scanner.nextLine();

            if (eggColor.equals("red")){
                redEggs++;
            } else if (eggColor.equals("orange")){
                orangeEggs++;
            } else if (eggColor.equals("blue")){
                blueEggs++;
            } else if (eggColor.equals("green")){
                greenEggs++;
            }

        }

        String mostEggsColor = "red";
        int mostEggsCount = redEggs;

        if (orangeEggs > mostEggsCount){
            mostEggsCount=orangeEggs;
            mostEggsColor="orange";
        }
        if (blueEggs > mostEggsCount){
            mostEggsCount = blueEggs;
            mostEggsColor= "blue";
        }
        if (greenEggs > mostEggsCount){
            mostEggsCount = greenEggs;
            mostEggsColor= "green";
        }


        System.out.printf("Red eggs: %d%n",redEggs);
        System.out.printf("Orange eggs: %d%n",orangeEggs);
        System.out.printf("Blue eggs: %d%n",blueEggs);
        System.out.printf("Green eggs: %d%n",greenEggs);
        System.out.printf("Max eggs: %d -> %s",mostEggsCount,mostEggsColor);
    }
}
