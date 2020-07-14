package Lab4;

import Main.Person;

import java.util.Date;
import java.util.StringTokenizer;

public class Employee extends Person implements Comparable {
    private Integer salary;
    private Date hireDate;
    private String insuranceNumber;

    public Employee() {

    }

    public Employee(String name, Integer salary, Date hireDate, String insuranceNumber) {
        super(name);
        this.salary = salary;
        this.hireDate = hireDate;
        this.insuranceNumber = insuranceNumber;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Date getHireDate() {
        return this.hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    @Override
    public String toString() {
        return "Employee1{" +
                "salary=" + salary +
                ", hire date=" + hireDate +
                ", insuranceNumber='" + insuranceNumber + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return this.salary.compareTo(((Employee) o).salary);
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee();
        employee1.setSalary(200000);
        Employee employee2 = new Employee();
        employee2.setSalary(300000);

        System.out.println(employee1.compareTo(employee2));
    }
}
