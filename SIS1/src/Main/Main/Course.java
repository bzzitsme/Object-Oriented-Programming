package Main.Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Course {
    private String name, description;
    private int numberOfCredits;

    // List of <Course>
    private List<String> prerequisites = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    static int[] grades = new int[11];

    /**
     * Constructors
     */

    public Course() {

    }

    public Course(String name, String description, int numberOfCredits) {
        this.name = name;
        this.description = description;
        this.numberOfCredits = numberOfCredits;
    }

    public Course(String name, String description, int numberOfCredits, String prerequisites) {
        this(name, description, numberOfCredits);
        this.prerequisites.add(prerequisites);
    }

    public Course(String name, String description, int numberOfCredits, String[] prerequisites) {
        this(name, description, numberOfCredits);
        Collections.addAll(this.prerequisites, prerequisites);
    }

    public Course(String name, String description, int numberOfCredits, List<String> prerequisites) {
        this(name, description, numberOfCredits);
        this.prerequisites.addAll(prerequisites);
    }

    public Course(String name, String description, int numberOfCredits, List<String> prerequisites, Student student) {
        this(name, description, numberOfCredits, prerequisites);
        this.students.add(student);
    }

    /**
     * getter and setter for name and description fields
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * getter and setter for number of credits
     */

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    /**
     * getter and setter for List <String > prerequisites
     */

    public List<String> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(String prerequisites) {
        this.prerequisites.add(prerequisites);
    }

    public void setPrerequisites(List<String> prerequisites) {
        this.prerequisites.addAll(prerequisites);
    }

    public void setPrerequisites(String[] prerequisites) {
        Collections.addAll(this.prerequisites, prerequisites);
    }

    /**
     * getter and setter for List <Student >
     */

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(Student student) {
        this.students.add(student);
    }

    public void setStudents(List<Student> students) {
        this.students.addAll(students);
    }

    /**
     * toString() method
     */

    public String toString() {
        return "Course {" +
                "\n\t\t\tname='" + name + '\'' +
                ", \n\t\t\tdescription='" + description + '\'' +
                ", \n\t\t\tnumberOfCredits=" + numberOfCredits +
                ", \n\t\t\tprerequisites=" + prerequisites +
                ", \n\t\t\tstudents=" + students +
                "\n\t\t\t}";
    }
}