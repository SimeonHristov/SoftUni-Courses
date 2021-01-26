package StreamsFilesAndDirectories_LAB_07;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class P03_CopyBytes {

    private static final String INPUT_PATH = "C:\\Users\\st0rm\\IdeaProjects\\Java Advanced - Jan 2021\\src\\StreamsFilesAndDirectories_LAB_07\\resources\\input.txt";
    private static final String OUTPUT_PATH = "C:\\Users\\st0rm\\IdeaProjects\\Java Advanced - Jan 2021\\src\\StreamsFilesAndDirectories_LAB_07\\resources\\output.txt";

    public static void main(String[] args) throws IOException {

        try (FileInputStream inputStream = new FileInputStream(INPUT_PATH);
             FileOutputStream outputStream = new FileOutputStream(OUTPUT_PATH);
             PrintWriter writer = new PrintWriter(outputStream)) {
            int singleByte = inputStream.read();

            while (singleByte >= 0) {

               if(singleByte == 10 || singleByte ==32) {
                   writer.print((char)singleByte);
               } else {
                   writer.print(singleByte);
               }
                singleByte = inputStream.read();
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
