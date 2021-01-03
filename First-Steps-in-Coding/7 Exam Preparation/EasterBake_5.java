package testExam20_21April;

import java.util.Scanner;

public class EasterBake_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int easterBread = Integer.parseInt(scanner.nextLine());
        int sugarNeeded = 0;
        int maxSugarUsed = 0;
        int flourNeeded = 0;
        int maxFlourUsed = 0;

        for (int i = 1; i <= easterBread ; i++) {
            int sugarUsed = Integer.parseInt(scanner.nextLine());
            int flourUsed = Integer.parseInt(scanner.nextLine());

            if (sugarUsed > maxSugarUsed){
                maxSugarUsed = sugarUsed;
            }
            if (flourUsed > maxFlourUsed){
                maxFlourUsed = flourUsed;
            }

            sugarNeeded += sugarUsed;
            flourNeeded += flourUsed;

        }

        double sugarPacks = Math.ceil(sugarNeeded * 1.0/ 950);
        double flourPacks = Math.ceil(flourNeeded * 1.0/ 750);

        System.out.printf("Sugar: %.0f%n",sugarPacks);
        System.out.printf("Flour: %.0f%n",flourPacks);
        System.out.printf("Max used flour is %d grams, max used sugar is %d grams.",maxFlourUsed,maxSugarUsed);
    }
}
