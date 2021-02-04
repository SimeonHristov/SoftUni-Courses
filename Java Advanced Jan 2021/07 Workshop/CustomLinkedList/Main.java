package _13_Workshop.CustomLinkedList;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomLinkedList customLinkedList = new CustomLinkedList();

        for (int i = 0; i < 5; i++) {
            customLinkedList.addFirst(i + 1);
        }

        for (int i = 6; i < 10; i++) {
            customLinkedList.addLast(i);
        }

        System.out.println(customLinkedList.removeLast());
    }
}
