package Main;

import java.io.*;
import java.util.Vector;

public class DataStore {
    private static FileInputStream fis;
    private static FileOutputStream fos;
    private static ObjectInputStream ois;
    private static ObjectOutputStream oos;

    public static Vector<Course> courses = new Vector<Course>();
    public static Vector<Instructor> instructors = new Vector<Instructor>();
    public static Vector<Student> students = new Vector<Student>();

    public static void save() throws IOException {
        DataStore.serializeCourse();
        DataStore.serializeInstructors();
        DataStore.serializeStudents();
    }

    public static void serializeCourse() throws IOException {
        fos = new FileOutputStream("C:\\Users\\Admin\\Desktop\\files\\courses.ser");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(courses);
        oos.close();
        fos.close();
    }

    public static void deserializeCourses() throws IOException, ClassNotFoundException {
        fis = new FileInputStream("C:\\Users\\Admin\\Desktop\\files\\courses.ser");
        ois = new ObjectInputStream(fis);
        courses = (Vector<Course>) ois.readObject();
        ois.close();
        fis.close();
    }

    public static void showCourses() {
        if (DataStore.courses.size() == 0) {
            System.out.println("There are no courses in the system");
        } else {
            for (int index = 0; index < DataStore.courses.size(); index++) {
                System.out.println(index + 1 + ") " + DataStore.courses.get(index).getCourseTitle());
            }
        }
    }

    public static void serializeInstructors() throws IOException {
        fos = new FileOutputStream("C:\\Users\\Admin\\Desktop\\files\\instructors.ser");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(instructors);
        oos.close();
        fos.close();
    }


    public static void deserializeInstructors() throws IOException, ClassNotFoundException {
        fis = new FileInputStream("C:\\Users\\Admin\\Desktop\\files\\instructors.ser");
        ois = new ObjectInputStream(fis);
        instructors = (Vector<Instructor>) ois.readObject();
        ois.close();
        fis.close();
    }

    public static void serializeStudents() throws IOException {
        fos = new FileOutputStream("C:\\Users\\Admin\\Desktop\\files\\students.ser");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(students);
        oos.close();
        fos.close();
    }

    public static void deserializeStudents() throws IOException, ClassNotFoundException {
        fis = new FileInputStream("C:\\Users\\Admin\\Desktop\\files\\students.ser");
        ois = new ObjectInputStream(fis);
        students = (Vector<Student>) ois.readObject();
        ois.close();
        fis.close();
    }

    public static void addStudent(Student student) {
        DataStore.students.add(student);
    }
}
