package StreamsFilesAndDirectories_EXERCISE_08;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GetFolderSize {


    private static final String DIR_PATH = "C:\\Users\\st0rm\\IdeaProjects\\Java Advanced - Jan 2021\\src\\StreamsFilesAndDirectories_EXERCISE_08\\resources\\Exercises Resources";
    //private static final String SECOND_OUTPUT_PATH = "C:\\Users\\st0rm\\IdeaProjects\\Java Advanced - Jan 2021\\src\\StreamsFilesAndDirectories_EXERCISE_08\\resources\\Exercises Resources\\inputTwo.txt";
    private static final String OUTPUT_PATH = "C:\\Users\\st0rm\\IdeaProjects\\Java Advanced - Jan 2021\\src\\StreamsFilesAndDirectories_EXERCISE_08\\resources\\Exercises Resources\\results.txt";

    public static void main(String[] args) {

        try (PrintWriter writer = new PrintWriter(OUTPUT_PATH)) {

            File folder = new File(DIR_PATH);
            File[] files = folder.listFiles();
            int size = 0;
            if (files != null) {
                for (File file : files) {
                    size += file.length();
                }
            }
            writer.println("Folder size: "+size);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
