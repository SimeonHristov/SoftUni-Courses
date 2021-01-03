package exam22_August;

import java.util.Scanner;

public class Illidan {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        int personalStrength = Integer.parseInt(scanner.nextLine());
        int illidanHealth = Integer.parseInt(scanner.nextLine());

        int totalStrength = people * personalStrength;

        if (totalStrength >= illidanHealth){
            System.out.printf("Illidan has been slain! You defeated him with %d points.",totalStrength-illidanHealth);
        } else {
            System.out.printf("You are not prepared! You need %d more points.",illidanHealth-totalStrength);
        }


    }
}
