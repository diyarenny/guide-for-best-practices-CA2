package diyarenny;

import java.util.ArrayList;
import java.util.Collections;

public class RubricController {

	//an arraylist that stores all the different rubrics
	static ArrayList<Rubric> r2 = new ArrayList<>();
	// criterion size variable
	static int criterionSize;
	// grade size variable
	static int gradesSize;

	//method that adds a new criterion to the rubric
	public ArrayList<Criterion> addCriterion(String[] criterionName) {
		//stores all the criterions in an arraylist
		ArrayList<Criterion> c1 = new ArrayList<>();
		//number of criterion names
		criterionSize = criterionName.length;

		//if the number of criterion name is less than 10 then the new criterion is added to the rubric
		if (criterionName.length <= 10) {
			for (int i = 0; i <= criterionName.length - 1; i++) {
				Criterion criterion = new Criterion(criterionName[i]);
				//adds criterion name to the list
				c1.add(criterion);

			}
		} else {

			//prints out appropriate error message 
			System.out.println("You can only add the maximum of 10 Criterion!");
		}

		//returns the list of criterion name
		return c1;

	}

	//method for creating student grade
	public StudentGrade createStudentGrade(Grade[] grades, Student student) {
		StudentGrade studentGrade = null;
		//number of grades
		gradesSize = grades.length;
		if (checkEquals()) {
			//if the number of grades is less than or equal to 10 
			if (grades.length <= 10) {
				//arraylist that stores grades
				ArrayList<Grade> g1 = new ArrayList<>();
				for (int i = 0; i <= grades.length - 1; i++) {
					if (checkGradeRange(grades[i])) {
						//new grade is added to the list
						g1.add(grades[i]);
					}
				}
				studentGrade = new StudentGrade(student, g1);
			} else {

				//prints out appropriate error message 
				System.out.println("You can only add the maximum of 10 Grades!");
			}
		}
		//returns the list of criterion name
		return studentGrade;

	}

	//method that checks the grade range
	public static boolean checkGradeRange(Grade grade) {

		//checks if the grade entered is between 1-5
		if (0 > grade.getScore() || grade.getScore() > 5) {
			//prints out appropriate error message
			System.out.println("Error: Grade must be between 1-5");
			return false;

		} else {
			return true;
		}

	}

	//method checks if the number of grades is equal to the number of criterions
	public static boolean checkEquals() {

		if (!(gradesSize == criterionSize)) {

			//prints out appropriate error message
			System.out.println(
					"Error: The grades you entered for this student does not match the criterion size of the rubric");
			return false;
		} else {

			return true;
		}
	}

	//method creates new rubric
	//with parameters rubricName, c1, g2.
	public void createRubric(String rubricName, ArrayList<Criterion> c1, ArrayList<StudentGrade> g2) {

		if (checkEmptyCriterion(c1) || checkEmptyStudentGrade(g2) || checkEmptyRubricName(rubricName)) {
			Rubric rubric = new Rubric(rubricName, c1, g2);
			//adds the new rubric to list
			r2.add(rubric);

		}

	}

	//method checks if the rubric is empty
	public static boolean checkEmptyRubricName(String rubricName) {

		//if rubric is empty 
		if (rubricName.equals("")) {
			//prints out appropriate error message
			System.out.println("Error: You must add a name to your Rubric");
			return false;
		} else {

			return true;
		}

	}

	//method checks if the student grade is empty
	public static boolean checkEmptyStudentGrade(ArrayList<StudentGrade> g1) {

		//if student grade is empty 
		if (g1.isEmpty()) {
			//prints out appropriate error message
			System.out.println("Error: You have no Student Grade's added to the rubric");
			return false;
		} else {

			return true;
		}

	}

	//method checks if the criterion is empty
	public static boolean checkEmptyCriterion(ArrayList<Criterion> c1) {

		//if student criterion is empty 
		if (c1.isEmpty()) {
			//prints out appropriate error message
			System.out.println("Error: You have no criterion's added to the rubric");
			return false;
		} else {

			return true;
		}

	}

