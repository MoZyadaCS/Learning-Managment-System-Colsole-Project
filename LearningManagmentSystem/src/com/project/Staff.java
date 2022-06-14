package com.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Staff {
    private String firstName;
    private String lastName;
    private int id;
    private int office;
    private int numberOfCourses = 0;
    Course [] courses = new Course[3];

    public Staff() {
    }

    public Staff(String firstName, String lastName, int id, int office ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.office = office;
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

	public int getOffice() {
		return office;
	}

	public void setOffice(int office) {
		this.office = office;
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

	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}
	public void addCourse(Course course) {
		this.courses[numberOfCourses] = course;
		this.numberOfCourses++;
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
        return "Staff{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                ", office=" + office +
                '}';
    }
}
