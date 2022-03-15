package Main;

import java.io.Serializable;

public class Instructor extends UniversityUsers implements Serializable {
    /**
     * Must have: getter setter, equals() && toString(),
     * equals() есть в классе UniversityUsers (сам реализуешь)
     */
    public Instructor(String firstName, String lastName, String department, String email) {
        super(firstName, lastName, department, email);
    }

    @Override
    public String toString() {
        return "Instructor{" + super.toString() + "}";
    }
}
