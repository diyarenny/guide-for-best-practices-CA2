package diyarenny;

import java.util.ArrayList;

public class StudentGrade {

	//student object
	Student student;
	// an arraylist that stores all the different student grades
	ArrayList<Grade> studentGrade;

	//empty constructor 
	public StudentGrade() {

	}

	//constructor with student object, arraylist student grade parameters 
	public StudentGrade(Student student, ArrayList<Grade> studentGrade) {
		super();
		this.student = student;
		this.studentGrade = studentGrade;
	}

	//getter method for arraylist student grade
	public ArrayList<Grade> getStudentGrade() {
		return studentGrade;
	}

	//setter method for arraylist student grade
	public void setStudentGrade(ArrayList<Grade> studentGrade) {
		this.studentGrade = studentGrade;
	}

	//getter method for student object
	public Student getStudent() {
		return student;
	}

	//setter method for student object
	public void setStudent(Student student) {
		this.student = student;
	}

}
