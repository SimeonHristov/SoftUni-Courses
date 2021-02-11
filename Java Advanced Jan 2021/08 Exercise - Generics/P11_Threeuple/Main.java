package _15_Generics_EXERCISE.P11_Threeuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] tokens = scanner.nextLine().split("\\s+");
        String name = String.format("%s %s",tokens[0],tokens[1]);
        String address = tokens[2];
        String town = tokens[3];
        Threeuple<String, String, String> tuple = new Threeuple<>(name,address,town);
        System.out.println(tuple);

        tokens = tokens = scanner.nextLine().split("\\s+");
        name = tokens[0];
        int liters = Integer.parseInt(tokens[1]);
        //Boolean.parseBoolean(lines[2].equals("drunk") ? "true" : "false")));
        boolean drunkOrNot = false;
        if (tokens[2].equals("drunk")) {
            drunkOrNot = true;
        }
        Threeuple<String, Integer, Boolean> personBeer = new Threeuple<>(name,liters,drunkOrNot);
        System.out.println(personBeer);

        tokens = tokens = scanner.nextLine().split("\\s+");
        name = tokens[0];
        double floatNum = Double.parseDouble(tokens[1]);
        String bankName = tokens[2];
        Threeuple<String, Double, String> numbers = new Threeuple<>(name,floatNum,bankName);
        System.out.println(numbers);

    }



}