	//method gets a rubric by name
	public static void getRubrikByName(String rubricName) {
		//for each loop that searchs and returns a rubric by name
		for (Rubric r : r2) {
			//checks if rubric name equals rubricName
			if (r.getRubricName().equalsIgnoreCase(rubricName)) {
				System.out.println("\n----------- " + r.getRubricName() + " ----------- ");
				// --------------------- Rubric Header -----------------------
				System.out.printf("%-15s", "Student Name");

				//gets the criterion for that rubric
				for (int i = 0; i < r.getCriterion().size(); i++) {
					System.out.printf("%-15s", r.getCriterion().get(i).getCriterionName());
				}

				System.out.println("");

				//gets student grade for that rubric
				for (int i = 0; i < r.getStudentGrade().size(); i++) {

					System.out.printf("%-15s", "\n" + r.getStudentGrade().get(i).getStudent().getStudentName());

					//size of student grade
					int size = r.getStudentGrade().get(i).getStudentGrade().size();
					for (int grade = 0; grade < size; grade++) {
						System.out.printf("%-15s", r.getStudentGrade().get(i).getStudentGrade().get(grade).getScore());
					}
				}
			}
			break;
		}

	}

	//methos gets all rubrics 
	public void getAllRubrics() {

		//for each loop that loops through and gets all rubrics
		for (Rubric r : r2) {

			System.out.println("\n----------- " + r.getRubricName() + " ----------- ");
			// --------------------- Rubric Header -----------------------
			System.out.printf("%-15s", "Student Name");

			//gets all criterions
			for (int i = 0; i < r.getCriterion().size(); i++) {
				System.out.printf("%-15s", r.getCriterion().get(i).getCriterionName());
			}

			System.out.println("");

			//gets all student grades
			for (int i = 0; i < r.getStudentGrade().size(); i++) {

				System.out.printf("%-15s", "\n" + r.getStudentGrade().get(i).getStudent().getStudentName());

				//gets sizes of all student grades
				int size = r.getStudentGrade().get(i).getStudentGrade().size();
				for (int grade = 0; grade < size; grade++) {
					System.out.printf("%-15s", r.getStudentGrade().get(i).getStudentGrade().get(grade).getScore());
				}
			}

		}

	}

	// Calculations
	//method calculates the rubric average
	public float calculateRubricAverage(Rubric rubric) {
		float totalGrades = 0;
		float size = 0;

		for (StudentGrade student : rubric.getStudentGrade()) {
			for (Grade grade : student.getStudentGrade()) {
				totalGrades += grade.getScore();
				size++;
			}

		}

		//prints out the rubric's average
		System.out.println("Average rubric mark: " + totalGrades / size);
		return totalGrades / rubric.getStudentGrade().size();

	}

	// maximum score
	//method calculates the rubric maximum score 
	public int maximumScoreRubric(Rubric rubric) {
		ArrayList<Integer> results = new ArrayList<>();

		//loops through all the student grades
		for (StudentGrade student : rubric.getStudentGrade()) {
			for (Grade grade : student.getStudentGrade()) {
				results.add(grade.getScore());

			}

		}

		//prints out maximum score
		System.out.println("Maximum mark: " + Collections.max(results));
		return Collections.max(results);

	}

	//minimum
	//method calculates the rubric minimum score 
	public int minimumScoreRubric(Rubric rubric) {
		ArrayList<Integer> results = new ArrayList<>();

		//loops through all the student grades 
		for (StudentGrade student : rubric.getStudentGrade()) {
			for (Grade grade : student.getStudentGrade()) {
				results.add(grade.getScore());

			}

		}

		//prints out maximum score
		System.out.println("Minimum mark: " + Collections.min(results));
		return Collections.min(results);

	}

