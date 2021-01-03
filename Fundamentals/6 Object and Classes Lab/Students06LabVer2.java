package com.company.Lab06.ObjectClasses;

import java.rmi.StubNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Students06LabVer2 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> listOfStudents  = new ArrayList<>();
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] inputData = input.split(" ");


            String firstName = inputData[0];
            String lastName = inputData[1];
            int age = Integer.parseInt(inputData[2]);
            String hometown = inputData[3];

            Student student = listOfStudents.stream()
                    .filter(s->s.getFirstName().equals(firstName) &&
                            s.getLastName().equals(lastName))
                    .findFirst().orElse(null);

            if(student == null) {
                Student studentToAdd = new Student(firstName,lastName,age,hometown);
                listOfStudents.add(studentToAdd);
            } else {
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setAge(age);
                student.setHometown(hometown);
            }

            input = scanner.nextLine();
        }

        String filterCity = scanner.nextLine();
        List<Student> filteredStudents = listOfStudents .stream()
                .filter(a -> a.getHometown()
                        .equals(filterCity))
                .collect(Collectors.toList());


        for (Student a : filteredStudents) {
            System.out.printf("%s %s is %d years old%n",a.getFirstName(),a.getLastName(),a.getAge());
        }
    }

    private static boolean isStudentExisting(List<Student> students, String firstName, String lastName) {
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return true;
            }
        }
        return false;
    }

    private static Student getStudent(List<Student> students, String firstName, String lastName) {
        Student existingStudent = null;
        for (Student student : students) {
            if (student.getFirstName() == firstName && student.getLastName() == lastName) {
                existingStudent = student;
            }
        }
        return existingStudent;
    }


    public static class Student {
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

}


