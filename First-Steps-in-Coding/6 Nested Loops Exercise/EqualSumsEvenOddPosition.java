package Exercise06;

import java.util.Scanner;

public class EqualSumsEvenOddPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());

        while (num1<=num2){
            int sumEVEN = 0;
            int sumODD=0;
            int x =num1;
            for (int digit=6;digit>0;digit--){
                if (digit%2==0){
                    sumEVEN+=x%10;
                }else{
                    sumODD+=x%10;
                }
                x/=10;
            }
            if (sumEVEN==sumODD){
                System.out.print(num1 + " ");
            }
            num1++;
        }
        }
    }

