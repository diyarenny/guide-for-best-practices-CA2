package diyarenny;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class RubricTest {

	RubricController rubricController = new RubricController();

	@Test
	void calculateRubricAverage() {
		ArrayList<Criterion> criterionList = new ArrayList<>();
		ArrayList<StudentGrade> studentGradeList = new ArrayList<>();
		ArrayList<Grade> gradeList = new ArrayList<>();
		criterionList.add(new Criterion("Implementation"));
		criterionList.add(new Criterion("Planing"));
		gradeList.add(new Grade(1));
		gradeList.add(new Grade(2));
		studentGradeList.add(new StudentGrade(new Student("Diya"), gradeList));
		studentGradeList.add(new StudentGrade(new Student("Amy"), gradeList));
		Rubric rubric = new Rubric("Exam", criterionList, studentGradeList);
		assertEquals(3, rubricController.calculateRubricAverage(rubric));

	}

	@Test
	void maximumScoreRubric() {
		ArrayList<Criterion> criterionList = new ArrayList<>();
		ArrayList<StudentGrade> studentGradeList = new ArrayList<>();
		ArrayList<Grade> gradeList = new ArrayList<>();
		criterionList.add(new Criterion("Design"));
		criterionList.add(new Criterion("Software Component"));
		gradeList.add(new Grade(1));
		gradeList.add(new Grade(2));
		studentGradeList.add(new StudentGrade(new Student("Diya"), gradeList));
		studentGradeList.add(new StudentGrade(new Student("Amy"), gradeList));
		Rubric rubric = new Rubric("Exam", criterionList, studentGradeList);
		assertEquals(2, rubricController.maximumScoreRubric(rubric));
	}

	@Test
	void minimumScoreRubric() {
		ArrayList<Criterion> criterionList = new ArrayList<>();
		ArrayList<StudentGrade> studentGradeList = new ArrayList<>();
		ArrayList<Grade> gradeList = new ArrayList<>();
		criterionList.add(new Criterion("Testing"));
		criterionList.add(new Criterion("Software Component"));
		gradeList.add(new Grade(1));
		gradeList.add(new Grade(2));
		studentGradeList.add(new StudentGrade(new Student("Diya"), gradeList));
		studentGradeList.add(new StudentGrade(new Student("Amy"), gradeList));
		studentGradeList.add(new StudentGrade(new Student("Chloe"), gradeList));
		Rubric rubric = new Rubric("Exam", criterionList, studentGradeList);
		assertEquals(1, rubricController.minimumScoreRubric(rubric));
	}

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
		studentGradeList.add(new StudentGrade(new Student("Amy"), gradeList));
		studentGradeList.add(new StudentGrade(new Student("Chloe"), gradeList));
		studentGradeList.add(new StudentGrade(new Student("Mark"), gradeList));
		Rubric rubric = new Rubric("Exam", criterionList, studentGradeList);
		assertEquals(1.5811388300841898, rubricController.calculateStandardDeviation(rubric));

	}

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
		studentGradeList.add(new StudentGrade(new Student("Amy"), gradeList));
		Rubric rubric = new Rubric("Exam", criterionList, studentGradeList);
		assertEquals(3, rubricController.minimumScoreCriterion(new Criterion("Planing"), rubric));

	}

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
		studentGradeList.add(new StudentGrade(new Student("Amy"), gradeList));
		Rubric rubric = new Rubric("Exam", criterionList, studentGradeList);
		assertEquals(5, rubricController.maximumScoreCriterion(new Criterion("Design"), rubric));

	}

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
		studentGradeList.add(new StudentGrade(new Student("Amy"), gradeList2));
		Rubric rubric = new Rubric("Exam", criterionList, studentGradeList);
		assertEquals(0.7071067811865476,
				rubricController.calculateStandardDeviationCriterion(new Criterion("Design"), rubric));

	}


}
