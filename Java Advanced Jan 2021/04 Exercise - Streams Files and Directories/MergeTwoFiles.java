package StreamsFilesAndDirectories_EXERCISE_08;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MergeTwoFiles {


    private static final String FIRST_INPUT_PATH = "C:\\Users\\st0rm\\IdeaProjects\\Java Advanced - Jan 2021\\src\\StreamsFilesAndDirectories_EXERCISE_08\\resources\\Exercises Resources\\inputOne.txt";
    private static final String SECOND_OUTPUT_PATH = "C:\\Users\\st0rm\\IdeaProjects\\Java Advanced - Jan 2021\\src\\StreamsFilesAndDirectories_EXERCISE_08\\resources\\Exercises Resources\\inputTwo.txt";
    private static final String OUTPUT_PATH = "C:\\Users\\st0rm\\IdeaProjects\\Java Advanced - Jan 2021\\src\\StreamsFilesAndDirectories_EXERCISE_08\\resources\\Exercises Resources\\results.txt";

    public static void main(String[] args) {

        try (BufferedReader firstReader = new BufferedReader(new FileReader(FIRST_INPUT_PATH));
             BufferedReader secondReader = new BufferedReader(new FileReader(SECOND_OUTPUT_PATH));
             PrintWriter writer = new PrintWriter(OUTPUT_PATH)) {

            List<String> result = new ArrayList<>();

            String line = firstReader.readLine();
            while (line != null) {
                writer.println(line);
                line = firstReader.readLine();
            }

            line = secondReader.readLine();
            while (line != null) {
                writer.println(line);
                line = secondReader.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


}
