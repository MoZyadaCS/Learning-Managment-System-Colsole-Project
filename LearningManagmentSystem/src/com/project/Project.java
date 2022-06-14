package com.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import javax.management.Query;

public class Project {
	static Course [] courses = new Course[20];
	static Room [] rooms = new Room[9];
	static Staff [] staff = new Staff[7];
	static Student [] students = new Student[50];
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args){
		readAllData();
		System.out.println("Welcome to our Computer Science department at Jamum University");
		while(true) {
			System.out.println("Please Choose one of the options: ");
			System.out.println("1-Add");
			System.out.println("2-Delete Student from a course");
			System.out.println("3-Search");
			System.out.println("4-Sort");
			System.out.println("5-Print Schedule");
			System.out.println("6-Exit");
			int choice = input.nextInt();
			input.nextLine();
			while(choice < 1 || choice >6) {
				System.out.println("Incorrect choice, Please Enter a valid one: ");
				choice = input.nextInt();
				input.nextLine();
			}
			switch (choice) {
			case 1:
				addMenu();
				break;
			case 2:
				delete();
				break;
			case 3:
				searchMenu();
				break;
			case 4:
				sortMenu();
				break;
			case 5:
				printScheduleMenu();
				break; 
			case 6:
				System.out.println("Exiting the program");
				System.exit(0);
			}
		}
    	
    	
    }
	public static void addMenu() {
		System.out.println("a-Allocate a course to a room");
		System.out.println("b-Assign a course to an instructor");
		System.out.println("c-Add a course to a student");
		char choice = input.nextLine().charAt(0);
		while(choice < 'a' || choice > 'c') {
			System.out.println("Enter a correct choice");
			choice = input.nextLine().charAt(0);
		}
		switch (choice) {
		case 'a':
			System.out.println("Enter The Course Code: ");
			int code = input.nextInt();
			Course course = getCourseByCode(code);
			while(course == null) {
				System.out.println("Course Not Found, Please Enter a correct code: ");
				code = input.nextInt();
				course = getCourseByCode(code);
			}
			System.out.println("Course Found.");
			AllocateCourse(course);
			break;
		case 'b':
			System.out.println("Enter The Course Code: ");
			int code1 = input.nextInt();
			Course course1 = getCourseByCode(code1);
			while(course1 == null) {
				System.out.println("Course Not Found, Please Enter a correct code: ");
				code1 = input.nextInt();
				course1 = getCourseByCode(code1);
			}
			System.out.println("Course Found.");
			System.out.println("Enter The instructor id: ");
			int id = input.nextInt();
			Staff instructor = getStaffByID(id);
			while(instructor == null) {
				System.out.println("id is incorrect, please enter a correct id: ");
				id = input.nextInt();
				instructor = getStaffByID(id);
			}
			System.out.println("Instructor Found.");
			assignCourseToInstructor(course1, instructor);
			break;
		case 'c':
			System.out.println("Enter The Course Code: ");
			int code2 = input.nextInt();
			Course course2 = getCourseByCode(code2);
			while(course2 == null) {
				System.out.println("Course Not Found, Please Enter a correct code: ");
				code2 = input.nextInt();
				course2 = getCourseByCode(code2);
			}
			System.out.println("Course Found.");
			System.out.println("Enter The Student id: ");
			int id1 = input.nextInt();
			Student student = getStudentByID(id1);
			while(student == null) {
				System.out.println("id is incorrect, please enter a correct id: ");
				id1 = input.nextInt();
				student = getStudentByID(id1);
			}
			System.out.println("Student Found.");
			addCourseToStudent(course2, student);
		
		}
	}
	public static void delete() {
		System.out.println("Enter The Student id: ");
		int id1 = input.nextInt();
		Student student = getStudentByID(id1);
		while(student == null) {
			System.out.println("id is incorrect, please enter a correct id: ");
			id1 = input.nextInt();
			student = getStudentByID(id1);
		}
		System.out.println("Student Found.");
		System.out.println("Enter The Course Code: ");
		int code = input.nextInt();
		Course course = getCourseByCode(code);
		while(course == null) {
			System.out.println("Course Not Found, Please Enter a correct code: ");
			code = input.nextInt();
			course = getCourseByCode(code);
		}
		System.out.println("Course Found.");
		deleteStudentFromCourse(student, course);
		
	}
	public static void searchMenu() {
		System.out.println("a-Search for student by id ");
		System.out.println("b-Seatch for students greater than GPA");
		System.out.println("c-Search for students in a course");
		char choice = input.nextLine().charAt(0);
		while(choice < 'a' || choice > 'c') {
			System.out.println("Enter a correct choice : ");
			choice = input.nextLine().charAt(0);
		}
		switch(choice) {
			case 'a':
				System.out.println("Enter the student id: ");
				int id = input.nextInt();
				Student student = getStudentByID(id);
				while(student == null) {
					System.out.println("Student Not Found, please enter a valid id: ");
					id = input.nextInt();
					student = getStudentByID(id);
				}
				System.out.println("Student Found");
				System.out.println(getStudentByID(id));
				break;
			case 'b':
				System.out.println("Enter the gpa: ");
				double gpa = input.nextDouble();
				while (gpa < 0 || gpa > 4) {
					System.out.println("Enter a correct gpa: ");
					gpa = input.nextDouble();
				}
				SearchForStudentsByGPA(gpa);
				break;
			case 'c':
				System.out.println("Enter The Course Code: ");
				int code = input.nextInt();
				Course course = getCourseByCode(code);
				while(course == null) {
					System.out.println("Course Not Found, Please Enter a correct code: ");
					code = input.nextInt();
					course = getCourseByCode(code);
				}
				SearchForStudentsByCourse(course);
		}
		
	}
	public static void sortMenu() {
		System.out.println("a-Sort ascending by id");
		System.out.println("b-Sort descending by GPA");
		char choice = input.nextLine().charAt(0);
		while(choice < 'a' || choice > 'b') {
			System.out.println("Enter a correct choice : ");
			choice = input.nextLine().charAt(0);
		}
		switch(choice) {
			case 'a':
				System.out.println("Students Sorted in ascending order By id");
				sortStudentsAscToId();
				break;
			case 'b':
				System.out.println("Students Sorted in descending order by gpa");
				sortStudentsDscToGPA();
		}
	}
	public static void printScheduleMenu() {
		System.out.println("a-Print student schedule");
		System.out.println("b-Print room schedule");
		System.out.println("c-Print instructor schedule");
		char choice = input.nextLine().charAt(0);
		while(choice < 'a' || choice > 'c') {
			System.out.println("Enter a correct choice");
			choice = input.nextLine().charAt(0);
		}
		switch(choice) {
			case 'a':
				System.out.println("Enter student id: ");
				int id = input.nextInt();
				Student student = getStudentByID(id);
				while(student == null) {
					System.out.println("Enter a correct id: ");
					id = input.nextInt();
				}
				printStudentTable(student);
				break;
			case 'b':
				System.out.println("Enter the room number: ");
				int number = input.nextInt();
				Room room = getRoomByNumber(number);
				while(room == null) {
					System.out.println("Enter a correct room number: ");
					number = input.nextInt();
					room = getRoomByNumber(number);
				}
				printRoomTable(room);
				break;
			case 'c':
				System.out.println("Enter the instructor id: ");
				int id1 = input.nextInt();
				Staff instructor = getStaffByID(id1);
				while(instructor == null) {
					System.out.println("Enter a correct id : ");
					id1 = input.nextInt();
					instructor = getStaffByID(id1);
				}
				System.out.println("The Schedule of the instructor is: ");
				printInstructorTable(instructor);
		}
	}
	
	public static void readStudentsData() {
		try {
			File file = new File("Students.txt");
			FileReader fileReader = new FileReader(file);
			Scanner read = new Scanner(fileReader);
			for(int i=0;i<50;i++) {
				String student = read.nextLine();
				String [] data = student.split(" ");
				Student s = new Student(data[0],data[1],Integer.valueOf(data[2]),Double.valueOf(data[3]));
				students[i] = s;
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("Students File Not Found");
		}
	}
	public static void readCoursesData() {
		try {
			File file = new File("Courses.txt");
			FileReader fileReader = new FileReader(file);
			Scanner read = new Scanner(fileReader);
			for(int i=0;i<20;i++) {
				String course = read.nextLine();
				String [] data = course.split(" ");
				Course c = new Course(Integer.valueOf(data[0]),data[1],Integer.valueOf(data[2]),Integer.valueOf(data[3]),Integer.valueOf(data[4]));
				courses[i] = c;
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("Courses File Not Found");
		}
	}
	public static void readStaffData() {
		try {
			File file = new File("Staff.txt");
			FileReader fileReader = new FileReader(file);
			Scanner read = new Scanner(fileReader);
			for(int i=0;i<7;i++) {
				String member = read.nextLine();
				String [] data = member.split(" ");
				Staff s = new Staff(data[0],data[1],Integer.valueOf(data[2]),Integer.valueOf(data[3]));
				staff[i] = s;
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("Staff File Not Found");
		}
	}
	public static void readRoomsData() {
		try {
			File file = new File("Rooms.txt");
			FileReader fileReader = new FileReader(file);
			Scanner read = new Scanner(fileReader);
			for(int i=0;i<9;i++) {
				String room = read.nextLine();
				String [] data = room.split(" ");
				Room r = new Room(Integer.valueOf(data[0]),Integer.valueOf(data[1]));
				rooms[i] = r;
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("Rooms File Not Found");
		}
	}
	public static void readAllData() {
		readStudentsData();
		readCoursesData();
		readStaffData();
		readRoomsData();
	}
	
	public static void AllocateCourse(Course c) {
		int capacity = c.getCapacity();
		// search for available rooms that can have the capacity of the course and that has no conflicts with the course
		ArrayList<Room> availableRooms = new ArrayList<Room>();
		for(int i=0;i<rooms.length;i++) {
			if(rooms[i].getCapacity() >= capacity && rooms[i].canAffordCourse()) {
				boolean conflict = false;
				// check for conflicts with courses in the room
				for(int j=0;i<rooms[i].getNumberOfCourses();j++) {
					if(checkConflict(c, rooms[i].getCourses()[j])) {
						conflict = true;
						break;
					}
				}
				if(!conflict) {
					availableRooms.add(rooms[i]);
				}
			}
		}
		// print the available rooms for the user
		// case that there is no rooms
		if(availableRooms.size() == 0) {
			System.out.println("No Rooms Avilable that can have this course capacity");
		}
		// case that there is available rooms
		else {
			System.out.println("The Available Rooms are : ");
			for(int i=0;i<availableRooms.size();i++) {
				System.out.println(availableRooms.get(i));
			}
			System.out.println();
			// ask the user for the room number to be allocated
			System.out.println("Enter the room Number: ");
			int number = input.nextInt();
			Room room = null;
			// check if the number is correct
			for(int i=0;i<availableRooms.size();i++) {
				if(availableRooms.get(i).getRoomNumber() == number) {
					room = availableRooms.get(i);
					break;
				}
			}
			// if the number is incorrect 
			if(room == null) {
				System.out.println("Room Number is incorrect.");
			}
			// allocating the room successfully
			else {
				room.AddCourse(c);
				c.setRoom(room);
				System.out.println("Course Allocated to this Room successfully");
			}
			
		}
		
	}
	
	public static void assignCourseToInstructor(Course course,Staff instructor) {
		// check if the instructor available for more courses
		if(instructor.getCourses()[instructor.getCourses().length-1] != null) {
			System.out.println("Instructor cannot have more courses");
			return;
		}
		// check for conflicts
		for(int i=0;i<instructor.getCourses().length;i++) {
			if(instructor.getCourses()[i] != null) {
				if(checkConflict(course, instructor.getCourses()[i])) {
					System.out.println("There is a conflict in the schecules.");
					return;
				}
			}
		}
		// if there is no conflicts assign the course to that instructor
		instructor.addCourse(course);
		System.out.println("Course Assigned successfully to the instructor");

	}

	public static boolean checkConflict(Course course1,Course course2) {
		if(course1.getDay().equals(course2.getDay()) && 
				((course1.getStartTime() <= course2.getStartTime() + course2.getHours() &&
						course1.getStartTime() >= course2.getStartTime()) || 
				(course2.getStartTime() <= course1.getStartTime() + course1.getHours() &&
						course2.getStartTime() >= course1.getStartTime()))) {
			return true;
		}
		return false;
	}

	public static void addCourseToStudent(Course course,Student student) {
		// check if the student can take more courses
		if(student.getCourses()[student.getCourses().length-1] != null) {
			System.out.println("This student can take no more courses.");
			return;
		}
		// check if the course can take more students
		if(course.getNumberOfStudents() == course.getCapacity()) {
			System.out.println("The course is full.");
			return;
		}
		// check if the course is assigned to a room and instructor
		if(course.getRoom() == null || course.getInstructor() == null) {
			System.out.println("The Course dosen't have instructor or room.");
			return;
		}
		// check if there is conflicts 
		for(int i=0;i<student.getCourses().length;i++) {
			if(student.getCourses()[i] != null) {
				if(checkConflict(course, student.getCourses()[i])) {
					System.out.println("There is a conflict in the schecule.");
					return;
				}
			}
		}
		// assign the course to the student
		student.addCourse(course);
		// assign the student to the course
		course.addStudent(student);
		System.out.println("Course Assigned successfully to the students");

	}

	public static void deleteStudentFromCourse(Student student,Course course) {
		if(student.getNumberOfCourses() == 2) {
			System.out.println("the student cannot have less courses");
			return;
		}
		student.removeCourse(course);
		course.deleteStudent(student);
	}
	
	public static void SearchForStudentsByGPA(double gpa) {
		System.out.println("Students with GPA more than " + gpa + " are : ");
		for(int i=0;i<students.length;i++) {
			if(students[i].getGPA() >= gpa) {
				System.out.println(students[i]);
			}
		}
	}

	public static void SearchForStudentsByCourse(Course course) {
		System.out.println("The instructor of the course is DR : "+ course.getInstructor().getFullName());
		System.out.println("And the Room for this course is room #"+ course.getRoom().getRoomNumber());
		System.out.println("Students in the course : ");
		for(int i=0;i<course.getNumberOfStudents();i++) {
			System.out.println(course.getStudents()[i]);
		}
	}

	public static void sortStudentsAscToId() {
		// sort the students in a priority queue with comparator that compare by id
		Queue<Student> sortedStudents = new PriorityQueue<Student>(new Comparator<Student>() {

			@Override
			public int compare(Student s1, Student s2) {
				if(s1.getId() > s2.getId()) return 1;
				else return -1;
			}
		});
		for(int i=0;i<students.length;i++) {
			sortedStudents.add(students[i]);
		}
		while(!sortedStudents.isEmpty()) {
			System.out.println(sortedStudents.poll());
		}
		
	}

	public static void sortStudentsDscToGPA() {
		// sort the students in a priority queue with comparator that compare by gpa
		Queue<Student> sortedStudents = new PriorityQueue<Student>(new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				if(s1.getGPA() > s2.getGPA()) return 1;
				else return -1;
			}
		});
		
		for(int i=0;i<students.length;i++) {
			sortedStudents.add(students[i]);
		}
		while(!sortedStudents.isEmpty()) {
			System.out.println(sortedStudents.poll());
		}
		
	}

	public static void printStudentTable(Student student) {
		System.out.println("Stuent Name : " + student.getFullName() + ", ID: " + student.getId() + ", And Gpa: " + student.getGPA());
		System.out.println("Student Schedule :");
		student.PrintSchedule();
	}

	public static void printRoomTable(Room room) {
		System.out.println("Room Number : " + room.getRoomNumber());
		System.out.println("Room Schedule: ");
		room.PrintSchedule();
	}
	
	public static void printInstructorTable(Staff instructor) {
		System.out.println("The instructor: " + instructor.getFullName() + " table is: " );
		instructor.PrintSchedule();
	}
	public static Student getStudentByID(int id) {
		for(int i=0;i<students.length;i++) {
			if(students[i].getId()== id) {
				return students[i];
			}
		}
		return null;
	}
	
	
	
	
	

	public static Staff getStaffByID(int id) {
		for(int i=0;i<staff.length;i++) {
			if(staff[i].getId() == id) {
				return staff[i];
			}
		}
		return null;
	}

	public static Course getCourseByCode(int code) {
		for(int i=0;i<courses.length;i++) {
			if(courses[i].getCourseCode() == code) {
				return courses[i];
			}
		}
		return null;
	}

	public static Room getRoomByNumber(int number) {
		for(int i=0;i<rooms.length;i++) {
			if(rooms[i].getRoomNumber() == number) {
				return rooms[i];
			}
		}
		return null;
	}
}
