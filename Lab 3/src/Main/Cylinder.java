package Main;

public class Cylinder extends Shapes {
    public Cylinder(double radius, double height) {
        super(radius, height);
    }

    @Override
    double volume() {
        return Math.PI * super.getRadius() * 2 * super.getHeight();
    }

    @Override
    double surfaceArea() {
        return 2 * Math.PI * Math.pow(super.getRadius(), 2);
    }
}
