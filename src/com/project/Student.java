package com.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int id;
    private double GPA;
    private int numberOfCourses = 0;
    private Course [] courses = new Course[4];

    public Student() {
    	
    }
    
    public Student(String firstName, String lastName, int id, double GPA) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.GPA = GPA;
    }


    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getGPA() {
		return GPA;
	}

	public void setGPA(double gPA) {
		GPA = gPA;
	}

	public Course[] getCourses() {
		return courses;
	}

	public void setCourses(Course[] courses) {
		this.courses = courses;
	}
	

	public int getNumberOfCourses() {
		return numberOfCourses;
	}

	public void setNumberOfCourses(int numberOfCourses) {
		this.numberOfCourses = numberOfCourses;
	}
	public void addCourse(Course course) {
		// check if the student can take more courses
		if(numberOfCourses == 4) {
			System.out.println("student cannot take more courses");
			return;
		}
		// assign the course to the student
		this.courses[numberOfCourses] = course;
		this.numberOfCourses++;
	}
	public void removeCourse(Course course) {
		// check if we can remove the course
		if(this.numberOfCourses == 2) {
			System.out.println("The Student have the minimun number of courses.");
			return;
		}
		int index = -1;
		// search for the course
		for(int i=0;i<this.courses.length;i++) {
			if(this.courses[i] == course) {
				index = i;
				break;
			}
		}
		if(index == -1) {
			System.out.println("Course Not Found");
		}
		else {
			for(int i=index;i<numberOfCourses;i++) {
				courses[i] = courses[i+1];
			}
		}
		
	}
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}
	public void PrintSchedule() {
		System.out.println("Sunday Courses: ");
		for(int i=0;i<numberOfCourses;i++) {
			if(this.courses[i].getDay().equals("Sun")) {
				System.out.println(courses[i]);
			}
		}
		System.out.println("Monday Courses: ");
		for(int i=0;i<numberOfCourses;i++) {
			if(this.courses[i].getDay().equals("Mon")) {
				System.out.println(courses[i]);
			}
		}
		System.out.println("Tuesday Courses: ");
		for(int i=0;i<numberOfCourses;i++) {
			if(this.courses[i].getDay().equals("Tue")) {
				System.out.println(courses[i]);
			}
		}
		System.out.println("Wednesday Courses: ");
		for(int i=0;i<numberOfCourses;i++) {
			if(this.courses[i].getDay().equals("Wed")) {
				System.out.println(courses[i]);
			}
		}
	}

	@Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                ", GPA=" + GPA +
                '}';
    }
}
