package Main;

import java.io.Serializable;
import java.util.Objects;

/**
 * От этого класса extend-ится класс Instructor и Student
 * Здесь нужны getter & setter, equals() методы по регламенту 30 балльному
 * Класс должен быть Serializable потому что мы от него наследуем те классы, которые сериализуем (Instructor, Textbook, Student and so on)
 */
public class UniversityUsers implements Serializable {
    public String firstName;
    public String lastName;
    public String department;
    public String email;

    public UniversityUsers(String firstName, String lastName, String department, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.email = email;
    }


    /**
    * поменяй под себя equals() & toString()
     */

    @Override
    public String toString() {
        return "{" +
                "first name='" + firstName + '\'' +
                ", last name='" + lastName + '\'' +
                ", department='" + department + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UniversityUsers that = (UniversityUsers) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(department, that.department) &&
                Objects.equals(email, that.email);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
