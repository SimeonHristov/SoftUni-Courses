package testExam20_21April;

import java.util.Scanner;

public class EasterGuests_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double guests = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());
        double kozunak = Math.ceil(guests/ 3);
        double eggs = guests * 2;

        double kozunakCost =  kozunak * 4;
        double eggsCost = eggs * 0.45;

        double totalCost = kozunakCost + eggsCost;

        if (budget>= totalCost){
            System.out.printf("Lyubo bought %.0f Easter bread and %.0f eggs.%n",kozunak,eggs);
            System.out.printf("He has %.2f lv. left.",budget-totalCost);
        } else {
            System.out.println("Lyubo doesn't have enough money.");
            System.out.printf("He needs %.2f lv. more.",totalCost-budget);
        }

    }
}
