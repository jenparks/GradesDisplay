/**
 * 
 */

package edu.westga.cs6312.grades.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.grades.model.Gradebook;
import edu.westga.cs6312.grades.model.Grades;

/**
 * Creates JUnit test cases for Gradebook class
 * 
 * @author Jennifer Parks
 * @version Apr 26, 2022
 *
 */
public class GradebookWhenClassAverages {

	/**
	 * Tests getting class average for labs
	 */
	@Test
	public void testClassAverageLab() {
		Gradebook testGradebook = new Gradebook();
		Grades addGradesTotal = new Grades();
		addGradesTotal.setGradesLab(100.0);
		addGradesTotal.setGradesLab(100.0);
		addGradesTotal.setGradesLab(100.0);
		addGradesTotal.setGradesLab(100.0);
		testGradebook.addToPotentialPoints(addGradesTotal);

		Grades addGrades1 = new Grades();
		addGrades1.setGradesLab(50.0);
		addGrades1.setGradesLab(50.0);
		addGrades1.setGradesLab(60.0);
		addGrades1.setGradesLab(80.0);
		testGradebook.addToGradebook(addGrades1);

		Grades addGrades2 = new Grades();
		addGrades2.setGradesLab(50.0);
		addGrades2.setGradesLab(30.0);
		addGrades2.setGradesLab(60.0);
		addGrades2.setGradesLab(60.0);
		testGradebook.addToGradebook(addGrades2);

		double result = testGradebook.getClassAverageLab();
		assertEquals(0.55, result);
	}

	/**
	 * Tests getting class average for projects
	 */
	@Test
	public void testClassAverageProject() {
		Gradebook testGradebook = new Gradebook();
		Grades addGradesTotal = new Grades();
		addGradesTotal.setGradesProject(100.0);
		addGradesTotal.setGradesProject(100.0);
		addGradesTotal.setGradesProject(100.0);
		addGradesTotal.setGradesProject(100.0);
		testGradebook.addToPotentialPoints(addGradesTotal);

		Grades addGrades1 = new Grades();
		addGrades1.setGradesProject(50.0);
		addGrades1.setGradesProject(100.0);
		addGrades1.setGradesProject(60.0);
		addGrades1.setGradesProject(100.0);
		testGradebook.addToGradebook(addGrades1);

		Grades addGrades2 = new Grades();
		addGrades2.setGradesProject(50.0);
		addGrades2.setGradesProject(50.0);
		addGrades2.setGradesProject(100.0);
		addGrades2.setGradesProject(90.0);
		testGradebook.addToGradebook(addGrades2);

		double result = testGradebook.getClassAverageProject();
		assertEquals(0.75, result);
	}

	/**
	 * Tests getting class average for tests
	 */
	@Test
	public void testClassAverageTest() {
		Gradebook testGradebook = new Gradebook();
		Grades addGradesTotal = new Grades();
		addGradesTotal.setGradesTest(100.0);
		addGradesTotal.setGradesTest(100.0);
		addGradesTotal.setGradesTest(100.0);
		addGradesTotal.setGradesTest(100.0);
		testGradebook.addToPotentialPoints(addGradesTotal);

		Grades addGrades1 = new Grades();
		addGrades1.setGradesTest(50.0);
		addGrades1.setGradesTest(50.0);
		addGrades1.setGradesTest(90.0);
		addGrades1.setGradesTest(90.0);
		testGradebook.addToGradebook(addGrades1);

		Grades addGrades2 = new Grades();
		addGrades2.setGradesTest(90.0);
		addGrades2.setGradesTest(90.0);
		addGrades2.setGradesTest(60.0);
		addGrades2.setGradesTest(60.0);
		testGradebook.addToGradebook(addGrades2);

		double result = testGradebook.getClassAverageTest();
		assertEquals(0.725, result);
	}

	/**
	 * Tests getting class average for straight averages
	 */
	@Test
	public void testClassAverageStraight() {
		Gradebook testGradebook = new Gradebook();
		Grades addGradesTotal = new Grades();
		addGradesTotal.setGradesLab(100.0);
		addGradesTotal.setGradesLab(100.0);
		addGradesTotal.setGradesLab(100.0);
		addGradesTotal.setGradesLab(100.0);
		addGradesTotal.setGradesProject(100.0);
		addGradesTotal.setGradesProject(100.0);
		addGradesTotal.setGradesProject(100.0);
		addGradesTotal.setGradesTest(100.0);
		testGradebook.addToPotentialPoints(addGradesTotal);

		Grades addGrades1 = new Grades();
		addGrades1.setGradesLab(50.0);
		addGrades1.setGradesLab(50.0);
		addGrades1.setGradesLab(60.0);
		addGrades1.setGradesLab(80.0);
		addGrades1.setGradesProject(50.0);
		addGrades1.setGradesProject(100.0);
		addGrades1.setGradesProject(100.0);
		addGrades1.setGradesTest(50.0);
		testGradebook.addToGradebook(addGrades1);

		Grades addGrades2 = new Grades();
		addGrades2.setGradesLab(50.0);
		addGrades2.setGradesLab(30.0);
		addGrades2.setGradesLab(60.0);
		addGrades2.setGradesLab(60.0);
		addGrades2.setGradesProject(50.0);
		addGrades2.setGradesProject(50.0);
		addGrades2.setGradesProject(100.0);
		addGrades2.setGradesTest(90.0);
		testGradebook.addToGradebook(addGrades2);

		double result = testGradebook.getClassAverageStraight();
		assertEquals(0.64375, result);
	}

	/**
	 * Tests getting class average for weighted averages
	 */
	@Test
	public void testClassAverageWeighted() {
		Gradebook testGradebook = new Gradebook();
		Grades addGradesTotal = new Grades();
		addGradesTotal.setGradesLab(100.0);
		addGradesTotal.setGradesLab(100.0);
		addGradesTotal.setGradesLab(100.0);
		addGradesTotal.setGradesLab(100.0);
		addGradesTotal.setGradesProject(100.0);
		addGradesTotal.setGradesProject(100.0);
		addGradesTotal.setGradesProject(100.0);
		addGradesTotal.setGradesTest(100.0);
		testGradebook.addToPotentialPoints(addGradesTotal);

		Grades addGrades1 = new Grades();
		addGrades1.setGradesLab(50.0);
		addGrades1.setGradesLab(50.0);
		addGrades1.setGradesLab(60.0);
		addGrades1.setGradesLab(80.0);
		addGrades1.setGradesProject(50.0);
		addGrades1.setGradesProject(100.0);
		addGrades1.setGradesProject(100.0);
		addGrades1.setGradesTest(50.0);
		testGradebook.addToGradebook(addGrades1);

		Grades addGrades2 = new Grades();
		addGrades2.setGradesLab(50.0);
		addGrades2.setGradesLab(30.0);
		addGrades2.setGradesLab(60.0);
		addGrades2.setGradesLab(60.0);
		addGrades2.setGradesProject(50.0);
		addGrades2.setGradesProject(50.0);
		addGrades2.setGradesProject(100.0);
		addGrades2.setGradesTest(90.0);
		testGradebook.addToGradebook(addGrades2);

		double result = testGradebook.getClassAverageWeighted();
		assertEquals(0.6875, result);
	}

}
