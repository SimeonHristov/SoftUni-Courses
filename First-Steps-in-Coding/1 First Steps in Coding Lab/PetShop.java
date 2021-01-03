package Lab01;

import java.util.Scanner;

public class PetShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        int dogCount = Integer.parseInt(scan.nextLine());
        int otherAnimals = Integer.parseInt(scan.nextLine());
        double dogFood = dogCount * 2.50;
        double otherFood = otherAnimals * 4.00;
        System.out.println(dogFood + otherFood + " lv.");
    }
}

