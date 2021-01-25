package Lab06;

import java.util.Scanner;

public class CinemaTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String movieName =scanner.nextLine();

        double student = 0;
        double kid = 0;
        double standard = 0;
        int totalTickets = 0;
        double soldTicketsPerMovie = 0;

        while (!movieName.equals("Finish")) {
            int freeSpace = Integer.parseInt(scanner.nextLine());
            soldTicketsPerMovie++;

            for (int i = 1; i <= freeSpace ; i++) {
                String type = scanner.nextLine();
                if (type.equals("student")){
                    student++;
                }
                if (type.equals("standard")) {
                    standard++;
                }
                if (type.equals("kid")) {
                    kid++;
                }
                if (type.equals("End")) {
                    break;
                }

                totalTickets++;
            }
            double percent = soldTicketsPerMovie/freeSpace * 100;
            System.out.printf("%s - %.2f%% full%n",movieName,percent);
            movieName = scanner.nextLine();
        }
        System.out.printf("Total tickets: %d%n",totalTickets);

        System.out.printf("%.2f%% student tickets.%n",student/totalTickets * 100);
        System.out.printf("%.2f%% standard tickets.%n",standard/totalTickets * 100);
        System.out.printf("%.2f%% kid tickets.",kid/totalTickets * 100);
    }
}
