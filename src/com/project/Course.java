package com.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Course {
    private int courseCode;
    private String day;
    private int startTime;
    private int hours;
    private int capacity;
    private Student [] students = new Student[capacity];
    private Staff instructor;
    private Room room;
    private int numberOfStudents = 0;

    public Course() {
    }
    
   
    public Course(int courseCode, String day, int startTime, int hours, int capacity) {
		super();
		this.courseCode = courseCode;
		this.day = day;
		this.startTime = startTime;
		this.hours = hours;
		this.capacity = capacity;
	}
    

	public int getCourseCode() {
		return courseCode;
	}


	public void setCourseCode(int courseCode) {
		this.courseCode = courseCode;
	}


	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}


	public int getStartTime() {
		return startTime;
	}


	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}


	public int getHours() {
		return hours;
	}


	public void setHours(int hours) {
		this.hours = hours;
	}


	public int getCapacity() {
		return capacity;
	}


	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	

	public Student[] getStudents() {
		return students;
	}


	public void setStudents(Student[] students) {
		this.students = students;
	}


	public Staff getInstructor() {
		return instructor;
	}


	public void setInstructor(Staff instructor) {
		this.instructor = instructor;
	}
	

	public Room getRoom() {
		return room;
	}


	public void setRoom(Room room) {
		this.room = room;
	}


	public int getNumberOfStudents() {
		return numberOfStudents;
	}


	public void setNumberOfStudents(int numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}
	
	
	public void addStudent(Student student) {
		for(int i=0;i<student.getCourses().length;i++) {
			if(student.getCourses()[i]!= null) {
				student.getCourses()[i] = this;
				this.getStudents()[this.getNumberOfStudents()] = student;
				this.numberOfStudents++;
			}
		}
	}
	public void deleteStudent(Student student) {
		int index = -1;
		// search for the student
		for(int i=0;i<numberOfStudents;i++) {
			if(this.students[i] == student) {
				index = i;
				break;
			}
		}
		if(index == -1) {
			System.out.println("Student Not Found in this course.");
			return;
		}
		else {
			for(int i=index;i<numberOfStudents;i++) {
				this.students[i] = this.students[i+1];
			}
			System.out.println("Student deleted successfully.");
		}
	}

	@Override
    public String toString() {
        return "Courses{" +
                "courseCode=" + courseCode +
                ", day='" + day + '\'' +
                ", startTime=" + startTime +
                ", hours=" + hours +
                ", capacity=" + capacity +
                '}';
    }
}
