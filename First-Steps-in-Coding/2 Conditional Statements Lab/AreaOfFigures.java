package Lab02;

import java.util.Scanner;

public class AreaOfFigures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String figure = scanner.nextLine();

        if (figure.equals("square")) {
            double lenght = Double.parseDouble(scanner.nextLine());
            double squareArea = lenght * lenght;
            System.out.printf("%.3f",squareArea);
        } else if (figure.equals("rectangle")) {
            double recLenOne = Double.parseDouble(scanner.nextLine());
            double recLenTwo = Double.parseDouble(scanner.nextLine());
            double recArea = recLenOne * recLenTwo;
            System.out.printf("%.3f",recArea);
        } else if (figure.equals("circle")) {
            double radius = Double.parseDouble(scanner.nextLine());
            double circleArea = Math.PI*(radius*radius);
            System.out.printf("%.3f",circleArea);
        } else if (figure.equals("triangle")) {
            double triLenOne = Double.parseDouble(scanner.nextLine());
            double triLenTwo = Double.parseDouble(scanner.nextLine());
            double triArea = (triLenOne * triLenTwo)/2;
            System.out.printf("%.3f",triArea);
        } else {
            System.out.println("Try Again!");
        }
    }
}