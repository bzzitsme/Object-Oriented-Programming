package Main;

public class Data {
    private int amount;
    private double sum = 0, maximum = 0;

    public Data() {

    }

    public void addValue(int number) {
        amount++;
        if (number > maximum) {
            maximum = number;
        }
        sum += number;
    }

    public double average() {
        return sum / amount;
    }

    public double maximum() {
        return maximum;
    }
}
