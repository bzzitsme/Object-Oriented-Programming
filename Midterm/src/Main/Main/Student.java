package Main.Main;


public class Student extends Course {
    private String name;
    private int year;
    private int grade;

    public Student() {

    }

    public Student(String name, int id, int grade) {
        this.name = name;
        this.year = id;
        this.grade = grade;
    }

    /**
     * getter and setter for name, id, grade fields
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int id) {
        this.year = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
        if (grade >= 0 && grade <= 100) {
            grades[grade / 10]++;
        }
    }

    /**
     * toString() method
     */

    public String toString() {
        return "Student{" +
                "name='" + name +
                ", year=" + year +
                ", grade=" + grade +
                "}";
    }
}