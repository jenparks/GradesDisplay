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
public class GradesWhenCreateGradesSumGrades {

	/**
	 * Tests creating Grades object, sum lab grades
	 */
	@Test
	public void testCreateGradesSum3LabGrades() {
		Grades testGrades = new Grades();
		testGrades.setGradesLab(50);
		testGrades.setGradesLab(50);
		testGrades.setGradesLab(50);
		int result = testGrades.sumGradesLab();
		assertEquals(150, result);
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
		int result = testGrades.sumGradesProject();
		assertEquals(195, result);
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
		int result = testGrades.sumGradesTest();
		assertEquals(100, result);
	}

}
