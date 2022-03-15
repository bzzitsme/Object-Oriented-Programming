package Main.Main;

import java.util.ArrayList;
import java.util.Stack;

public class DragonLaunch {
    private ArrayList<Person> kidnappedKids = new ArrayList<>();

    private int willDragonEatOrNot() {
        Stack<String> pair = new Stack<>();
        int eaten = 0;
        for (Person person : this.kidnappedKids) {
            if (pair.empty() && person.gender.equals(Person.Gender.FEMALE)) {
                eaten++;
            } else if (person.gender.equals(Person.Gender.MALE)) {
                pair.add("boy");
            } else if (!pair.empty() && person.gender.equals(Person.Gender.FEMALE)) {
                pair.pop();
            }
        }

        return eaten + pair.size();
    }

    private void kidnap(Person person) {
        kidnappedKids.add(person);
    }

    public static void main(String[] args) {
        DragonLaunch dragonLaunch1 = new DragonLaunch();
        DragonLaunch dragonLaunch2 = new DragonLaunch();

        Person p1 = new Person(Person.Gender.FEMALE, 14);
        Person p2 = new Person(Person.Gender.MALE, 13);
        Person p3 = new Person(Person.Gender.FEMALE, 8);
        Person p4 = new Person(Person.Gender.MALE, 8);

        dragonLaunch1.kidnap(p1);
        dragonLaunch1.kidnap(p2);
        dragonLaunch1.kidnap(p3);
        dragonLaunch1.kidnap(p4);


        Person s1 = new Person(Person.Gender.MALE, 24);
        Person s2 = new Person(Person.Gender.FEMALE, 18);
        Person s3 = new Person(Person.Gender.MALE, 17);
        Person s4 = new Person(Person.Gender.FEMALE, 21);

        dragonLaunch2.kidnap(s1);
        dragonLaunch2.kidnap(s2);
        dragonLaunch2.kidnap(s3);
        dragonLaunch2.kidnap(s4);

        System.out.println("Dragon has eaten " + dragonLaunch1.willDragonEatOrNot() + " kids");

        System.out.println("Dragon has eaten " + dragonLaunch2.willDragonEatOrNot() + " kids");
    }
}
