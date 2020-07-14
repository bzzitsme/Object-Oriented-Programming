package Lab4;

public interface MyCollection {
    void sort();

    boolean isEmpty();

    boolean contains(Object target);

    void add(Object object);

    void delete(int index);

    void get(int index);

    int size();
}
