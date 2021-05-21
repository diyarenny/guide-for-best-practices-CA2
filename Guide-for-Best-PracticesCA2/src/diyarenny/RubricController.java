package diyarenny;

import java.util.ArrayList;
import java.util.Collections;

public class RubricController {

	//array-list of rubrics
	static ArrayList<Rubric> r2 = new ArrayList<>();
	//variable that stores the size of the criterion
	static int criterionSize;
	//variabel that stores the size/ number of grades
	static int gradesSize;

	//method to add a new criterion to the rubric
	public ArrayList<Criterion> addCriterion(String[] criterionName) {
		ArrayList<Criterion> c1 = new ArrayList<>();
		criterionSize = criterionName.length;

		//if the length of the criterion name is less than 10 then user can add a new criteria name to the rubric
		if (criterionName.length <= 10) {
			for (int i = 0; i <= criterionName.length - 1; i++) {
				Criterion criterion = new Criterion(criterionName[i]);
				//adds the new criteria to the arraylist of criterions
				c1.add(criterion);

			}
		} else {

			//appropriate message is printed to the user
			System.out.println("You can only add the maximum of 10 Criterion!");
		}

		//the criterions are returned
		return c1;

	}

	//method created student grade
	public StudentGrade createStudentGrade(Grade[] grades, Student student) {
		StudentGrade studentGrade = null;
		gradesSize = grades.length;
		if (checkEquals()) {
			//if the length of the grades is less than 10 then user can add a new grade to the rubric
			if (grades.length <= 10) {
				ArrayList<Grade> g1 = new ArrayList<>();
				for (int i = 0; i <= grades.length - 1; i++) {
					if (checkGradeRange(grades[i])) {
						//new student grade is added to the rubric
						g1.add(grades[i]);
					}
				}
				studentGrade = new StudentGrade(student, g1);
			} else {
				
				//appropriate message is printed to the user
				System.out.println("You can only add the maximum of 10 Grades!");
			}
		}
		
		//the studentGrade are returned
		return studentGrade;

	}

	//method checks if the grade entered by user is a number/grade between 1 and 5
	public static boolean checkGradeRange(Grade grade) {

		//if grade is less than 0 or greater than 5 
		if (0 > grade.getScore() || grade.getScore() > 5) {
			
			//appropriate message is printed to the user
			System.out.println("Error: Grade must be between 1-5");
			return false;

		} else {
			return true;
		}

	}

	//method that checks if the grade entered by user does not match the criterion size of the rubric
	public static boolean checkEquals() {

		if (!(gradesSize == criterionSize)) {

			//appropriate message is printed to the user
			System.out.println(
					"Error: The grades you entered for this student does not match the criterion size of the rubric");
			return false;
		} else {

			return true;
		}
	}

	//method creates new rubric 
	public void createRubric(String rubricName, ArrayList<Criterion> c1, ArrayList<StudentGrade> g2) {

		//checks if criterion, student grade or rubric names are empty before adding the new rubric
		if (checkEmptyCriterion(c1) || checkEmptyStudentGrade(g2) || checkEmptyRubricName(rubricName)) {
			Rubric rubric = new Rubric(rubricName, c1, g2);
			//new rubric is added
			r2.add(rubric);

		}

	}

	//method check if rubric name is empty
	public static boolean checkEmptyRubricName(String rubricName) {

		//if rubric name is empty
		if (rubricName.equals("")) {
			//appropriate message is printed to the user
			System.out.println("Error: You must add a name to your Rubric");
			return false;
		} else {

			return true;
		}

	}

	//method check if student grade is empty
	public static boolean checkEmptyStudentGrade(ArrayList<StudentGrade> g1) {

		//if student grade is empty
		if (g1.isEmpty()) {
			//appropriate message is printed to the user
			System.out.println("Error: You have no Student Grade's added to the rubric");
			return false;
		} else {

			return true;
		}

	}

