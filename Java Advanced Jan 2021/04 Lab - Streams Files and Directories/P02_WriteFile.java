package StreamsFilesAndDirectories_LAB_07;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P02_WriteFile {

    private static final String INPUT_PATH = "C:\\Users\\st0rm\\IdeaProjects\\Java Advanced - Jan 2021\\src\\StreamsFilesAndDirectories_LAB_07\\resources\\input.txt";
    private static final String OUTPUT_PATH = "C:\\Users\\st0rm\\IdeaProjects\\Java Advanced - Jan 2021\\src\\StreamsFilesAndDirectories_LAB_07\\resources\\output.txt";

    public static void main(String[] args) throws IOException {
        Set<Character> punct = new HashSet<>();
        punct.add(',');
        punct.add('.');
        punct.add('!');
        punct.add('?');


        try (FileInputStream inputStream = new FileInputStream(INPUT_PATH);
             FileOutputStream outputStream = new FileOutputStream(OUTPUT_PATH);
             PrintWriter writer = new PrintWriter(outputStream)) {
            int singleByte = inputStream.read();

            while (singleByte >= 0) {

                char symbol = (char) singleByte;
                if (!punct.contains(symbol)) {
                    writer.print(symbol);
                }

                singleByte = inputStream.read();
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}