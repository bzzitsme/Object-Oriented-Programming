package Main;

public class Sphere extends Shapes {
    public Sphere(double radius) {
        super(radius, 0);
    }

    @Override
    double volume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(super.getRadius(), 3);
    }

    @Override
    double surfaceArea() {
        return 4 * Math.PI * Math.pow(super.getRadius(), 2);
    }
}
