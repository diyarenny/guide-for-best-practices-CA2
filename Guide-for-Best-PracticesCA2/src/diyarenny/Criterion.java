package diyarenny;

public class Criterion {

	//criterion name variable
	String criterionName;

	//empty constructor 
	public Criterion() {

	}

	//constructor with criterionName parameter
	public Criterion(String criterionName) {
		this.criterionName = criterionName;

	}

	//getter method for criterionName
	public String getCriterionName() {
		return criterionName;
	}

	//setter method for criterionName
	public void setCriterionName(String criterionName) {
		this.criterionName = criterionName;
	}

}