	//method check if criterion is empty
	public static boolean checkEmptyCriterion(ArrayList<Criterion> c1) {

		//if criterion is empty
		if (c1.isEmpty()) {
			//appropriate message is printed to the user
			System.out.println("Error: You have no criterion's added to the rubric");
			return false;
		} else {

			return true;
		}

	}

	//method gets rubric by a specific name
	public static void getRubrikByName(String rubricName) {
		for (Rubric r : r2) {
			if (r.getRubricName().equalsIgnoreCase(rubricName)) {
				System.out.println("\n----------- " + r.getRubricName() + " ----------- ");
				// --------------------- Rubric Header -----------------------
				System.out.printf("%-15s", "Student Name");

				//gets the criterion by name
				for (int i = 0; i < r.getCriterion().size(); i++) {
					System.out.printf("%-15s", r.getCriterion().get(i).getCriterionName());
				}

				System.out.println("");

				for (int i = 0; i < r.getStudentGrade().size(); i++) {

					System.out.printf("%-15s", "\n" + r.getStudentGrade().get(i).getStudent().getStudentName());

					int size = r.getStudentGrade().get(i).getStudentGrade().size();
					for (int grade = 0; grade < size; grade++) {
						System.out.printf("%-15s", r.getStudentGrade().get(i).getStudentGrade().get(grade).getScore());
					}
				}
			}
			break;
		}

	}

	//method gets all rubrics 
	public void getAllRubrics() {

		for (Rubric r : r2) {

			System.out.println("\n----------- " + r.getRubricName() + " ----------- ");
			// --------------------- Rubric Header -----------------------
			System.out.printf("%-15s", "Student Name");

			//gets the criterion names
			for (int i = 0; i < r.getCriterion().size(); i++) {
				System.out.printf("%-15s", r.getCriterion().get(i).getCriterionName());
			}

			System.out.println("");

			//gets the student grades
			for (int i = 0; i < r.getStudentGrade().size(); i++) {

				System.out.printf("%-15s", "\n" + r.getStudentGrade().get(i).getStudent().getStudentName());

				int size = r.getStudentGrade().get(i).getStudentGrade().size();
				for (int grade = 0; grade < size; grade++) {
					//printed back to the user
					System.out.printf("%-15s", r.getStudentGrade().get(i).getStudentGrade().get(grade).getScore());
				}
			}

		}

	}

	// ------------------------- Calculations -----------------------------------
	
	//method calculates the average of rubric
	public float calculateRubricAverage(Rubric rubric) {
		float totalGrades = 0; //the total grade variable
		float size = 0; //size

		//goes through all the student grades and gets student grade
		for (StudentGrade student : rubric.getStudentGrade()) {
			for (Grade grade : student.getStudentGrade()) {
				//gets the average 
				totalGrades += grade.getScore();
				//increment size by 1
				size++;
			}

		}

		//the average rubric mark is printed to the user
		System.out.println("Average rubric mark: " + totalGrades / size);
		return totalGrades / rubric.getStudentGrade().size();

	}

	// minimum and maximum score of a rubric
	public int maximumScoreRubric(Rubric rubric) {
		//an arraylist of the results
		ArrayList<Integer> results = new ArrayList<>();

		//goes through all student grade and gets highest grade (max)
		for (StudentGrade student : rubric.getStudentGrade()) {
			for (Grade grade : student.getStudentGrade()) {
				results.add(grade.getScore());

			}

		}
		
		//prints out the max mark
		System.out.println("Maximum mark: " + Collections.max(results));
		return Collections.max(results);

	}

	//minimum and maximum score of a rubric
	public int minimumScoreRubric(Rubric rubric) {
		//an arraylist of the results
		ArrayList<Integer> results = new ArrayList<>();

		//goes through all student grade and gets lowest grade (min)
		for (StudentGrade student : rubric.getStudentGrade()) {
			for (Grade grade : student.getStudentGrade()) {
				results.add(grade.getScore());

			}

		}
		
		//prints out the min mark
		System.out.println("Minimum mark: " + Collections.min(results));
		return Collections.min(results);

	}

