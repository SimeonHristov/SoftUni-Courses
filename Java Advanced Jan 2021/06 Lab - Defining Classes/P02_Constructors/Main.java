package _11_DefiningClasses_LAB.P02_Constructors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int carsCount = Integer.parseInt(bufferedReader.readLine());

        IntStream.rangeClosed(1, carsCount)
                .boxed()
                .map(input -> {
                    try {
                        return bufferedReader.readLine().split("\\s+");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                }).map(lines -> {
            Car car = null;
            if (lines.length == 3) {
                car = new Car(lines[0], lines[1], Integer.parseInt(lines[2]));
            } else {
                car = new Car(lines[0]);
            }
            return car;
        })
                .forEach(System.out::println);

    }
}