package diyarenny;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class RubricTesting {

	//RubricController object
	RubricController rubricController = new RubricController();

	//Class that tests all the calculations/functions
	//unit test for average of a rubric
	@Test
	void calculateRubricAverage() {
		ArrayList<Criterion> criterionList = new ArrayList<>();
		ArrayList<StudentGrade> studentGradeList = new ArrayList<>();
		ArrayList<Grade> gradeList = new ArrayList<>();
		criterionList.add(new Criterion("Planning"));
		criterionList.add(new Criterion("Design"));
		gradeList.add(new Grade(1));
		gradeList.add(new Grade(2));
		studentGradeList.add(new StudentGrade(new Student("Diya"), gradeList));
		studentGradeList.add(new StudentGrade(new Student("James"), gradeList));
		Rubric rubric = new Rubric("New Rubric", criterionList, studentGradeList);
		//tests rubric average function
		assertEquals(3, rubricController.calculateRubricAverage(rubric));

	}

	//unit test for maximum score of a rubric
	@Test
	void maximumScoreRubric() {
		ArrayList<Criterion> criterionList = new ArrayList<>();
		ArrayList<StudentGrade> studentGradeList = new ArrayList<>();
		ArrayList<Grade> gradeList = new ArrayList<>();
		criterionList.add(new Criterion("Design"));
		criterionList.add(new Criterion("Software Quality"));
		gradeList.add(new Grade(1));
		gradeList.add(new Grade(2));
		studentGradeList.add(new StudentGrade(new Student("Diya"), gradeList));
		studentGradeList.add(new StudentGrade(new Student("James"), gradeList));
		Rubric rubric = new Rubric("Exam", criterionList, studentGradeList);
		//tests rubric maximum score of rubric function
		assertEquals(2, rubricController.maximumScoreRubric(rubric));

	}

	//unit test for mimimum score of a rubric
	@Test
	void minimumScoreRubric() {
		ArrayList<Criterion> criterionList = new ArrayList<>();
		ArrayList<StudentGrade> studentGradeList = new ArrayList<>();
		ArrayList<Grade> gradeList = new ArrayList<>();
		criterionList.add(new Criterion("Testing"));
		criterionList.add(new Criterion("Software Quality"));
		gradeList.add(new Grade(1));
		gradeList.add(new Grade(2));
		studentGradeList.add(new StudentGrade(new Student("Diya"), gradeList));
		studentGradeList.add(new StudentGrade(new Student("James"), gradeList));
		studentGradeList.add(new StudentGrade(new Student("Amy"), gradeList));
		Rubric rubric = new Rubric("New Rubric", criterionList, studentGradeList);
		//tests rubric minimum score of rubric function
		assertEquals(1, rubricController.minimumScoreRubric(rubric));

	}

	//unit test for standard deviation of a rubric
	@Test
	void calculateStandardDeviation() {
		ArrayList<Criterion> criterionList = new ArrayList<>();
		ArrayList<StudentGrade> studentGradeList = new ArrayList<>();
		ArrayList<Grade> gradeList = new ArrayList<>();
		criterionList.add(new Criterion("Testing"));
		criterionList.add(new Criterion("Planing"));
		gradeList.add(new Grade(1));
		gradeList.add(new Grade(4));
		studentGradeList.add(new StudentGrade(new Student("Diya"), gradeList));
		studentGradeList.add(new StudentGrade(new Student("James"), gradeList));
		studentGradeList.add(new StudentGrade(new Student("Amy"), gradeList));
		studentGradeList.add(new StudentGrade(new Student("Ella"), gradeList));
		Rubric rubric = new Rubric("Exam", criterionList, studentGradeList);
		//tests rubric standard deviation of rubric function
		assertEquals(1.5811388300841898, rubricController.calculateStandardDeviation(rubric));

	}

	//unit test for mimimum score of a criterion
	@Test
	void minimumScoreCriterion() {
		ArrayList<Criterion> criterionList = new ArrayList<>();
		ArrayList<StudentGrade> studentGradeList = new ArrayList<>();
		ArrayList<Grade> gradeList = new ArrayList<>();
		criterionList.add(new Criterion("Design"));
		criterionList.add(new Criterion("Planing"));
		gradeList.add(new Grade(5));
		gradeList.add(new Grade(3));
		studentGradeList.add(new StudentGrade(new Student("Diya"), gradeList));
		studentGradeList.add(new StudentGrade(new Student("James"), gradeList));
		Rubric rubric = new Rubric("Exam", criterionList, studentGradeList);
		//tests rubric mimium score of criterion function
		assertEquals(3, rubricController.minimumScoreCriterion(new Criterion("Planing"), rubric));

	}

	//unit test for maximum score of a criterion
	@Test
	void maximumScoreCriterion() {
		ArrayList<Criterion> criterionList = new ArrayList<>();
		ArrayList<StudentGrade> studentGradeList = new ArrayList<>();
		ArrayList<Grade> gradeList = new ArrayList<>();
		criterionList.add(new Criterion("Design"));
		criterionList.add(new Criterion("Planing"));
		gradeList.add(new Grade(5));
		gradeList.add(new Grade(4));
		studentGradeList.add(new StudentGrade(new Student("Diya"), gradeList));
		studentGradeList.add(new StudentGrade(new Student("James"), gradeList));
		Rubric rubric = new Rubric("Exam", criterionList, studentGradeList);
		//tests rubric maximum score of criterion function
		assertEquals(5, rubricController.maximumScoreCriterion(new Criterion("Design"), rubric));

	}

	//unit test for standard deviation of a criterion
	@Test
	void calculateStandardDeviationCriterion() {
		ArrayList<Criterion> criterionList = new ArrayList<>();
		ArrayList<StudentGrade> studentGradeList = new ArrayList<>();
		ArrayList<Grade> gradeList = new ArrayList<>();
		ArrayList<Grade> gradeList2 = new ArrayList<>();
		criterionList.add(new Criterion("Design"));
		criterionList.add(new Criterion("Planing"));
		gradeList.add(new Grade(4));
		gradeList.add(new Grade(2));
		gradeList2.add(new Grade(3));
		gradeList2.add(new Grade(1));
		studentGradeList.add(new StudentGrade(new Student("Diya"), gradeList));
		studentGradeList.add(new StudentGrade(new Student("James"), gradeList2));
		Rubric rubric = new Rubric("Exam", criterionList, studentGradeList);
		//tests rubric standard deviation of criterion function
		assertEquals(0.7071067811865476,
				rubricController.calculateStandardDeviationCriterion(new Criterion("Design"), rubric));

	}

}
