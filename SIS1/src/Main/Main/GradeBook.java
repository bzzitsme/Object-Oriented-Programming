package Main.Main;

import java.util.*;

public class GradeBook {
    Course course = new Course();

    /**
     * Constructors
     */

    public GradeBook() {
    }

    public GradeBook(Course course) {
        this.course = course;
    }

    /**
     * getter and setter for Object Course
     */

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    /**
     * 'Welcome to the course' message
     */

    void displayMessage() {
        System.out.println("Welcome to the grade book for " + this.course.getName() + "!\n");
    }

    /**
     * Setting grades via console line and Scanner
     */

    void setGrades() {
        if (this.course.getStudents().isEmpty()) {
            System.out.println("Please, enroll students in this course first\n");
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please, input grades for students:\n");

            for (Student student : this.course.getStudents()) {
                System.out.print("Student " + student.getName() + ":\t");
                student.setGrade(scanner.nextInt());
                System.out.print('\n');
            }
        }
    }

    /**
     * sorting list of students, then invoking method determineClassAverage
     */

    void displayGradeReport() {
        this.course.getStudents().sort(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (s1.getYear() == s2.getYear()) return s2.getGrade() - s1.getGrade();
                return s1.getYear() - s2.getYear();
            }
        });
        determineClassAverage();
    }

    private void outputBarChart() {
        System.out.println("\nGrades distribution :");
        for (int i = 0; i < 11; i++) {
            switch (i) {
                case 0:
                    System.out.print("00-09:\t\t");
                    break;
                case 1:
                    System.out.print("10-19:\t\t");
                    break;
                case 2:
                    System.out.print("20-29:\t\t");
                    break;
                case 3:
                    System.out.print("30-39:\t\t");
                    break;
                case 4:
                    System.out.print("40-49:\t\t");
                    break;
                case 5:
                    System.out.print("50-59:\t\t");
                    break;
                case 6:
                    System.out.print("60-69:\t\t");
                    break;
                case 7:
                    System.out.print("70-79:\t\t");
                    break;
                case 8:
                    System.out.print("80-89:\t\t");
                    break;
                case 9:
                    System.out.print("90-99:\t\t");
                    break;
                case 10:
                    System.out.print("100:\t\t\t");
                    break;
            }
            printFrequency(Course.grades[i]);
        }
    }

    /**
     * printing frequency of grades (from outputChart)
     */

    private void printFrequency(int frequency) {
        for (int i = 0; i < frequency; i++) {
            System.out.print("*");
        }
        System.out.print("\n");
    }

    private void determineClassAverage() {
        double averageGrade = 0;
        List<Student> lowestGraders = new ArrayList<>();
        List<Student> highestGraders = new ArrayList<>();
        int lowestGrade = this.course.getStudents().get(0).getGrade();
        int highestGrade = this.course.getStudents().get(this.course.getStudents().size() - 1).getGrade();

        /**
         *  calculating average grade and adding to the list students with lowest & highest grade
         */
        for (Student student : this.course.getStudents()) {
            averageGrade += student.getGrade();
            if (student.getGrade() == lowestGrade) lowestGraders.add(student);
            if (student.getGrade() == highestGrade) highestGraders.add(student);
        }

        System.out.println("\nClass average is " + averageGrade / this.course.getStudents().size() + ".");

        /**
         *  printing students with lowest grade
         */
        System.out.println("Lowest grade is " + lowestGrade);
        System.out.println("Students with lowest grade : ");

        for (Student student : lowestGraders) {
            System.out.println("\t\t" + student.toString());
        }

        /**
         * printing students with highest grade
         */
        System.out.println("\nHighest grade is " + highestGrade);
        System.out.println("Students with highest grade : ");

        for (Student student : highestGraders) {
            System.out.println("\t\t" + student.toString());
        }

        outputBarChart();

        for (Student student : this.course.getStudents()) {
            System.out.println(student.getYear() + " " + student.getGrade());
        }
    }

    /**
     * toString() method
     */

    public String toString() {
        return "GradeBook\n\t{" +
                "\n\t\tcourse = " + course +
                "\n\t}";
    }
}