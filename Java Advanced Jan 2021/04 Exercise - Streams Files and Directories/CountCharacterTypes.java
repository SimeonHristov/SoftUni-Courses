package StreamsFilesAndDirectories_EXERCISE_08;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Set;

public class CountCharacterTypes {

    private static final String INPUT_PATH = "C:\\Users\\st0rm\\IdeaProjects\\Java Advanced - Jan 2021\\src\\StreamsFilesAndDirectories_EXERCISE_08\\resources\\Exercises Resources\\input.txt";
    private static final String OUTPUT_PATH = "C:\\Users\\st0rm\\IdeaProjects\\Java Advanced - Jan 2021\\src\\StreamsFilesAndDirectories_EXERCISE_08\\resources\\Exercises Resources\\output.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH));
             PrintWriter writer = new PrintWriter(OUTPUT_PATH)) {

            Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
            Set<Character> punctionationMarks = Set.of('!', ',', '.', '?');
            int vowelsCount = 0;
            int consonantsCount = 0;
            int punctionationMarksCount = 0;


            String line = reader.readLine();
            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    char symbol = line.charAt(i);
                    if (vowels.contains(symbol)) {
                        vowelsCount++;
                    } else if (punctionationMarks.contains(symbol)) {
                        punctionationMarksCount++;
                    } else if (symbol != ' ') {
                        consonantsCount++;
                    }
                }
                line = reader.readLine();
            }

            writer.println("Vowels: " + vowelsCount);
            writer.println("Consonants: " + consonantsCount);
            writer.println("Punctuation: " + punctionationMarksCount);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
