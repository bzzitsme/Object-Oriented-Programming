package Main;

public class Student {
    private String name;
    private int id, year;

    public Student() {

    }
    public Student (String name, int id, int year) {
        this(name, id);
        this.year = year;
    }

    public Student (String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void incrementYear() {
        this.year++;
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.name = "Timka";
        student.id = 1;
        student.year = 1;

        System.out.println(student.year);

        student.incrementYear();

        System.out.print(student.year);
    }
}
