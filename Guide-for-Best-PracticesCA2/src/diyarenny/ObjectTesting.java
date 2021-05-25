package diyarenny;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ObjectTesting {

	//RubricController object
	RubricController rubricController = new RubricController();

	//Class that tests all the objects
	@Test
	void test() {
		//arraylist of criterions
		ArrayList<Criterion> c1 = new ArrayList<>();
		// arrayliist of student grades
		ArrayList<StudentGrade> g2 = new ArrayList<>();

		// Rubric sample 1
		String rubricName = "Exam";
		String[] criterionName = { "Design", "Planing", "Implementation", "Testing", "Software Component",
				"Documentation" };
		Student student = new Student("Diya Renny");
		Grade[] grades = { new Grade(3), new Grade(2), new Grade(2), new Grade(4), new Grade(4), new Grade(4) };
		Grade[] grades2 = { new Grade(3), new Grade(1), new Grade(2), new Grade(3), new Grade(2), new Grade(1), };

		// Rubric sample 2
		String[] criterionNam = { "Design", "Testing", "Implementation", "Planing", "Software Component",
				"Documentation", "Criterion1", "Criterion2", "Criterion3", "Criterion4" };
		Student student1 = new Student("James Thomas");
		Grade[] grades1 = { new Grade(3), new Grade(2), new Grade(2), new Grade(4), new Grade(4), new Grade(4),
				new Grade(5), new Grade(5), new Grade(5), new Grade(3) };

		c1 = rubricController.addCriterion(criterionName);
		//tests criterion name
		assertEquals("Design", c1.get(1).getCriterionName());
		//creates student grade
		StudentGrade studentGrade1 = rubricController.createStudentGrade(grades, student);
		g2.add(studentGrade1);
		//tests student name
		assertEquals("Diya Renny", g2.get(0).getStudent().getStudentName());
		//creates student grade2
		StudentGrade studentGrade2 = rubricController.createStudentGrade(grades2, student);
		g2.add(studentGrade2);
		//creates student grade3
		StudentGrade studentGrade3 = rubricController.createStudentGrade(grades, student);
		g2.add(studentGrade3);
		rubricController.createRubric(rubricName, c1, g2);

		g2 = new ArrayList<>();
		c1 = rubricController.addCriterion(criterionNam);
		//creates student grade
		StudentGrade studentGrade4 = rubricController.createStudentGrade(grades1, student1);
		g2.add(studentGrade4);
		//creates new rubric
		rubricController.createRubric("New Rubric", c1, g2);
		//test checks if passes
		assertEquals(2, g2.get(0).getStudentGrade().get(2).getScore());

		rubricController.getAllRubrics();

	}

}
