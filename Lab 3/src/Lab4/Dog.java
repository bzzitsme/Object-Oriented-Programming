package Lab4;

public class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("Dog is eating pedigree");
    }

    @Override
    public void speak() {
        System.out.println("woof woof");
    }
}
