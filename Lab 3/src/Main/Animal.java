package Main;

public class Animal {
    private String name;
    private int age;

    public Animal() {
        name = "unknown";
        age = 0;
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void eat() {
        System.out.println(this.name + " is eating fruits");
    }

    public void speak() {
        System.out.println("beep beep");
    }

    public String getInfo(String name, int age) {
        return "name is " + name + " age is " + age;
    }

    public String getInfo(int age, String name) {
        return "name is " + name + " age is " + age;
    }
}
