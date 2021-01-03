package Lab01;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num = Double.parseDouble(scanner.nextLine());
        double bonusPts = 0;

        if (num <= 100){
            bonusPts = num + 10;
        } else if (num < 1000) {
            bonusPts = num + num*0.20;
        } else {
            bonusPts = num + num*0.10;
        }

        if (num % 2 == 0) {
            bonusPts = bonusPts + 1;
        }

        if (num % 5 ==0) {
            bonusPts = bonusPts + 2;
        }
        System.out.printf("%f",bonusPts);
        System.out.printf("%f",bonusPts+num);



    }
}







