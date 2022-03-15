package Main;

import java.io.Serializable;

public class Student extends UniversityUsers implements Serializable {
    public double mark = 0;
    public Student(String firstName, String lastName, String department, String email) {
        super(firstName, lastName, department, email);
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }
}