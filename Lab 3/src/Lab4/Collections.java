package Lab4;

import java.util.ArrayList;

public class Collections implements MyCollection {
    ArrayList<Integer> arrayList = new ArrayList<>();

    @Override
    public void sort() {
        java.util.Collections.sort(this.arrayList);
    }

    @Override
    public boolean isEmpty() {
        return this.arrayList.size() == 0;
    }

    @Override
    public boolean contains(Object target) {
        return this.arrayList.contains(target);
    }

    @Override
    public void add(Object object) {
        this.arrayList.add((Integer) object);
    }

    @Override
    public void delete(int index) {
        this.arrayList.remove(index);
    }

    @Override
    public void get(int index) {
        this.arrayList.get(index);
    }

    @Override
    public int size() {
        return this.arrayList.size();
    }
}
