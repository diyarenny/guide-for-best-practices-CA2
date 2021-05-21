package diyarenny;

public class Grade {

	//the score for each student
	int score;

	//empty constructor
	public Grade() {

	}

	//constructor with parameters
	public Grade(int score) {
		super();
		this.score = score;
	}

	//getter method for score
	public int getScore() {
		return score;
	}

	//setter method for score
	public void setScore(int score) {
		this.score = score;
	}

}
