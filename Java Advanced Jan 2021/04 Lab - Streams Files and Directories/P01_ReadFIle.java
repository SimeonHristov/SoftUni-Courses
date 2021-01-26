package StreamsFilesAndDirectories_LAB_07;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class P01_ReadFIle {
    public static void main(String[] args) {

        String path = "C:\\Users\\st0rm\\IdeaProjects\\Java Advanced - Jan 2021\\src\\StreamsFilesAndDirectories_LAB_07\\resources\\input.txt";

        try (FileInputStream fileStream = new FileInputStream(path)) {
            Scanner scanner = new Scanner(System.in);
            int oneByte = fileStream.read();
            while (oneByte > 0) {
                System.out.printf("%s ",Integer.toBinaryString(oneByte));
                oneByte = fileStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
