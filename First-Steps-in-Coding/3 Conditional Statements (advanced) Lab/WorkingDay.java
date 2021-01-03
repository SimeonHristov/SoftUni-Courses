package Lab03;

import java.util.Scanner;

public class WorkingDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String day = scanner.nextLine();

        if (day.equals("Monday") || day.equals("Tuesday")|| day.equals("Wednesday")|| day.equals("Thursday")|| day.equals("Friday")) {
            System.out.printf("Working day");
        } else if (day.equals("Saturday") || day.equals("Sunday")) {
            System.out.println("Weekend");
        } else {
            System.out.println("Error");
        }


    }
}

//Напишете програма която, чете ден от седмицата (текст), на английски
// език - въведен от потребителя. Ако денят е работен отпечатва на конзолата - "Working day", ако е почивен - "Weekend".
// Ако се въведе текст различен от ден от седмицата да се отпечата - "Error".