package StacksAndQueuesEXERCISE_02;

import java.net.Inet4Address;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Robotics05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split(";");
        String[] robotName = new String[data.length];
        int[] processTime = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            String[] tokens = data[i].split("-");
            String name = tokens[0];
            int time = Integer.parseInt(tokens[1]);
            robotName[i] = name;
            processTime[i] = time;
        }

        String[] time = scanner.nextLine().split(":");
        int h = Integer.parseInt(time[0]);
        int m = Integer.parseInt(time[1]);
        int s = Integer.parseInt(time[2]);
        long starTime = h * 3600 + m * 60 + s;

        ArrayDeque<String> productQue = new ArrayDeque<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            productQue.offer(input);
            input = scanner.nextLine();
        }


        int[] robotsTimeLeft = new int[robotName.length];
        while (!productQue.isEmpty()) {
            starTime++;
            String product = productQue.poll();
            int index = -1; // robot is busy

            for (int i = 0; i < robotsTimeLeft.length; i++) {
                if (robotsTimeLeft[i] > 0) {
                    robotsTimeLeft[i]--;
                }

                if (robotsTimeLeft[i] == 0 && index == -1) {
                    index = i;
                }
            }

            if (index != -1) {
                robotsTimeLeft[index] = processTime[index];
                System.out.println(printOutput(robotName[index], product, starTime));
            } else {
                productQue.offer(product);
            }
        }
    }

    private static String printOutput(String name, String product, long timeProperFormat) {
        long hours = (timeProperFormat / (60 * 60)) % 24;
        long mins = (timeProperFormat / 60) % 60;
        long secs = timeProperFormat % 60;
        String time = String.format("%02d:%02d:%02d",hours,mins,secs);
        return String.format("%s - %s [%s] ", name, product, time);
    }
}
