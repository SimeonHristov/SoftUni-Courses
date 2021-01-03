package com.company.Lab06.ObjectClasses;

import com.sun.security.jgss.GSSUtil;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StudentsLab05 {

    static class Student {
        String firstName;
        String lastName;
        int age;
        String hometown;

        public Student(String firstName, String lastName, int age, String hometown) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.hometown = hometown;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getHometown() {
            return hometown;
        }

        public void setHometown(String hometown) {
            this.hometown = hometown;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> allStudents = new ArrayList<>();
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] inputData = input.split(" ");


            String firstName = inputData[0];
            String lastName = inputData[1];
            int age = Integer.parseInt(inputData[2]);
            String hometown = inputData[3];

            Student student = new Student(firstName, lastName, age, hometown);

            allStudents.add(student);

            input = scanner.nextLine();
        }

        String cityName = scanner.nextLine();

        List<Student> filteredStudents = allStudents.stream()
                .filter(a -> a.getHometown()
                        .equals(cityName))
                .collect(Collectors.toList());

        for (Student filteredStudent : filteredStudents) {
            System.out.printf("%s %s is %d years old%n", filteredStudent.getFirstName()
                    , filteredStudent.getLastName()
                    , filteredStudent.getAge());
//        for (Student a : allStudents) {
//            if (a.getHometown().equals(cityName)){
//                System.out.printf("%s %s is %d years old\n",a.getFirstName(),a.getLastName(),a.getAge());
//            }
//        }

        }
    }
}