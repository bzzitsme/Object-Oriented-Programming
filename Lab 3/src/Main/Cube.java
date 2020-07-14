package Main;

public class Cube extends Shapes {
    public Cube(double height) {
        super(0, height);
    }

    @Override
    double volume() {
        return Math.pow(super.getHeight(), 3);
    }

    @Override
    double surfaceArea() {
        return 6 * Math.pow(super.getHeight(), 2);
    }
}
