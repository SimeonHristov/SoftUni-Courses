package Lab05;

import java.util.Scanner;

public class Sequence2kPLUS1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = Integer.parseInt(scanner.nextLine());
        int y = 1;

        while (y <= x) {
            System.out.println(y);
            y = y * 2 + 1;

        }
    }
}
