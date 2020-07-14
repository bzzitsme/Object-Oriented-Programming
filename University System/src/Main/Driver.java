package Main;

import java.io.*;
import java.util.Objects;
import java.util.StringTokenizer;

public class Driver {
    public static void main(String[] args) {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            if (new File("C:\\Users\\Admin\\Desktop\\files\\courses.ser").exists()) {
                DataStore.deserializeCourses();
            }

            if (new File("C:\\Users\\Admin\\Desktop\\files\\instructors.ser").exists()) {
                DataStore.deserializeInstructors();
            }

            if (new File("C:\\Users\\Admin\\Desktop\\files\\students.ser").exists()) {
                DataStore.deserializeStudents();
            }

            for (Student st : DataStore.students) {
                System.out.println(st.toString());
            }

            for (Course cs : DataStore.courses) {
                System.out.println(cs.toString());
            }

            for (Instructor in : DataStore.instructors) {
                System.out.println(in.toString());
            }

            BufferedReader fileReader = new BufferedReader(new FileReader("C:\\Users\\Admin\\Desktop\\files\\admin.txt"));
            StringTokenizer st = new StringTokenizer(fileReader.readLine(), ":");
            String adminLogin = st.nextToken();
            String adminPassword = st.nextToken();

            while (true) {
                System.out.println("Sign in the system");
                System.out.print("Login : ");
                String inputUsername = inputStreamReader.readLine();
                System.out.print("Password : ");
                String inputPassword = inputStreamReader.readLine();
                inputPassword = String.valueOf(Objects.hash(inputPassword));

                if (inputUsername.equalsIgnoreCase(adminLogin) && inputPassword.equals(adminPassword)) {
                    Control.adminPanel();
                } else {
                    Control.userPanel();
                }
            }
        } catch (FileNotFoundException fe) {
            System.out.println("File not found");
        } catch (IOException io) {
            System.out.println("Can not read from file");
        } catch (ClassNotFoundException cnf) {
            System.out.println("Error, class not found");
        }
    }
}
