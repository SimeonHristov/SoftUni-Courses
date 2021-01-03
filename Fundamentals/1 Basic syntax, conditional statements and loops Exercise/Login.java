package com.company.Exercise01;

import javax.swing.*;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine(); //Acer
        int length = username.length(); //4
        String password = ""; //empty string

        for (int i = length-1; i >= 0 ; i--) {

            password += username.charAt(i); // recA
        }

        for (int i = 0; i < 4 ; i++) {
            String input = scanner.nextLine();

            if (input.equals(password)){
                System.out.printf("User %s logged in.",username);
                break;
            } else if (!input.equals(password) && i < 3){
                System.out.println("Incorrect password. Try again.");
            } else if (!input.equals(password) && i == 3){
                System.out.printf("User %s blocked!",username);
                break;
            }
        }
    }
}