	//calculates the standard deviation of a rubric
	public double calculateStandardDeviation(Rubric rubric) {
		//an arraylist of the results
		ArrayList<Integer> results = new ArrayList<>();
		
		//goes through all student grade and gets student grade
		for (StudentGrade student : rubric.getStudentGrade()) {
			for (Grade grade : student.getStudentGrade()) {
				results.add(grade.getScore());

			}

		}
		//sd
		double standardDeviation = 0.0;
		int sum = results.stream().mapToInt(Integer::intValue).sum();
		double mean = sum / results.size();
		
		for (double num : results) {
			//calculation for the standard deviation
			standardDeviation += Math.pow(num - mean, 2);
		}

		//prints out the standard deviation
		System.out.println("Standard deviation: " + Math.sqrt(standardDeviation / results.size()));

		return Math.sqrt(standardDeviation / results.size());

	}

	// Calculations - method to calculate the average of a rubric
	public double calculateCriterionAverage(Criterion criterion, Rubric rubric) {

		//gets the position of criterion
		int positionCriterion = 0;
		double totalGrades = 0;
		double size = 0;
		
		//goes through all the list of criterions
		for (Criterion c : rubric.getCriterion()) {
			positionCriterion++;
			if (c.getCriterionName().equalsIgnoreCase(criterion.getCriterionName())) {
				break;
			}
		}
		
		//goes through all student grade and gets student grade
		for (StudentGrade student : rubric.getStudentGrade()) {

			totalGrades += student.getStudentGrade().get(positionCriterion - 1).getScore();
			size++;

		}

		//average mark is printed 
		System.out.println("Average Criterion mark: " + totalGrades / size);
		return totalGrades / rubric.getStudentGrade().size();

	}

	// minimum and maximum score
	public int maximumScoreCriterion(Criterion criterion, Rubric rubric) {
		ArrayList<Integer> results = new ArrayList<>();
		int positionCriterion = 0;
		for (Criterion c : rubric.getCriterion()) {
			positionCriterion++;
			if (c.getCriterionName().equalsIgnoreCase(criterion.getCriterionName())) {
				break;
			}
		}
		for (StudentGrade student : rubric.getStudentGrade()) {

			results.add(student.getStudentGrade().get(positionCriterion - 1).getScore());

		}
		System.out.println("Maximum mark: " + Collections.max(results));
		return Collections.max(results);

	}

	public int minimumScoreCriterion(Criterion criterion, Rubric rubric) {
		ArrayList<Integer> results = new ArrayList<>();
		int positionCriterion = 0;
		for (Criterion c : rubric.getCriterion()) {
			positionCriterion++;
			if (c.getCriterionName().equalsIgnoreCase(criterion.getCriterionName())) {
				break;
			}
		}
		for (StudentGrade student : rubric.getStudentGrade()) {

			results.add(student.getStudentGrade().get(positionCriterion - 1).getScore());

		}
		System.out.println("Minimum mark: " + Collections.min(results));
		return Collections.min(results);

	}

	public double calculateStandardDeviationCriterion(Criterion criterion, Rubric rubric) {

		ArrayList<Integer> results = new ArrayList<>();
		int positionCriterion = 0;
		for (Criterion c : rubric.getCriterion()) {
			positionCriterion++;
			if (c.getCriterionName().equalsIgnoreCase(criterion.getCriterionName())) {
				break;
			}
		}
		for (StudentGrade student : rubric.getStudentGrade()) {

			results.add(student.getStudentGrade().get(positionCriterion - 1).getScore());

		}
		double standardDeviation = 0.0;
		int sum = results.stream().mapToInt(Integer::intValue).sum();
		double mean = sum / results.size();
		for (double num : results) {
			standardDeviation += Math.pow(num - mean, 2);
		}

		System.out.println("Standard deviation: " + Math.sqrt(standardDeviation / results.size()));
		return Math.sqrt(standardDeviation / results.size());

	}

}
