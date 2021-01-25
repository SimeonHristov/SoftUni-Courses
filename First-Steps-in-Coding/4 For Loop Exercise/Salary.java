package Exercise04;

import java.util.Scanner;

public class Salary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tabCount = Integer.parseInt(scanner.nextLine());
        double salary = Double.parseDouble(scanner.nextLine());


        for (int i = 0; i < tabCount ; i++) {
            String website = scanner.nextLine();

            if (website.equals("Facebook")){
                salary = salary - 150;
            } else if (website.equals("Instagram")) {
                salary = salary - 100;
            } else if (website.equals("Reddit")) {
                salary = salary - 50;
            } else

            if (salary <=0){
                break;
            }

        }
        if (salary <=0) {
            System.out.printf("You have lost your salary.");
        } else {
            System.out.printf("%.0f",salary);
        }

    }
}