package Main;

public abstract class Shapes {
    private double radius;
    private double height;

    public Shapes(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    abstract double volume();

    abstract double surfaceArea();
}
