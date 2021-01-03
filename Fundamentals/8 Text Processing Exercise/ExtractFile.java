package com.company.Exercise08.TextProcessing;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String file = input.substring(input.lastIndexOf("\\")+1);
        String fileName = file.substring(0, file.indexOf("."));
        String fileExtension = file.substring(file.indexOf(".")+1);

        System.out.printf("File name: %s%n", fileName);
        System.out.printf("File extension: %s", fileExtension);
    }

}

