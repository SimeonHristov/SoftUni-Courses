package Lab03;

import java.util.Scanner;

public class InvalidNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        boolean value = (number >= 100 && number <= 200 || number == 0);
        //if (number >= 100 && number <= 200 || number == 0) {
        //    System.out.printf("invalid");
        //}

        //if (number <= 100 || number >= 200 || number )

        if (value != true) {
            System.out.printf("invalid");
        }
    }
}

