package Main;

import java.util.ArrayList;

public class TestEmployee {
    public static void main(String[] args) {
        ArrayList<Employee> employeesList = new ArrayList<>();
        Employee employee1 = new Employee("Timka", 1000000, 2020, "not assigned");
        Employee employee2 = new Employee("Pakita", 1000000, 2020, "not assigned");

        employeesList.add(employee1);
        employeesList.add(employee2);

        Manager manager = new Manager(employee1);
        for (Employee employee : manager.employees) {
            System.out.println(employee.getSalary());
        }
        manager.getBonus();

        for (Employee employee : manager.employees) {
            System.out.println(employee.getSalary());;
        }

    }
}
