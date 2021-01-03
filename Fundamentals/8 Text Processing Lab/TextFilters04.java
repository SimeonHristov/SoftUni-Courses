package com.company.Lab08.TextProcessing;

import java.util.Scanner;

public class TextFilters04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String bannedWord : bannedWords) {
            text = text.replace(bannedWord, repeatStuff("*",bannedWord.length()));
        }

        System.out.println(text);


    }

    private static String repeatStuff(String word, int count) {
        String [] repeatArr = new String[count];
        for (int i = 0; i < count ; i++) {
            repeatArr[i] = word;
        }
        return String.join("",repeatArr);
    }
}
