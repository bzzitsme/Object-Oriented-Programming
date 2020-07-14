package Lab4;

import Main.Employee;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Manager extends Lab4.Employee implements Comparable {
    public ArrayList<Employee> employees = new ArrayList<>();
    private Integer bonus;

    public Manager() {

    }

    public Manager(String name, Integer salary, Date hireDate, String insuranceNumber, Integer bonus) {
        super(name, salary, hireDate, insuranceNumber);
        this.bonus = bonus;
    }


    public Manager(ArrayList<Employee> employees) {
        employees.addAll(employees);
    }

    public Manager(Employee employee) {
        employees.add(employee);
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    public Integer getBonus() {
        return this.bonus;
    }

    @Override
    public int compareTo(Object o) {
        Manager manager = (Manager) o;
        return (super.compareTo(manager)== 0)
                ? this.bonus.compareTo(manager.bonus)
                : this.getSalary().compareTo(manager.getSalary());
    }

    public static void main(String[] args) {
        Manager mg1 = new Manager();
        mg1.setSalary(100000);
        mg1.setBonus(70000);
        Manager mg2 = new Manager();
        mg2.setSalary(100000);
        mg2.setBonus(60000);
        System.out.println(mg1.compareTo(mg2));
    }
}
