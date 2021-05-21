package diyarenny;

import java.util.ArrayList;

public class Rubric {

	String rubricName;
	ArrayList<Criterion> criterion;
	ArrayList<StudentGrade> studentGrade;

	public Rubric(String rubricName, ArrayList<Criterion> criterion, ArrayList<StudentGrade> studentGrade) {
		super();
		this.rubricName = rubricName;
		this.criterion = criterion;
		this.studentGrade = studentGrade;
	}

	public ArrayList<Criterion> getCriterion() {
		return criterion;
	}

	public void setCriterion(ArrayList<Criterion> criterion) {
		this.criterion = criterion;
	}

	public ArrayList<StudentGrade> getStudentGrade() {
		return studentGrade;
	}

	public void setStudentGrade(ArrayList<StudentGrade> studentGrade) {
		this.studentGrade = studentGrade;
	}

	public String getRubricName() {
		return rubricName;
	}

	public void setRubricName(String rubricName) {
		this.rubricName = rubricName;
	}

}
