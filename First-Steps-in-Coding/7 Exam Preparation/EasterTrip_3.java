package testExam20_21April;

import java.util.Scanner;

public class EasterTrip_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String destination = scanner.nextLine();
        String dates = scanner.nextLine();
        int overnightCount = Integer.parseInt(scanner.nextLine());
        double overnightCost = 0;


        if (dates.equals("21-23")){
            switch (destination){
                case "France":
                    overnightCost = overnightCount * 30;
                    break;
                case "Italy":
                    overnightCost = overnightCount * 28;
                    break;
                case "Germany":
                    overnightCost = overnightCount * 32;
                    break;
            }
        } else if (dates.equals("24-27")){
            switch (destination){
                case "France":
                    overnightCost = overnightCount * 35;
                    break;
                case "Italy":
                    overnightCost = overnightCount * 32;
                    break;
                case "Germany":
                    overnightCost = overnightCount * 37;
                    break;
            }
        } else if (dates.equals("28-31")){
            switch (destination){
                case "France":
                    overnightCost = overnightCount * 40;
                    break;
                case "Italy":
                    overnightCost = overnightCount * 39;
                    break;
                case "Germany":
                    overnightCost = overnightCount * 43;
                    break;
            }
        }

        System.out.printf("Easter trip to %s : %.2f leva.",destination,overnightCost);
    }
}
