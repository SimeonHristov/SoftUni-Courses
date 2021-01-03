package Exercise06;

import java.util.Scanner;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i < start; i++) {

            for (int j = 1; j < start; j++) {

                for (char k = 'a'; k < 'a' + end; k++) {

                    for (char l = 'a'; l < 'a' + end; l++) {

                        for (int m = 2; m <= start ; m++) {
                            if (m > i && m > j){
                            System.out.printf("%d%d%c%c%d ",i,j,k,l,m);

                        }

                    }

                }

            }

        }
        }
    }
}
