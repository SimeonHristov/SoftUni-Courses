package StreamsFilesAndDirectories_EXERCISE_08;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCount {
    private static final String WORDS_INPUT_PATH = "C:\\Users\\st0rm\\IdeaProjects\\Java Advanced - Jan 2021\\src\\StreamsFilesAndDirectories_EXERCISE_08\\resources\\Exercises Resources\\words.txt";
    private static final String TEXT_OUTPUT_PATH = "C:\\Users\\st0rm\\IdeaProjects\\Java Advanced - Jan 2021\\src\\StreamsFilesAndDirectories_EXERCISE_08\\resources\\Exercises Resources\\text.txt";
    private static final String OUTPUT_PATH = "C:\\Users\\st0rm\\IdeaProjects\\Java Advanced - Jan 2021\\src\\StreamsFilesAndDirectories_EXERCISE_08\\resources\\Exercises Resources\\results.txt";

    public static void main(String[] args) {

        try (BufferedReader wordReader = new BufferedReader(new FileReader(WORDS_INPUT_PATH));
             BufferedReader textReader = new BufferedReader(new FileReader(TEXT_OUTPUT_PATH));
             PrintWriter writer = new PrintWriter(OUTPUT_PATH)) {

            String[] words = wordReader.readLine().split("\\s+");
            Map<String, Integer> wordOccurrences = new HashMap<>();
            for (String word : words) {
                wordOccurrences.put(word, 0);
            }

            String[] text = textReader.readLine().split("\\s+");
            for (String word : text) {
                if (wordOccurrences.containsKey(word)) {
                    wordOccurrences.putIfAbsent(word, wordOccurrences.get(word) + 1);
                }
            }
            
            wordOccurrences
                    .entrySet()
                    .stream()
                    .sorted((w1,w2) -> w2.getValue().compareTo(w1.getValue()))
                    .forEach(w -> writer.println(String.format("%s - %d",w.getKey(),w.getValue())));

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


}


