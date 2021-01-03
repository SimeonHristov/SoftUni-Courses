package Lab03;

import java.util.Scanner;

public class WorkingHours {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hour = Integer.parseInt(scanner.nextLine());
        String day = scanner.nextLine();

        if (hour >= 10 && hour <= 18 && !day.equals("Sunday")) {
            System.out.printf("open");
        } else {
            System.out.printf("closed");
        }
    }
}


/*7.	Работно време
        Да се напише програма, която чете час от денонощието(цяло число) и ден
        от седмицата(текст) - въведени от потребителя и проверява дали
        офисът на фирма е отворен, като работното време на офисът е от 10-18
        часа, от понеделник до събота включително*/
