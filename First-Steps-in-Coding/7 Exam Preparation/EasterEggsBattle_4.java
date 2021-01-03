package testExam20_21April;

import java.util.Scanner;

public class EasterEggsBattle_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int eggsPlayerOne = Integer.parseInt(scanner.nextLine());
        int eggsPlayerTwo = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("End of battle")){
            if (input.equals("one")){
                eggsPlayerTwo -= 1;
            } else if (input.equals("two")){
                eggsPlayerOne -= 1;
            }

            if (eggsPlayerOne <= 0) {
                System.out.printf("Player one is out of eggs. Player two has %d eggs left.",eggsPlayerTwo);
                return;
            } else if (eggsPlayerTwo <= 0){
                System.out.printf("Player two is out of eggs. Player one has %d eggs left.",eggsPlayerOne);
                return;
            }

            input = scanner.nextLine();
        }
        System.out.printf("Player one has %d eggs left.%n",eggsPlayerOne);
        System.out.printf("Player two has %d eggs left.",eggsPlayerTwo);
    }
}
