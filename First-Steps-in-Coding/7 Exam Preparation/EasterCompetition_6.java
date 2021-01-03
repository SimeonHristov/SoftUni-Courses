package testExam20_21April;

import java.util.Scanner;

public class EasterCompetition_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int easterBread = Integer.parseInt(scanner.nextLine());
        String leader = "";
        int totalGrades = 0;
        int currentGrade = 0;


        for (int i = 1; i <= easterBread ; i++) {
            String backerName = scanner.nextLine();
            String input = scanner.nextLine();

            while (!input.equals("Stop")) {
                int grade = Integer.parseInt(input);

                currentGrade += grade;

                input = scanner.nextLine();
            }
            System.out.printf("%s has %d points.%n",backerName,currentGrade);

            if (currentGrade > totalGrades) {
                totalGrades = currentGrade;
                leader = backerName;
                System.out.printf("%s is the new number 1!%n",leader);
            }

            currentGrade = 0;
        }

        System.out.printf("%s won competition with %d points!",leader,totalGrades);
    }
}
