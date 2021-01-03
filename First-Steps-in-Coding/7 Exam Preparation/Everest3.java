package exam22_August;

import java.util.Scanner;

public class Everest3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = "";
        int meters = 0;
        int newMeters = 0;
        int days = 1;
        int i = 0;

        for (i = 5364; i < 8848; i += meters){
            command = scanner.nextLine();

            if (!command.equals("END")){
                meters = Integer.parseInt(scanner.nextLine());
            }
            if (command.equals("Yes")){
                days++;
            }
            if (command.equals("END")|| days > 5){
                break;
            }
            if (newMeters >= 8848){
                break;
            }
            newMeters=meters + i;

        }
        if (i>= 8848 && days <= 5){
            System.out.printf("Goal reached for %d days!",days);
        } else{
            System.out.println("Failed!");
            System.out.printf("%d",newMeters);
        }

    }
}

