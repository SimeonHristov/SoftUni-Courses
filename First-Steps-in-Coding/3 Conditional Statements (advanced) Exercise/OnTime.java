package Exercise03;

import java.util.Scanner;

public class OnTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int examHour = Integer.parseInt(scanner.nextLine());
        int examMin = Integer.parseInt(scanner.nextLine());
        int arrivalHour = Integer.parseInt(scanner.nextLine());
        int arrivalMin = Integer.parseInt(scanner.nextLine());

        int arrivalTime = arrivalHour * 60 + arrivalMin;
        int examTime = examHour * 60 + examMin;

        int hours = 0;
        int mins = 0;

        if (examTime == arrivalTime) {      //on time
            System.out.println("On time");
        } else if (examTime > arrivalTime) {  //early
            mins = examTime - arrivalTime;
            if (mins <= 30) {
                System.out.println("On time");
                System.out.printf("%d minutes before the start", mins);
            } else if (mins < 60) {
                System.out.println("Early");
                System.out.printf("%d minutes before the start", mins);
            } else {
                hours = mins / 60;
                mins = mins % 60;
                System.out.println("Early");
                System.out.printf("%d:%02d hours before the start", hours, mins);
            }
        } else {
            mins = arrivalTime - examTime;
            System.out.println("Late");
            if (mins <60){
                System.out.printf("%d minutes after the start", mins);
            } else {
                hours = mins / 60;
                mins = mins % 60;
                System.out.printf("%d:%02d hours after the start", hours, mins);
            }
        }




//
//•	 “mm minutes after the start” за закъснение под час.
//•	“hh:mm hours after the start” за закъснение от 1 час или повече. Минутите винаги печатайте с 2 цифри, например “1:03”.

    }
}
