package Main;

import java.util.Scanner;

public class StarTriangle {
    private int width;

    public StarTriangle() {

    }

    private StarTriangle(int width) {
        this.width = width;
    }

    public String toString() {
        StringBuilder triangle = new StringBuilder();
        for (int i = 1; i <= this.width; i++) {
            for (int j = 1; j <= i; j++) {
                triangle.append("[*]");
            }
            triangle.append('\n');
        }
        return triangle.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StarTriangle st = new StarTriangle(sc.nextInt());
        StarTriangle star = new StarTriangle(3);

        System.out.println("hello world");
        System.out.println(st.toString());
        System.out.println(star.toString());
    }
}
