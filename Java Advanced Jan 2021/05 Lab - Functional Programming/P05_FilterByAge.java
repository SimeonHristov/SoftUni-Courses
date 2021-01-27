package _09_FunctionalProgramming_LAB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P05_FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<Person> allPeople = 
        while (n > 0) {
            String[] tokens = scanner.nextLine().split(", ");
            Person dude = new Person(tokens[0], Integer.parseInt(tokens[1]));

            n--;
        }




    }

    public static class Person {

        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
