package diyarenny;

import java.util.ArrayList;

public class StudentGrade {

	//Student object
	Student student;
	//an array-list of student grades
	ArrayList<Grade> studentGrade;

	//empty constructor
	public StudentGrade() {

	}

	//constructor with parameters
	public StudentGrade(Student student, ArrayList<Grade> studentGrade) {
		super();
		this.student = student;
		this.studentGrade = studentGrade;
	}

	//getter for student grades
	public ArrayList<Grade> getStudentGrade() {
		return studentGrade;
	}

	//setter for student grades
	public void setStudentGrade(ArrayList<Grade> studentGrade) {
		this.studentGrade = studentGrade;
	}

	//getter for student
	public Student getStudent() {
		return student;
	}

	//setter for student
	public void setStudent(Student student) {
		this.student = student;
	}

}
