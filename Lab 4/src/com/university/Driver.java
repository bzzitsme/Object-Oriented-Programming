package com.university;

import java.io.*;
import java.util.Objects;
import java.util.Properties;


public class Driver {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            Properties adminProperties = new Properties();
            Properties instructorProperties = new Properties();
            Properties studentProperties = new Properties();

            if (new File("./resources/courses.out").exists()) {
                Database.deserializeCourses();
            }
            if (new File("./resources/students.out").exists()) {
                Database.deserializeStudents();
            }

            if (new File("./resources/instructors.out").exists()) {
                Database.deserializeInstructors();
            }

            /**
             * for testing if its deserializes correctly (just testing)
             */
            for (Course course : Database.courses) {
                System.out.println(course.toString());
            }

            for (Student student : Database.students) {
                System.out.println(student.getEmail() + " " + student.getFirstName());
            }

            for (Instructor inst : Database.instructors) {
                System.out.println(inst.toString());
            }

            ConsoleColors.TABULATION(35);
            System.out.println(ConsoleColors.CYAN_BOLD + "Welcome to the system, please, sign in" + ConsoleColors.RESET);

            while (true) {
                System.out.print(ConsoleColors.GREEN_BOLD + "Username : ");
                String username = br.readLine();
                System.out.print("Password : " + ConsoleColors.RESET);
                String password = String.valueOf(Objects.hash(br.readLine()));

                BufferedReader admintxt = new BufferedReader(new FileReader("./resources/admin.txt"));
                BufferedReader instructortxt = new BufferedReader(new FileReader("./resources/instructors.txt"));
                BufferedReader studenttxt = new BufferedReader(new FileReader("./resources/students.txt"));


                adminProperties.load(admintxt);
                instructorProperties.load(instructortxt);
                studentProperties.load(studenttxt);

                String adminUsername = adminProperties.getProperty("username");
                String adminPassword = adminProperties.getProperty("password");

                String instructorPassword = instructorProperties.getProperty(username);
                String studentPassword = studentProperties.getProperty(username);

                if (username.equalsIgnoreCase(adminUsername) && password.equals(adminPassword)) {
                    Admin.MODE();
                } else if (password.equals(instructorPassword)) {
                    Instructor.MODE(username);
                } else if (password.equals(studentPassword)) {
                    Student.MODE(username);
                } else {
                    User.MODE();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
