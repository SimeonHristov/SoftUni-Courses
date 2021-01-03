package com.company.Exercise06ObjectClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderByAge07 {
    static class people {
        String name;
        String id;
        int age;

        public people(String name, String id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        public String toString (){
            return String.format("%s with ID: %s is %d years old.",getName(),getId(),getAge());
        }

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }

        public int getAge() {
            return age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<people> allPeople = new ArrayList<>();

        while (!input.equals("End")){
            String[] data = input.split("\\s+");
            String name = data[0];
            String id = data[1];
            int age = Integer.parseInt(data[2]);

            people newPerson = new people(name,id,age);
            allPeople.add(newPerson);

            input = scanner.nextLine();
        }

        allPeople.stream()
                .sorted((p1,p2)-> Integer.compare(p1.getAge(),p2.getAge()))
                .forEach(newPerson-> System.out.println(newPerson.toString()));
    }

}
