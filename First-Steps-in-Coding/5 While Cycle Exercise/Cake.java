package Exercise05;

import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lenght = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int cakePieces = lenght * width;

        String input = scanner.nextLine();

        while (!input.equals("STOP")) {
            int currentCakePieces = Integer.parseInt(input);
            cakePieces = cakePieces - currentCakePieces;
            if (cakePieces < 0) {
                break;
            }
            input = scanner.nextLine();
        }

        if (cakePieces < 0) {
            System.out.printf("No more cake left! You need %d pieces more.",Math.abs(cakePieces));
        } else {
            System.out.printf("%d pieces are left.",cakePieces);
        }

    }
}
