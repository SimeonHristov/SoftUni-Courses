package _12_DefiningClasses_Exercise;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P01_OpinionPoll {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


    List<Person> people = new ArrayList<>();

    int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]));
            people.add(person);
        }

    people.stream().filter(p -> p.age> 30)
            .sorted((p1,p2) -> p1.name.compareTo(p2.name)).forEach(p -> System.out.println(p.toString()));

    }
}
