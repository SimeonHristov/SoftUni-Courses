package Exercise02;

import java.sql.Time;
import java.util.Scanner;

public class TimePlus15Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        int hours2minutes = hours * 60;
        int totalMinutes = hours2minutes + minutes + 15;

        int finalHour = totalMinutes / 60;
        int finalMinutes = totalMinutes % 60;

        if (finalHour > 23) {
            finalHour = 0;
        }

        if (finalMinutes < 10) {
            System.out.printf("%d:0%d", finalHour,finalMinutes);
        } else {
            System.out.printf("%d:%d",finalHour,finalMinutes);
        }

    }
}
