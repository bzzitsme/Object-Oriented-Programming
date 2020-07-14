package Main.Main;

import java.util.ArrayList;
import java.util.List;

public class GradeBookTest {
    public static void main(String[] args) {
        GradeBook gradeBook = new GradeBook();

        gradeBook.course.setName("CS101 Object-oriented Programming and Design");
        gradeBook.course.setDescription("Course is related to main principles of Object-oriented Programming and more");
        gradeBook.course.setNumberOfCredits(3);
        gradeBook.course.setPrerequisites("Databases");
        gradeBook.course.setPrerequisites("Algorithms and Data Structures");


        Student A = new Student();
        A.setName("A");
        A.setYear(1);

        Student B = new Student();
        B.setName("B");
        B.setYear(2);

        Student C = new Student();
        C.setName("C");
        C.setYear(3);

        Student D = new Student();
        D.setName("D");
        D.setYear(4);

        Student E = new Student();
        E.setName("E");
        E.setYear(3);

        Student F = new Student();
        F.setName("F");
        F.setYear(2);

        Student G = new Student();
        G.setName("G");
        G.setYear(1);

        Student H = new Student();
        H.setName("H");
        H.setYear(3);

        Student I = new Student();
        I.setName("I");
        I.setYear(4);

        Student J = new Student();
        J.setName("J");
        J.setYear(1);

        List<Student> students = new ArrayList<>();
        students.add(A);
        students.add(B);
        students.add(C);
        students.add(D);
        students.add(E);
        students.add(F);
        students.add(G);
        students.add(H);
        students.add(I);
        students.add(J);


        gradeBook.course.setStudents(students);

        gradeBook.displayMessage();

        gradeBook.setGrades();

        System.out.println(gradeBook.toString());

        gradeBook.displayGradeReport();
    }
}
