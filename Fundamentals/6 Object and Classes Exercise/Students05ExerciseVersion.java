package com.company.Exercise06ObjectClasses;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.DoubleBinaryOperator;

public class Students05ExerciseVersion {
    static class Student {
        String firstName;
        String lastName;
        double grade;

        public Student(String firstName, String lastName, double grade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }

        public String studentInfo (){
            return String.format("%s %s: %.2f",getFirstName(),getLastName(),getGrade());
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public double getGrade() {
            return grade;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Student> allStudents = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String firstName = tokens[0];
            String lastName = tokens[1];
            double grade = Double.parseDouble(tokens[2]);

            Student student = new Student(firstName,lastName,grade);
            allStudents.add(student);
        }

        allStudents.stream()
                .sorted((s1,s2) -> Double.compare(s2.getGrade(),s1.getGrade()))
                .forEach(student -> System.out.println(student.studentInfo()));
    }

}