	//method calculates the standard deviation of the rubric
	public double calculateStandardDeviation(Rubric rubric) {

		ArrayList<Integer> results = new ArrayList<>();
		//loops through the student grade
		for (StudentGrade student : rubric.getStudentGrade()) {
			for (Grade grade : student.getStudentGrade()) {
				results.add(grade.getScore());

			}

		}
		double standardDeviation = 0.0;
		int sum = results.stream().mapToInt(Integer::intValue).sum();
		double mean = sum / results.size();
		//calculates the SD
		for (double num : results) {
			//formula
			standardDeviation += Math.pow(num - mean, 2);
		}

		//prints out the standard deviation
		System.out.println("Standard deviation: " + Math.sqrt(standardDeviation / results.size()));

		//returns the standard deviation
		return Math.sqrt(standardDeviation / results.size());

	}

	// Calculations
	//method calculates the criterion average
	public double calculateCriterionAverage(Criterion criterion, Rubric rubric) {

		int positionCriterion = 0;
		double totalGrades = 0;
		double size = 0;
		//loops through the criterions
		for (Criterion c : rubric.getCriterion()) {
			positionCriterion++;
			//if the crierion name equals the criterion.criterionName
			if (c.getCriterionName().equalsIgnoreCase(criterion.getCriterionName())) {
				break;
			}
		}
		//loops through student grade
		for (StudentGrade student : rubric.getStudentGrade()) {

			totalGrades += student.getStudentGrade().get(positionCriterion - 1).getScore();
			size++;

		}

		//prints out the criterion average
		System.out.println("Average Criterion mark: " + totalGrades / size);
		return totalGrades / rubric.getStudentGrade().size();

	}

	//maximum score
	//method that calculates the maximum score of the criterions
	public int maximumScoreCriterion(Criterion criterion, Rubric rubric) {
		ArrayList<Integer> results = new ArrayList<>();
		int positionCriterion = 0;
		//loops through the criterions
		for (Criterion c : rubric.getCriterion()) {
			positionCriterion++;
			//if criterion name equals to criterion.criterionName
			if (c.getCriterionName().equalsIgnoreCase(criterion.getCriterionName())) {
				break;
			}
		}
		//loops through student
		for (StudentGrade student : rubric.getStudentGrade()) {

			results.add(student.getStudentGrade().get(positionCriterion - 1).getScore());

		}
		//prints out the maximum score
		System.out.println("Maximum mark: " + Collections.max(results));
		return Collections.max(results);

	}

	//minimum score
	//method that calculates the minimum score of the criterions
	public int minimumScoreCriterion(Criterion criterion, Rubric rubric) {
		ArrayList<Integer> results = new ArrayList<>();
		int positionCriterion = 0;
		//loops through the criterions
		for (Criterion c : rubric.getCriterion()) {
			positionCriterion++;
			//if criterion name equals to criterion.criterionName
			if (c.getCriterionName().equalsIgnoreCase(criterion.getCriterionName())) {
				break;
			}
		}
		//loops through student
		for (StudentGrade student : rubric.getStudentGrade()) {

			results.add(student.getStudentGrade().get(positionCriterion - 1).getScore());

		}
		//prints out the minimum score
		System.out.println("Minimum mark: " + Collections.min(results));
		return Collections.min(results);

	}

	//method calculates the standard deviation of criterions
	public double calculateStandardDeviationCriterion(Criterion criterion, Rubric rubric) {

		//arraylist of results
		ArrayList<Integer> results = new ArrayList<>();
		int positionCriterion = 0;
		//loops through the criterions
		for (Criterion c : rubric.getCriterion()) {
			positionCriterion++;
			//if criterion name equals to criterion.criterionName
			if (c.getCriterionName().equalsIgnoreCase(criterion.getCriterionName())) {
				break;
			}
		}
		//loops through student
		for (StudentGrade student : rubric.getStudentGrade()) {

			//adds student to the arraylist results
			results.add(student.getStudentGrade().get(positionCriterion - 1).getScore());

		}
		double standardDeviation = 0.0;
		//calculation for SD
		int sum = results.stream().mapToInt(Integer::intValue).sum();
		double mean = sum / results.size();
		for (double num : results) {
			standardDeviation += Math.pow(num - mean, 2);
		}

		//prints out standard deviation of criterion
		System.out.println("Standard deviation: " + Math.sqrt(standardDeviation / results.size()));
		return Math.sqrt(standardDeviation / results.size());

	}

}
