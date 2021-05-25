package diyarenny;

public class Student {

	//student name variable
	String studentName;

	//empty constructor
	public Student() {
		super();
	}

	//constructor with student name parameter
	public Student(String studentName) {
		super();
		this.studentName = studentName;
	}

	//getter method for student name
	public String getStudentName() {
		return studentName;
	}

	//setter method for student name
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

}
