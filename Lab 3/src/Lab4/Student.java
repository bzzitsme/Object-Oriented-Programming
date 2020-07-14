package Lab4;

public class Student extends Person implements Adult{
    @Override
    public void work() {
        System.out.println(this.getName() + " is currently a student and not working");
    }

    @Override
    public boolean isAdult() {
        return this.getAge() >= 18;
    }
}
