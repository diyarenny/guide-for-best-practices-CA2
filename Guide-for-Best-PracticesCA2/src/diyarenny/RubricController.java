package diyarenny;

import java.util.ArrayList;
import java.util.Collections;

public class RubricController {

	static ArrayList<Rubric> r2 = new ArrayList<>();
	static int criterionSize;
	static int gradesSize;

	public ArrayList<Criterion> addCriterion(String[] criterionName) {
		ArrayList<Criterion> c1 = new ArrayList<>();
		criterionSize = criterionName.length;

		if (criterionName.length <= 10) {
			for (int i = 0; i <= criterionName.length - 1; i++) {
				Criterion criterion = new Criterion(criterionName[i]);
				c1.add(criterion);

			}
		} else {

			System.out.println("You can only add the maximum of 10 Criterion!");
		}

		return c1;

	}

	public StudentGrade createStudentGrade(Grade[] grades, Student student) {
		StudentGrade studentGrade = null;
		gradesSize = grades.length;
		if (checkEquals()) {
			if (grades.length <= 10) {
				ArrayList<Grade> g1 = new ArrayList<>();
				for (int i = 0; i <= grades.length - 1; i++) {
					if (checkGradeRange(grades[i])) {
						g1.add(grades[i]);
					}
				}
				studentGrade = new StudentGrade(student, g1);
			} else {

				System.out.println("You can only add the maximum of 10 Grades!");
			}
		}
		return studentGrade;

	}

	public static boolean checkGradeRange(Grade grade) {

		if (0 > grade.getScore() || grade.getScore() > 5) {
			System.out.println("Error: Grade must be between 1-5");
			return false;

		} else {
			return true;
		}

	}

	public static boolean checkEquals() {

		if (!(gradesSize == criterionSize)) {

			System.out.println(
					"Error: The grades you entered for this student does not match the criterion size of the rubric");
			return false;
		} else {

			return true;
		}
	}

	public void createRubric(String rubricName, ArrayList<Criterion> c1, ArrayList<StudentGrade> g2) {

		if (checkEmptyCriterion(c1) || checkEmptyStudentGrade(g2) || checkEmptyRubricName(rubricName)) {
			Rubric rubric = new Rubric(rubricName, c1, g2);
			r2.add(rubric);

		}

	}

	public static boolean checkEmptyRubricName(String rubricName) {

		if (rubricName.equals("")) {
			System.out.println("Error: You must add a name to your Rubric");
			return false;
		} else {

			return true;
		}

	}

	public static boolean checkEmptyStudentGrade(ArrayList<StudentGrade> g1) {

		if (g1.isEmpty()) {
			System.out.println("Error: You have no Student Grade's added to the rubric");
			return false;
		} else {

			return true;
		}

	}

	public static boolean checkEmptyCriterion(ArrayList<Criterion> c1) {

		if (c1.isEmpty()) {
			System.out.println("Error: You have no criterion's added to the rubric");
			return false;
		} else {

			return true;
		}

	}

	public static void getRubrikByName(String rubricName) {
		for (Rubric r : r2) {
			if (r.getRubricName().equalsIgnoreCase(rubricName)) {
				System.out.println("\n----------- " + r.getRubricName() + " ----------- ");
				// --------------------- Rubric Header -----------------------
				System.out.printf("%-15s", "Student Name");

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

	public void getAllRubrics() {

		for (Rubric r : r2) {

			System.out.println("\n----------- " + r.getRubricName() + " ----------- ");
			// --------------------- Rubric Header -----------------------
			System.out.printf("%-15s", "Student Name");

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

	}

	// Calculations
	public float calculateRubricAverage(Rubric rubric) {
		float totalGrades = 0;
		float size = 0;

		for (StudentGrade student : rubric.getStudentGrade()) {
			for (Grade grade : student.getStudentGrade()) {
				totalGrades += grade.getScore();
				size++;
			}

		}

		System.out.println("Average rubric mark: " + totalGrades / size);
		return totalGrades / rubric.getStudentGrade().size();

	}

	// minimum and maximum score
	public int maximumScoreRubric(Rubric rubric) {
		ArrayList<Integer> results = new ArrayList<>();

		for (StudentGrade student : rubric.getStudentGrade()) {
			for (Grade grade : student.getStudentGrade()) {
				results.add(grade.getScore());

			}

		}
		System.out.println("Maximum mark: " + Collections.max(results));
		return Collections.max(results);

	}

	public int minimumScoreRubric(Rubric rubric) {
		ArrayList<Integer> results = new ArrayList<>();

		for (StudentGrade student : rubric.getStudentGrade()) {
			for (Grade grade : student.getStudentGrade()) {
				results.add(grade.getScore());

			}

		}
		System.out.println("Minimum mark: " + Collections.min(results));
		return Collections.min(results);

	}

	public double calculateStandardDeviation(Rubric rubric) {

		ArrayList<Integer> results = new ArrayList<>();
		for (StudentGrade student : rubric.getStudentGrade()) {
			for (Grade grade : student.getStudentGrade()) {
				results.add(grade.getScore());

			}

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

	// Calculations
	public double calculateCriterionAverage(Criterion criterion, Rubric rubric) {

		int positionCriterion = 0;
		double totalGrades = 0;
		double size = 0;
		for (Criterion c : rubric.getCriterion()) {
			positionCriterion++;
			if (c.getCriterionName().equalsIgnoreCase(criterion.getCriterionName())) {
				break;
			}
		}
		for (StudentGrade student : rubric.getStudentGrade()) {

			totalGrades += student.getStudentGrade().get(positionCriterion - 1).getScore();
			size++;

		}

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
