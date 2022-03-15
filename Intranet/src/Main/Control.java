package Main;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.*;
import java.util.GregorianCalendar;

public class Control {
    public static void adminPanel() {
        File adminTXT = new File("C:\\Users\\Admin\\Desktop\\files\\admin.txt");
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);

            FileWriter fw = new FileWriter(adminTXT, true);
            fw.write(xmlGregorianCalendar.toString() + " admin logged in to a system\n");

            String choice;
            boolean shouldLogout = false;
            boolean shouldTerminate = false;
            while (true) {
                System.out.println("What do you want to do?");
                System.out.println("1) Add course");
                System.out.println("2) Add student");
                System.out.println("3) Logout");
                System.out.println("4) Exit");

                choice = inputStreamReader.readLine();

                switch (choice) {
                    case "1":
                        Instructor instructor;
                        System.out.print("Insert course title : ");
                        String courseTitle = inputStreamReader.readLine();

                        System.out.println("If this instructors fits your course, type their ID");
                        for (int index = 0; index < DataStore.instructors.size(); index++) {
                            System.out.println(index + 1 + ") " + DataStore.instructors.get(index).lastName + " " + DataStore.instructors.get(index).firstName);
                        }
                        int id = Integer.parseInt(inputStreamReader.readLine());
                        id--;
                        if (id >= 0 && id < DataStore.instructors.size()) {
                            instructor = DataStore.instructors.get(id);
                        } else {
                            System.out.print("Insert instructor first name : ");
                            String firstName = inputStreamReader.readLine();
                            System.out.print("Insert instructor last name : ");
                            String lastName = inputStreamReader.readLine();
                            System.out.print("Insert instructor department : ");
                            String department = inputStreamReader.readLine();
                            System.out.print("Insert instructor mail : ");
                            String mail = inputStreamReader.readLine();
                            instructor = new Instructor(firstName, lastName, department, mail);
                            DataStore.instructors.add(instructor);
                        }
                        System.out.print("Insert book name : ");
                        String bookName = inputStreamReader.readLine();
                        System.out.print("Insert book author/authors : ");
                        String bookAuthor = inputStreamReader.readLine();
                        System.out.print("Insert book isbn : ");
                        String bookISBN = inputStreamReader.readLine();

                        Textbook textbook = new Textbook(bookName, bookAuthor, bookISBN);
                        Course course = new Course(courseTitle, instructor, textbook);

                        DataStore.courses.add(course);
                        fw.write(xmlGregorianCalendar.toString() + " admin added new course : " + courseTitle + "\n");
                        fw.write(xmlGregorianCalendar.toString() + " admin added new instructor : " + instructor.lastName + " " + instructor.firstName + "\n");
                        fw.write(xmlGregorianCalendar.toString() + " admin added new textbook : " + bookName + "\n");
                        DataStore.save();
                        break;

                    case "2":
                        System.out.print("Insert student first name : ");
                        String firstName = inputStreamReader.readLine();
                        System.out.print("Insert student last name : ");
                        String lastName = inputStreamReader.readLine();
                        System.out.print("Insert student department : ");
                        String department = inputStreamReader.readLine();
                        System.out.print("Insert student mail : ");
                        String mail = inputStreamReader.readLine();

                        Student student = new Student(firstName, lastName, department, mail);
                        DataStore.addStudent(student);
                        DataStore.save();
                        break;

                    case "3":
                        shouldLogout = true;
                        break;

                    case "4":
                        shouldTerminate = true;
                        break;

                    default:
                        System.out.println("Your input is not correct");
                }

                if (shouldLogout) {
                    // serialize the data and return back to Driver;
                    fw.close();
                    DataStore.save();
                    break;
                }

                if (shouldTerminate) {
                    // serialize the data and exit;
                    fw.close();
                    DataStore.save();
                    System.exit(0);
                }
            }
        } catch (DatatypeConfigurationException dce) {
            System.out.println("Wrong datatype");
        } catch (IOException io) {
            System.out.println("Can not read from file");
        }
    }

    public static void userPanel() {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String choice;
            boolean shouldLogout = false;
            boolean shouldTerminate = false;
            while (true) {
                System.out.println("What do you want to do?");
                System.out.println("1) View all courses");
                System.out.println("2) Logout");
                System.out.println("3) Exit");

                choice = inputStreamReader.readLine();
                switch (choice) {
                    case "1":
                        for (int index = 0; index < DataStore.courses.size(); index++) {
                            System.out.println(index + 1 + ") " + DataStore.courses.get(index).courseTitle);
                        }
                        System.out.println("Insert course index to get detailed information");
                        int index = Integer.parseInt(inputStreamReader.readLine());
                        index--;
                        if (index >= 0 && index < DataStore.courses.size()) {
                            System.out.println("Course name " + DataStore.courses.get(index).courseTitle);
                            System.out.println("Course instructor " + DataStore.courses.get(index).instructor.lastName + " " + DataStore.courses.get(index).instructor.firstName);
                            System.out.println("Course textbook " + DataStore.courses.get(index).textbook.getTitle());
                            System.out.println();
                        }
                        break;
                    case "2":
                        shouldLogout = true;
                        break;
                    case "3":
                        shouldTerminate = true;
                        break;
                    default:
                        System.out.println("Your input is not correct");
                }
                if (shouldLogout) {
                    break;
                }
                if (shouldTerminate) {
                    System.exit(0);
                }
            }
        } catch (IOException io) {
            System.out.println("Input/Output Exception");
        }
    }
}
