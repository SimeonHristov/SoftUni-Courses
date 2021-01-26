package StreamsFilesAndDirectories_LAB_07;


import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class P04_ExtractIntegers {

    private static final String INPUT_PATH = "C:\\Users\\st0rm\\IdeaProjects\\Java Advanced - Jan 2021\\src\\StreamsFilesAndDirectories_LAB_07\\resources\\input.txt";
    private static final String OUTPUT_PATH = "C:\\Users\\st0rm\\IdeaProjects\\Java Advanced - Jan 2021\\src\\StreamsFilesAndDirectories_LAB_07\\resources\\output.txt";

    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(INPUT_PATH);

        Scanner scanner = new Scanner(inputStream);

        FileWriter writer = new FileWriter(OUTPUT_PATH);

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                writer.write(String.valueOf(num));
                writer.write(System.lineSeparator());
            }

            scanner.next();

            }

            writer.flush();
            writer.close();
        }
    }
