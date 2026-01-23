package com.klu.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CourseRegistration {

    @Value("101")
    private int rollno;

    @Value("Lohith")
    private String studentName;

    private String courseName;
    private int semester;

    
    public CourseRegistration(
            @Value("FSAD") String cn,
            @Value("4") int sem) {
        this.courseName = cn;
        this.semester = sem;
    }

    public void display() {
        System.out.println("Roll No : " + rollno);
        System.out.println("Name    : " + studentName);
        System.out.println("Course  : " + courseName);
        System.out.println("Semester: " + semester);
    }
}
