package Lab05;

import java.util.Scanner;

public class GraduationPart2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String studentName = scanner.nextLine();
        int classYear = 1;
        int excluded = 0;
        double gradeSum = 0;

        while (classYear <= 12) {
            double grade = Double.parseDouble(scanner.nextLine());
            if (grade < 4.0) {
                excluded++;
                if (excluded > 1) {
                    System.out.printf("%s has been excluded at %d grade", studentName, classYear);
                    return;
                }
                continue;
            }

            classYear++;
            gradeSum += grade;

        }
        double average = gradeSum / 12;
        System.out.printf("%s graduated. Average grade: %.2f", studentName, average);

    }
}
