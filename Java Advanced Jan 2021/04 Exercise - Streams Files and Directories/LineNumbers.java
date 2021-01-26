package StreamsFilesAndDirectories_EXERCISE_08;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LineNumbers {
    private static final String INPUT_PATH = "C:\\Users\\st0rm\\IdeaProjects\\Java Advanced - Jan 2021\\src\\StreamsFilesAndDirectories_EXERCISE_08\\resources\\Exercises Resources\\inputLineNumbers.txt";
    private static final String OUTPUT_PATH = "C:\\Users\\st0rm\\IdeaProjects\\Java Advanced - Jan 2021\\src\\StreamsFilesAndDirectories_EXERCISE_08\\resources\\Exercises Resources\\output.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH));
             PrintWriter writer = new PrintWriter(OUTPUT_PATH)) {

            String line = reader.readLine();
            int number = 1;
            while (line != null) {
                writer.println(String.format("%d. %s",number, line));
                number++;
                line = reader.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


}
