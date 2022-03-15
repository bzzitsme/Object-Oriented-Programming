package com.university;

import java.io.Serializable;
import java.util.Vector;

public class Course implements Serializable {
    private String courseTitle;
    private Textbook textbook;
    private Instructor instructor;

    private Vector<Student> students;

    public Course(String courseTitle, Textbook textbook, Instructor instructor) {
        this(textbook, instructor);
        this.courseTitle = courseTitle;
    }

    public Course(Textbook textbook, Instructor instructor) {
        this.textbook = new Textbook(textbook.isbn, textbook.title, textbook.author);
        this.instructor = new Instructor(instructor.firstName, instructor.lastName, instructor.department, instructor.email);
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public Textbook getTextbook() {
        return textbook;
    }

    public void setTextbook(Textbook textbook) {
        this.textbook = textbook;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Vector<Student> getStudents() {
        return students;
    }

    public void setStudents(Vector<Student> students) {
        this.students.addAll(students);
    }

    public void setStudents(Student student) {
        this.students.add(student);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseTitle='" + courseTitle + '\'' +
                ", textbook=" + textbook +
                ", instructor=" + instructor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return courseTitle.equals(course.courseTitle) &&
                textbook.equals(course.textbook) &&
                instructor.equals(course.instructor);
    }
}
