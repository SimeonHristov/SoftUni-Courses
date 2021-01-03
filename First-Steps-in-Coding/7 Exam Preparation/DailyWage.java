package exam30_August;

import java.util.Scanner;

public class DailyWage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int row = Integer.parseInt(scanner.nextLine());
        int positions = Integer.parseInt(scanner.nextLine());
        double profit = 0;

        for (int i = 1; i <= row ; i++) {
            for (int j = 1; j <= positions ; j++) {
                if (i % 2 != 0){
                    profit+= 3.50;
                } else if (i % 2 == 0 && j % 3 != 0){
                    profit+= 5.0;
                }
            }
            
        }

        double total = profit * 0.8;
        System.out.printf("Total: %.2f lv.",total);
        
    }
}
