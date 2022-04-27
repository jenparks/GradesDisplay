/**
 * 
 */

package edu.westga.cs6312.grades.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.grades.model.Grades;

/**
 * Creates JUnit test cases for Grades class
 * 
 * @author Jennifer Parks
 * @version Apr 25, 2022
 *
 */
public class GradesWhenCreateGradesSumAndAverageGrades {

	/**
	 * Tests creating Grades object, sum lab grades
	 */
	@Test
	public void testCreateGradesSum3LabGrades() {
		Grades testGrades = new Grades();
		testGrades.setGradesLab(50);
		testGrades.setGradesLab(50);
		testGrades.setGradesLab(50);
		double result = testGrades.sumGradesLab();
		assertEquals(150.0, result);
	}

	/**
	 * Tests creating Grades object, sum project grades
	 */
	@Test
	public void testCreateGradesSum3ProjectGrades() {
		Grades testGrades = new Grades();
		testGrades.setGradesProject(95);
		testGrades.setGradesProject(50);
		testGrades.setGradesProject(50);
		double result = testGrades.sumGradesProject();
		assertEquals(195.0, result);
	}

	/**
	 * Tests creating Grades object, sum test grades
	 */
	@Test
	public void testCreateGradesSum3TestGrades() {
		Grades testGrades = new Grades();
		testGrades.setGradesTest(50);
		testGrades.setGradesTest(20);
		testGrades.setGradesTest(30);
		double result = testGrades.sumGradesTest();
		assertEquals(100.0, result);
	}

	/**
	 * Tests creating Grades object, average lab grades
	 */
	@Test
	public void testCreateGradesAverage3LabGrades() {
		Grades totalPoints = new Grades();
		totalPoints.setGradesLab(100);
		totalPoints.setGradesLab(100);
		totalPoints.setGradesLab(100);

		Grades testGrades = new Grades();
		testGrades.setTotalPoints(totalPoints);
		testGrades.setGradesLab(50);
		testGrades.setGradesLab(50);
		testGrades.setGradesLab(50);
		double result = testGrades.getLabAverage();
		assertEquals(0.50, result);
	}

	/**
	 * Tests creating Grades object, average project grades
	 */
	@Test
	public void testCreateGradesAverage3ProjectGrades() {
		Grades totalPoints = new Grades();
		totalPoints.setGradesProject(100);
		totalPoints.setGradesProject(100);
		totalPoints.setGradesProject(100);

		Grades testGrades = new Grades();
		testGrades.setTotalPoints(totalPoints);
		testGrades.setGradesProject(100);
		testGrades.setGradesProject(50);
		testGrades.setGradesProject(3);
		double result = testGrades.getProjectAverage();
		assertEquals(0.51, result);
	}

	/**
	 * Tests creating Grades object, average test grades
	 */
	@Test
	public void testCreateGradesAverage3TestGrades() {
		Grades totalPoints = new Grades();
		totalPoints.setGradesTest(100);
		totalPoints.setGradesTest(100);
		totalPoints.setGradesTest(100);

		Grades testGrades = new Grades();
		testGrades.setTotalPoints(totalPoints);
		testGrades.setGradesTest(50);
		testGrades.setGradesTest(20);
		testGrades.setGradesTest(32);
		double result = testGrades.getTestAverage();
		assertEquals(0.34, result);
	}

	/**
	 * Tests creating Grades object, calculate overall average straight
	 */
	@Test
	public void testCreateGradesGetStraightAverage() {
		Grades gradesPotential = new Grades();
		gradesPotential.setGradesLab(100);
		gradesPotential.setGradesLab(100);
		gradesPotential.setGradesProject(100);
		gradesPotential.setGradesProject(100);
		gradesPotential.setGradesTest(100);

		Grades gradesStudent = new Grades();
		gradesStudent.setTotalPoints(gradesPotential);
		gradesStudent.setGradesLab(90);
		gradesStudent.setGradesLab(80);
		gradesStudent.setGradesProject(70);
		gradesStudent.setGradesProject(90);
		gradesStudent.setGradesTest(50);

		double result = gradesStudent.getStraightAverage();
		assertEquals(0.76, result);
	}

	/**
	 * Tests creating Grades object, calculate overall average weighted
	 */
	@Test
	public void testCreateGradebookGetWeightedAverage() {
		Grades gradesPotential = new Grades();
		gradesPotential.setGradesLab(100);
		gradesPotential.setGradesLab(100);
		gradesPotential.setGradesProject(100);
		gradesPotential.setGradesProject(100);
		gradesPotential.setGradesTest(100);

		Grades gradesStudent = new Grades();
		gradesStudent.setTotalPoints(gradesPotential);
		gradesStudent.setGradesLab(90);
		gradesStudent.setGradesLab(80);
		gradesStudent.setGradesProject(70);
		gradesStudent.setGradesProject(100);
		gradesStudent.setGradesTest(75);

		double result = gradesStudent.getWeightedAverage();
		assertEquals(0.805, result);
	}

}
