package com.company.Exercise06ObjectClasses;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OpinionPoll {
    static class Person {
        String name;
        int age;

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String toString (){
            return String.format("%s - %d",getName(),getAge());
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> allPeople = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Person person = new Person(input[0],Integer.parseInt(input[1]));
            allPeople.add(person);
        }

       allPeople.stream()
               .filter(person -> person.getAge() > 30)
               .sorted((p1,p2) -> p1.getName().compareTo(p2.getName()))
               .forEach(person -> System.out.println(person.toString()));

    }

}


