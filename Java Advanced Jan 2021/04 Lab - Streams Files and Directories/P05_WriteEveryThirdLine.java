package StreamsFilesAndDirectories_LAB_07;

import java.io.*;
import java.nio.Buffer;

public class P05_WriteEveryThirdLine {

    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\st0rm\\IdeaProjects\\Java Advanced - Jan 2021\\src\\StreamsFilesAndDirectories_LAB_07\\resources\\input.txt";

        BufferedReader reader = new BufferedReader(new FileReader(path));

        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\st0rm\\IdeaProjects\\Java Advanced - Jan 2021\\src\\StreamsFilesAndDirectories_LAB_07\\resources\\output.txt"));

        String line = reader.readLine();
        int lineNumber = 1;

        while (line != null) {
            lineNumber++;
            line = reader.readLine();

            if (lineNumber % 3 == 0) {
                writer.write(line);
                writer.newLine();
            }
        }

        writer.close();

    }
}
