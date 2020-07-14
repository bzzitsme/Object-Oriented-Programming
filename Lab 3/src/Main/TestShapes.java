package Main;

public class TestShapes {
    public static void main(String[] args) {
        Shapes cylinder = new Cylinder(8, 3);
        Shapes sphere = new Sphere(8);
        Shapes cube = new Cube(4);

        System.out.println(cylinder.surfaceArea());
        System.out.println(cylinder.volume());

        System.out.println(sphere.surfaceArea());
        System.out.println(sphere.volume());

        System.out.println(cube.volume());
        System.out.println(cube.surfaceArea());
    }
}
