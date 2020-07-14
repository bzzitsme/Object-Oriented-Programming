package Main;

import java.util.ArrayList;

public class Manager extends Employee {
    public ArrayList<Employee> employees = new ArrayList<>();

    public Manager() {
    }


    public Manager(ArrayList<Employee> employees) {
        employees.addAll(employees);
    }

    public Manager(Employee employee) {
        employees.add(employee);
    }

    public void getBonus() {
        this.setSalary(this.getSalary() * 1.5);
    }
}
