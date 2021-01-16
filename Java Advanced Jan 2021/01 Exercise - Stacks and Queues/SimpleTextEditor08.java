package StacksAndQueuesEXERCISE_02;

import javax.swing.plaf.IconUIResource;
import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int commandsNumber = Integer.parseInt(scanner.nextLine());
        StringBuilder text = new StringBuilder();
        ArrayDeque<String> undoStack = new ArrayDeque<>();


        for (int i = 0; i < commandsNumber; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String argument = "";
            if (tokens.length > 1) {
                argument = tokens[1];
            }

            switch (tokens[0]) {
                case "1":
                    undoStack.push(text.toString());
                    text.append(argument);
                    break;
                case "2":
                    undoStack.push(text.toString());
                    int n = Integer.parseInt(argument);
                    int start = text.length() - n;
                    text.delete(start, start + n);
                    break;
                case "3":
                    int index = Integer.parseInt(argument);
                    System.out.println(text.charAt(index - 1));
                    break;
                case "4":
                    if (!undoStack.isEmpty()) {
                        text = new StringBuilder(undoStack.pop());
                    }

                    break;
            }
        }
    }
}
