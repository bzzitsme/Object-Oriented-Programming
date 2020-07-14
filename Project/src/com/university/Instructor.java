package com.university;

import java.io.Serializable;

public class Instructor extends UniversityMember implements Serializable {
    public Instructor(String firstName, String lastName, String department, String email) {
        super(firstName, lastName, department, email);
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " from " + department + " department" + ", email : " + email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Instructor instructor = (Instructor) o;
        return firstName.equals(instructor.firstName)
                && lastName.equals(instructor.lastName)
                && department.equals(instructor.department)
                && email.equals(instructor.email);
    }

    public static void MODE(String email) {
        System.out.println("I AM IN INSTRUCTOR MODE");
    }
}