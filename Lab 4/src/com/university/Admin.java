package com.university;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class Admin {
    public static void actions() {
        System.out.println(ConsoleColors.BLACK + "What do you want to do?" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLACK + "1) " + ConsoleColors.BLUE + "Add student" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLACK + "2) " + ConsoleColors.BLUE + "Add course" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLACK + "3) " + ConsoleColors.BLUE + "Logout" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLACK + "4) " + ConsoleColors.BLUE + "Exit" + ConsoleColors.RESET);
    }

    public static void MODE() {
        File adminFile = new File("./resources/admin.txt");
        File studentFile = new File("./resources/students.txt");
        File instructorFile = new File("./resources/instructors.txt");

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date date = new Date();

        System.out.println(ConsoleColors.BLACK + "Current user has " + ConsoleColors.PURPLE_BOLD + "admin" + ConsoleColors.BLACK + " privileges" + ConsoleColors.RESET);
        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");

        try (FileWriter adminFileWriter = new FileWriter(adminFile, true);
             FileWriter studentFileWriter = new FileWriter(studentFile, true);
             FileWriter instructorFileWriter = new FileWriter(instructorFile, true)
        ) {
            adminFileWriter.write(dateFormat.format(date) + " admin logged into a system\n");
            int choice;
            while (true) {
                Admin.actions();
                choice = scanner.nextInt();
                if (choice == 1) {
                    System.out.print(ConsoleColors.BLACK + "Type student first name : ");
                    String firstName = scanner.next();

                    System.out.print("Type student last name : ");
                    String lastName = scanner.next();

                    System.out.print("Type student department : ");
                    String department = scanner.next();

                    System.out.print("Type student email : ");
                    String email = scanner.next();

                    studentFileWriter.write(email + " : " + Objects.hash("1111"));
                    studentFileWriter.write(System.lineSeparator());
                    Student student = new Student(firstName, lastName, department, email);
                    Database.addStudent(student);
                    Database.save();
                    System.out.println("Student " + ConsoleColors.PURPLE_BOLD + email + ConsoleColors.RESET + ConsoleColors.BLACK + " has been successfully added to the system" + ConsoleColors.RESET);

                } else if (choice == 2) {
                    System.out.print(ConsoleColors.BLACK + "Type course title : ");
                    String courseTitle = scanner.next();

                    System.out.print("Type the name of the book : ");
                    String bookTitle = scanner.next();
                    System.out.print("Type book author : ");
                    String bookAuthor = scanner.next();
                    System.out.print("Type isbn of the book : ");
                    String isbn = scanner.next();

                    System.out.println("Choose instructor, if they don't fit the course, type any non-index number and add new one");
                    for (int i = 0; i < Database.instructors.size(); i++) {
                        System.out.println(i + 1 + ") " + Database.instructors.get(i).lastName + " " + Database.instructors.get(i).firstName + " email : " + Database.instructors.get(i).email);
                    }
                    Instructor instructor;
                    int index = scanner.nextInt();
                    if (index > 0 && index <= Database.instructors.size()) {
                        instructor = Database.getInstructorById(index - 1);
                    } else {
                        System.out.print("Type instructor's first name : ");
                        String firstName = scanner.next();
                        System.out.print("Type instructor's last name : ");
                        String lastName = scanner.next();
                        System.out.print("Type instructor's department : ");
                        String department = scanner.next();
                        System.out.print("Type instructor's email : ");
                        String email = scanner.next();
                        instructor = new Instructor(firstName, lastName, department, email);
                        instructorFileWriter.write(instructor.getEmail() + " : " + Objects.hash("1111"));
                        instructorFileWriter.write(System.lineSeparator());
                        Database.addInstructor(instructor);
                    }

                    Textbook textbook = new Textbook(isbn, bookTitle, bookAuthor);
                    Database.addCourse(new Course(courseTitle, textbook, instructor));

                    Database.save();

                    System.out.println("The course " + courseTitle + " has been successfully added" + ConsoleColors.RESET);

                    adminFileWriter.write(dateFormat.format(date) + " admin added new course " + courseTitle + "\n");
                    adminFileWriter.write(dateFormat.format(date) + " admin added  new textbook " + bookTitle + " \n");

                } else if (choice == 3) {
                    System.out.println(ConsoleColors.RESET);
                    adminFileWriter.close();
                    instructorFileWriter.close();
                    studentFileWriter.close();
                    Database.save();
                    break;
                } else if (choice == 4) {
                    adminFileWriter.close();
                    instructorFileWriter.close();
                    studentFileWriter.close();
                    Database.save();
                    System.exit(0);
                } else {
                    System.out.println(ConsoleColors.BLACK + "You've typed wrong number \nType your number again" + ConsoleColors.RESET);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}