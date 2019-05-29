package controller;

import entity.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControllerStudent {
    private Scanner scanner = new Scanner(System.in);
    List<Student> list = new ArrayList<Student>();

    public void Add() {
        System.out.println(" EnrolID: \t");
        String enrolID = scanner.nextLine();
        System.out.println("FirstName: \t");
        String firstName = scanner.nextLine();
        System.out.println("LastName: \t");
        String lastName = scanner.nextLine();
        System.out.println("Age: \t");
        String age = scanner.nextLine();
        Student student = new Student(enrolID, firstName, lastName, age);
        list.add(student);
    }

    public void Save() {
        String fileName = "student.dat";
        try {
            BufferedWriter bufferedWriter =
                    new BufferedWriter(new FileWriter(fileName));
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("\t %-20s", "EnrollID")).append(String.format("\t %40s", "Full Name")).append(String.format(" \t %20s", "Age")).append("\n");
            for (Student st : list) {
                sb.append(String.format("\t %-20s", st.getEnrolID()))
                        .append(String.format("\t %-40s", st.getLastName() + " " + st.getFirstName()))
                        .append(String.format("\t %-20s", st.getAge()))
                        .append("\n");
            }
            bufferedWriter.write(sb.toString());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void Display() {
        String fileName = "student.dat";

        String line = null;

        try {
            BufferedReader bufferedReader =
                    new BufferedReader(new FileReader(fileName));

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}