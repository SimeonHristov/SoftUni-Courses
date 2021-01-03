package com.company.Exercise08.TextProcessing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //String data = "sh, too_long_username, !lleg@l ch@rs, jeffbutt";
        String input = scanner.nextLine();
        String[] userNames = input.split(", ");


        for (String uName : userNames) {
            if (validateUsername(uName)) {
                System.out.println(uName);
            }
        }
    }


    private static boolean validateUsername (String username) {
        if(username.length() <3 || username.length() > 16){
            return  false;
        }
        for (int i = 0; i < username.length(); i++) {
            char symbol = username.charAt(i);
            if (!Character.isLetterOrDigit(symbol) && symbol != '-' && symbol != '_') {
                return  false;
            }
        }
        return true;
    }

}
