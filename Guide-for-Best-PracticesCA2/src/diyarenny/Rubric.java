package diyarenny;

import java.util.ArrayList;

public class Rubric {

	//rubric name variable
	String rubricName;
	//an array-list of criterias
	ArrayList<Criterion> criterion;
	//an array-list of student grades
	ArrayList<StudentGrade> studentGrade;

	//constructor with parameters
	public Rubric(String rubricName, ArrayList<Criterion> criterion, ArrayList<StudentGrade> studentGrade) {
		super();
		this.rubricName = rubricName;
		this.criterion = criterion;
		this.studentGrade = studentGrade;
	}

	//getter method for criteras
	public ArrayList<Criterion> getCriterion() {
		return criterion;
	}

	//setter method for criteras
	public void setCriterion(ArrayList<Criterion> criterion) {
		this.criterion = criterion;
	}
	
	//getter method for student grades
	public ArrayList<StudentGrade> getStudentGrade() {
		return studentGrade;
	}

	//setter method for student grades
	public void setStudentGrade(ArrayList<StudentGrade> studentGrade) {
		this.studentGrade = studentGrade;
	}

	//getter method for rubric name
	public String getRubricName() {
		return rubricName;
	}

	//setter method for rubric name
	public void setRubricName(String rubricName) {
		this.rubricName = rubricName;
	}

}
