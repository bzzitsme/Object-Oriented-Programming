package Main;

import java.util.Scanner;

public class Analyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Data data = new Data();

        String number = sc.next();

        while (!number.equals("Q")) {
            data.addValue(Integer.parseInt(number));
            number = sc.next();
        }

        System.out.println(data.average());
        System.out.print(data.maximum());
    }
}