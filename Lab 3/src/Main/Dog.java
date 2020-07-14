package Main;

public class Dog extends Animal {
    private String test = "Dog";

    public Dog() {
        super();
    }

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println(super.getName() + " is eating Pedigree");
    }

    @Override
    public void speak() {
        System.out.println(super.getName() + " is saying woof woof");
    }


    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.eat();
        animal.speak();

        Dog dog = new Dog("Husky", 1);
        dog.eat();
        dog.speak();

        System.out.println(dog.getInfo(dog.getAge(), dog.getName()));
    }
}