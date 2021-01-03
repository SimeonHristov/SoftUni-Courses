package Exercise02;

import java.util.Scanner;

public class WorldSwimmingRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double recordTimeSeconds = Double.parseDouble(scanner.nextLine());
        double distanceMeters = Double.parseDouble(scanner.nextLine());
        double timeMeterDistance = Double.parseDouble(scanner.nextLine());

        double timeTotalDistance = distanceMeters * timeMeterDistance;
        double resistance = Math.floor(distanceMeters / 15) * 12.5;
        double totalTime = timeTotalDistance + resistance;

        if (totalTime < recordTimeSeconds) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.",totalTime);
        } else {
            System.out.printf("No, he failed! He was %.2f seconds slower.",Math.abs(totalTime-recordTimeSeconds));
        }

    }
}
