package diyarenny;

public class Student {

	//variable that stores student name
	String studentName;

	//empty constructor
	public Student() {
		super();
	}

	//constructor with parameters
	public Student(String studentName) {
		super();
		this.studentName = studentName;
	}

	//getter for student name
	public String getStudentName() {
		return studentName;
	}

	//setter for student name
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

}
