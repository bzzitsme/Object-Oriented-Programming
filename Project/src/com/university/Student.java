package com.university;

import java.util.Scanner;
import java.util.Vector;

public class Student extends UniversityMember{
    private double firstAttestationMark = 0;
    private double secondAttestationMark = 0;
    private double finalExam = 0;

    public Student(String firstName, String lastName, String department, String email) {
        super(firstName, lastName, department, email);
    }

    public double getFirstAttestationMark() {
        return firstAttestationMark;
    }

    public void setFirstAttestationMark(double firstAttestationMark) {
        this.firstAttestationMark = firstAttestationMark;
    }

    public double getSecondAttestationMark() {
        return secondAttestationMark;
    }

    public void setSecondAttestationMark(double secondAttestationMark) {
        this.secondAttestationMark = secondAttestationMark;
    }

    public double getFinalExam() {
        return finalExam;
    }

    public void setFinalExam(double finalExam) {
        this.finalExam = finalExam;
    }

    public static void actions() {
        System.out.println(ConsoleColors.BLACK + "1) " + ConsoleColors.BLUE + "Register to the course" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLACK + "2) " + ConsoleColors.BLUE + "Watch registered courses" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLACK + "3) " + ConsoleColors.BLUE + "Logout" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLACK + "4) " + ConsoleColors.BLUE + "Exit" + ConsoleColors.RESET);
    }

    public static void MODE(String email) {
        System.out.println(ConsoleColors.BLACK + "Current user has " + ConsoleColors.PURPLE_BOLD + "student" + ConsoleColors.BLACK + " privileges" + ConsoleColors.RESET);
        Scanner scanner = new Scanner(System.in);
        System.out.println(ConsoleColors.BLACK + "What do you want to do?" + ConsoleColors.RESET);
        try {
            Vector<Course> courses = Database.courses;
            Vector<Student> students = Database.students;
            Student currentStudent = null;
            for (Student student : students) {
                if (student.getFirstName().equals(email)) {
                    currentStudent = student;
                    break;
                }
            }
            int choice;
            while (true) {
                Vector<Course> registered = new Vector<>();
                Vector<Course> notRegistered = new Vector<>();

                for (Course course : courses) {
                    Vector<Student> studentVector = course.getStudents();
                    boolean isRegistered = false;
                    for (Student student : studentVector) {
                        if (student.getEmail().equals(email)) {
                            isRegistered = true;
                            break;
                        }
                    }
                    if (isRegistered) {
                        registered.add(course);
                    } else notRegistered.add(course);
                }

                Student.actions();
                choice = scanner.nextInt();
                if (choice == 1) {
                    /**
                     * watch unregistered courses
                     */
                    for (int i = 0; i < notRegistered.size(); i++) {
                        System.out.println(notRegistered.get(i).toString());
                        System.out.println(ConsoleColors.BLACK + String.valueOf(i + 1) + ") " + notRegistered.get(i).getCourseTitle() + ConsoleColors.RESET);
                    }
                }

                if (choice == 2) {
                    /**
                     watch registered courses;
                     */
                    for (int i = 0; i < registered.size(); i++) {
                        System.out.println(ConsoleColors.BLACK + String.valueOf(i + 1) + ") " + registered.get(i).getCourseTitle() + ConsoleColors.RESET);
                    }
                    System.out.println(ConsoleColors.BLACK + "Type course index at which you want to see grades" + ConsoleColors.RESET);
                    System.out.println(ConsoleColors.BLACK + "Type 0 if you want to return back");
                    int index = scanner.nextInt();
                    if (index == 0) {

                    } else if (index > registered.size()) {
                        System.out.println(ConsoleColors.BLACK + "Your index should be in rage of " + "1 - " + registered.size() + ConsoleColors.RESET);
                    } else if (index <= registered.size() && index > 0) {

                    }
                }

                if (choice == 3) {
                    System.out.println(ConsoleColors.RESET);
                    Database.save();
                    break;
                }
                if (choice == 4) {
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
