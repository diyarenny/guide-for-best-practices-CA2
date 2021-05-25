package diyarenny;

import java.util.ArrayList;

public class Rubric {

	//rubric name variable
	String rubricName;
	//an arraylist that stores all the different criterions
	ArrayList<Criterion> criterion;
	//an arraylist that stores all the different student grades
	ArrayList<StudentGrade> studentGrade;

	//constructor with rubric name, arraylist criterion, arraylist grade parameters 
	public Rubric(String rubricName, ArrayList<Criterion> criterion, ArrayList<StudentGrade> studentGrade) {
		super();
		this.rubricName = rubricName;
		this.criterion = criterion;
		this.studentGrade = studentGrade;
	}

	//getter method for arraylist criterion
	public ArrayList<Criterion> getCriterion() {
		return criterion;
	}

	//setter method for arraylist criterion
	public void setCriterion(ArrayList<Criterion> criterion) {
		this.criterion = criterion;
	}

	//getter method for arraylist student grade
	public ArrayList<StudentGrade> getStudentGrade() {
		return studentGrade;
	}

	//setter method for arraylist student grade
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
