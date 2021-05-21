package diyarenny;

import java.util.ArrayList;

public class StudentGrade {

	Student student;
	ArrayList<Grade> studentGrade;

	public StudentGrade() {

	}

	public StudentGrade(Student student, ArrayList<Grade> studentGrade) {
		super();
		this.student = student;
		this.studentGrade = studentGrade;
	}

	public ArrayList<Grade> getStudentGrade() {
		return studentGrade;
	}

	public void setStudentGrade(ArrayList<Grade> studentGrade) {
		this.studentGrade = studentGrade;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
