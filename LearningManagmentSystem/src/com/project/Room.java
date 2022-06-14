package com.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Room {
    private int roomNumber, capacity;
    private int numberOfCourses = 0;
    private Course [] courses = new Course[50];


    public Room() {
    }

    public Room(int roomNumber, int capacity) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }

    

    public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Course []  getCourses() {
		return courses;
	}

	public void setCourse(Course [] courses) {
		this.courses = courses;
	}
	public int getNumberOfCourses() {
		return numberOfCourses;
	}

	public void setNumberOfCourses(int numberOfCourses) {
		this.numberOfCourses = numberOfCourses;
	}

	public void setCourses(Course[] courses) {
		this.courses = courses;
	}
	public boolean canAffordCourse() {
		return this.numberOfCourses < 50;
	}
	public void AddCourse(Course course) {
		this.courses[this.numberOfCourses] = course;
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
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", capacity=" + capacity +
                '}';
    }
}
