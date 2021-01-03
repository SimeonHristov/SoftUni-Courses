package Exercise05;

import java.util.Scanner;

public class ExamPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int failedGrade = Integer.parseInt(scanner.nextLine());

        int failedTimes = 0;
        int solvedProblems = 0;
        double allSum = 0;
        String lastProblem = "";
        boolean isFailed = true;

        while (failedTimes < failedGrade) {
            String problemName = scanner.nextLine();
            if ("Enough".equals(problemName)) {
                isFailed = false;
                break;
            }
            int grade = Integer.parseInt(scanner.nextLine());
            if (grade <= 4) {
                failedTimes++;
            }
            allSum += grade;
            solvedProblems++;
            lastProblem = problemName;
        }
        if (isFailed) {
            System.out.printf("You need a break, %d poor grades.", failedGrade);
        } else {
            System.out.printf("Average score: %.2f%n", allSum / solvedProblems);
            System.out.printf("Number of problems: %d%n", solvedProblems);
            System.out.printf("Last problem: %s", lastProblem);
        }


    }
}
