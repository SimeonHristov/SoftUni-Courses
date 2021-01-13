package StacksAndQueuesLAB;

import javax.swing.text.AsyncBoxView;
import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String command = scanner.nextLine();
        String currentURL = null;
        // String previousURL = "";
        ArrayDeque<String> websites = new ArrayDeque();

        while (!command.equals("Home")) {

            //String currentURL = command;
            if (command.equals("back")) {
                if (websites.isEmpty()) {
                    System.out.println("no previous URLs");
                    command = scanner.nextLine();
                    continue;
                } else {
                    currentURL = websites.pop();
                }
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
