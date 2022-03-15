package com.university;

import java.io.*;
import java.util.Vector;

public class Database {
    public static Vector<Course> courses = new Vector<>();
    public static Vector<Student> students = new Vector<>();
    public static Vector<Instructor> instructors = new Vector<>();
    private static FileInputStream fis;
    private static FileOutputStream fos;
    private static ObjectOutputStream oos;
    private static ObjectInputStream ois;

    public static void save() throws IOException {
        Database.serializeCourses();
        Database.serializeStudents();
        Database.serializeInstructors();
    }

    public static boolean showCourses() {
        if (Database.courses.isEmpty()) {
            System.out.println(ConsoleColors.BLACK + "There are no courses yet" + ConsoleColors.RESET);
            return false;
        }
        System.out.println(ConsoleColors.RED_BOLD + "Type 0 to return back");
        for (int i = 0; i < Database.courses.size(); i++) {
            System.out.println(ConsoleColors.BLACK + String.valueOf(i + 1) + ") " + Database.courses.get(i).getCourseTitle() + ConsoleColors.RESET);
        }
        return true;
    }

    public static void showCourseById(int index) {
        Course course = Database.courses.get(index);
        System.out.println(ConsoleColors.BLACK + "Course name is " + course.getCourseTitle());
        System.out.println(course.getCourseTitle() + "'s instructor is " + course.getInstructor().toString());
        System.out.println(course.getCourseTitle() + "'s textbook is " + course.getTextbook().toString() + ConsoleColors.RESET);
    }

    public static void addCourse(Course course) {
        Database.courses.add(course);
    }

    public static void serializeInstructors() throws IOException {
        fos = new FileOutputStream("./resources/instructors.out");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(instructors);
        oos.close();
        fos.close();
    }

    public static void deserializeInstructors() throws IOException, ClassNotFoundException {
        fis = new FileInputStream("./resources/instructors.out");
        ois = new ObjectInputStream(fis);
        instructors = (Vector<Instructor>) ois.readObject();
        ois.close();
        fis.close();
    }

    public static void addInstructor(Instructor instructor) {
        Database.instructors.add(instructor);
    }

    public static boolean showInstructors() {
        if (Database.students.isEmpty()) {
            System.out.println("There are no instructors yet");
            return false;
        }
        for (int i = 0; i < Database.instructors.size(); i++) {
            System.out.println(i + 1 + ") " + Database.instructors.get(i));
        }
        return true;
    }

    public static Instructor getInstructorById(int index) {
        return Database.instructors.get(index);
    }


    public static void serializeCourses() throws IOException {
        fos = new FileOutputStream("./resources/courses.out");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(courses);
        oos.close();
        fos.close();
    }

    public static void deserializeCourses() throws IOException, ClassNotFoundException {
        fis = new FileInputStream("./resources/courses.out");
        ois = new ObjectInputStream(fis);
        courses = (Vector<Course>) ois.readObject();
        ois.close();
        fis.close();
    }


    public static void serializeStudents() throws IOException {
        fos = new FileOutputStream("./resources/students.out");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(students);
        oos.close();
        fos.close();
    }

    public static void deserializeStudents() throws IOException, ClassNotFoundException {
        fis = new FileInputStream("./resources/students.out");
        ois = new ObjectInputStream(fis);
        students = (Vector<Student>) ois.readObject();
        ois.close();
        fis.close();
    }

    public static void addStudent(Student student) {
        Database.students.add(student);
    }

    public static boolean showStudents() {
        if (Database.students.isEmpty()) {
            System.out.println("There are no students yet");
            return false;
        }
        for (int i = 0; i < Database.students.size(); i++) {
            System.out.println(i + 1 + ") " + Database.students.get(i));
        }
        return true;
    }
}