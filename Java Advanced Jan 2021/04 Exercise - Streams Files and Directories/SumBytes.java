package StreamsFilesAndDirectories_EXERCISE_08;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SumBytes {
    private static final String PATH = "C:\\Users\\st0rm\\IdeaProjects\\Java Advanced - Jan 2021\\src\\StreamsFilesAndDirectories_EXERCISE_08\\resources\\input.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {

            String line = reader.readLine();
            int sum = 0;
            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    sum += line.charAt(i);
                }

                line = reader.readLine();
            }
            System.out.println(sum);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


    }
}
