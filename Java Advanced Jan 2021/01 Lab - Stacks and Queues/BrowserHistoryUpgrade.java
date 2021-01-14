package StacksAndQueuesLAB_01;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String command = scanner.nextLine();
        String currentURL = null;
        String previousURL = null;

        ArrayDeque<String> websites = new ArrayDeque();

        while (!command.equals("Home")) {

            if (command.equals("back")) {
                if (websites.isEmpty()) {
                    System.out.println("no previous URLs");
                    command = scanner.nextLine();
                    continue;
                } else {
                    currentURL = websites.pop();
                    previousURL = command;
                }
            } else if (command.equals("forward")) {
                if (currentURL==null) {
                    System.out.println("no next URLs");
                }

                //websites.addFirst();
            } else {
                if (currentURL != null) {
                    websites.push(currentURL);
                }
                currentURL = command;
            }

            System.out.println(currentURL);
            command = scanner.nextLine();
        }

    }

}
