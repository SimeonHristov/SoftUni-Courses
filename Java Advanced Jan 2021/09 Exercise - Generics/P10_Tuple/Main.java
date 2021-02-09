package _15_Generics_EXERCISE.P10_Tuple;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] tokens = scanner.nextLine().split("\\s+");
        String name = String.format("%s %s",tokens[0],tokens[1]);
        String address = tokens[2];
        Tuple<String, String> tuple = new Tuple<>(name,address);
        System.out.println(tuple);

        tokens = tokens = scanner.nextLine().split("\\s+");
        name = tokens[0];
        int liters = Integer.parseInt(tokens[1]);
        Tuple<String, Integer> personBeer = new Tuple<>(name,liters);
        System.out.println(personBeer);

        tokens = tokens = scanner.nextLine().split("\\s+");
        int intNum = Integer.parseInt(tokens[0]);
        double floatNum = Double.parseDouble(tokens[1]);
        Tuple<Integer, Double> numbers = new Tuple<>(intNum,floatNum);
        System.out.println(numbers);

    }



}
