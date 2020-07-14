package com.university;

import java.util.Scanner;

public class User {
    public static void actions() {
        System.out.println(ConsoleColors.BLACK + "1) " + ConsoleColors.BLUE + "View Courses" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLACK + "2) " + ConsoleColors.BLUE + "Logout" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLACK + "3) " + ConsoleColors.BLUE + "Exit" + ConsoleColors.RESET);
    }

    public static void MODE() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ConsoleColors.BLACK + "What do you want to do?" + ConsoleColors.RESET);
        int choice;
        while (true) {
            User.actions();
            choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println(ConsoleColors.GREEN_BOLD + "Type the index of the course which you want to see" + ConsoleColors.RESET);
                if (Database.showCourses()) {
                    int index = scanner.nextInt();
                    if (index == 0) break;
                    Database.showCourseById(--index);
                }
            }

            if (choice == 2) {
                System.out.println(ConsoleColors.RESET);
                break;
            }
            if (choice == 3) {
                System.exit(0);
            }
        }
    }
}