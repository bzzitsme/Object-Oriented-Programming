package Lab4;

public class Employee1 extends Person implements Adult{
    private String companyName, position;
    private int employmentYear;

    public Employee1() {
        super();
        this.companyName = "unknown";
        this.position = "unknown";
        this.employmentYear = 0;
    }

    public Employee1(String name, String surname, int age, String companyName, String position, int employmentYear) {
        super(name, surname, age);
        this.companyName = companyName;
        this.position = position;
        this.employmentYear = employmentYear;
    }

    @Override
    public void work() {
        System.out.println(this.getSurname() + " is working in " + companyName + " as a " + position);
    }

    @Override
    public boolean isAdult() {
        return this.getAge() >= 18;
    }
}
