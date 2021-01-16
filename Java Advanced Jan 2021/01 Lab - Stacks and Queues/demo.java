package StacksAndQueuesLAB_01;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Random;
import java.util.Scanner;

public class demo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<String> test = new ArrayDeque<>();
        String[] qwe = new String[]{"qwe", "abv", "zxc"};

        for (int i = 0; i < 3; i++) {
            test.addFirst(qwe[i]);
        }

        for (String s : test) {
            System.out.println(test.pop());
        }
    }
}