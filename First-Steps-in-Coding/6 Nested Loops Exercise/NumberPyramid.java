package Exercise06;

import java.util.Scanner;

public class NumberPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int number = 1;

        for (int rows = 1; rows <= n; rows++) {
            for (int col = 1; col <= rows; col++) {
                System.out.print(number + " ");
                number++;
                if (number > n) {
                    break;
                }
            }
            if (number > n) {
                break;
            }
            System.out.println();
        }
    }
}