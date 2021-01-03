package com.company.Lab06.ObjectClasses;

import java.util.Random;
import java.util.Scanner;

public class RandomWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] words = scanner.nextLine().split("\\s+");
        Random rnd = new Random();

        for (int i = 0; i < words.length; i++) {
            int x = rnd.nextInt(words.length);
            int y = rnd.nextInt(words.length);
            String temp = words[x];
            words[x] = words[y];
            words[y] = temp;

        }

        for (String word : words) {
            System.out.println(word);
        }

    }
}
