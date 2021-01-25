package Exercise06;

import java.util.Scanner;

public class TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleCount = Integer.parseInt(scanner.nextLine());
        String presentation = scanner.nextLine();
        //double sumCurrentGrade = 0;
        double sumAllGrade = 0;
        int countPresentation = 0;


        while (!presentation.equals("Finish")){
            countPresentation++;
            double sumCurrentGrade = 0;
            for (int i = 1; i <= peopleCount ; i++) {
                double currentGrade = Double.parseDouble(scanner.nextLine());
                sumCurrentGrade += currentGrade;
            }
            double avgGrade = sumCurrentGrade / peopleCount;
            System.out.printf("%s - %.2f.%n",presentation,avgGrade);

            sumAllGrade += avgGrade;

            presentation = scanner.nextLine();
        }

        System.out.printf("Student's final assessment is %.2f.",sumAllGrade/countPresentation);

    }
}
