package diyarenny;

public class Criterion {

	//each criteria name - ie; design, planning etc...
	String criterionName;
	
	//empty construcor
	public Criterion() {

	}

	//constructor with parameters
	public Criterion(String criterionName) {
		this.criterionName = criterionName;
	}

	//getter method for criteria name
	public String getCriterionName() {
		return criterionName;
	}

	//setter method for criteria name
	public void setCriterionName(String criterionName) {
		this.criterionName = criterionName;
	}

}
