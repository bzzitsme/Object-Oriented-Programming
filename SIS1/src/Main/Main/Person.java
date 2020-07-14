package Main.Main;

public class Person {
    Gender gender;
    int age;

   public Person() {

   }

    public Person(Gender gender, int age) {
        this.gender = gender;
        this.age = age;
    }

    enum Gender {
        MALE,
        FEMALE
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Person{" +
                "gender=" + gender +
                ", age=" + age +
                '}';
    }
}
