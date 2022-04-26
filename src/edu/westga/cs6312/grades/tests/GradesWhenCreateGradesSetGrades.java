/**
 * 
 */

package edu.westga.cs6312.grades.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.grades.model.Grades;

/**
 * Creates JUnit test cases for Grades class
 * 
 * @author Jennifer Parks
 * @version Apr 25, 2022
 *
 */
public class GradesWhenCreateGradesSetGrades {

	/**
	 * Tests creating Grades object, get lab grades
	 */
	@Test
	public void testCreateGradesGetLabGrades1Added() {
		Grades testGrades = new Grades();
		testGrades.setGradesLab(50);
		ArrayList<Double> result = testGrades.getGradesLab();
		ArrayList<Double> expected = new ArrayList<Double>();
		expected.add(50.0);
		assertEquals(expected, result);
	}

	/**
	 * Tests creating Grades object, get lab grades
	 */
	@Test
	public void testCreateGradesGetLabGrades2Added() {
		Grades testGrades = new Grades();
		testGrades.setGradesLab(50);
		testGrades.setGradesLab(70);
		ArrayList<Double> result = testGrades.getGradesLab();
		ArrayList<Double> expected = new ArrayList<Double>();
		expected.add(50.0);
		expected.add(70.0);
		assertEquals(expected, result);
	}

	/**
	 * Tests creating Grades object, get project grades
	 */
	@Test
	public void testCreateGradesGetProjectGrades1Added() {
		Grades testGrades = new Grades();
		testGrades.setGradesProject(20);
		ArrayList<Double> result = testGrades.getGradesProject();
		ArrayList<Double> expected = new ArrayList<Double>();
		expected.add(20.0);
		assertEquals(expected, result);
	}

	/**
	 * Tests creating Grades object, get project grades
	 */
	@Test
	public void testCreateGradesGetProjectGrades2Added() {
		Grades testGrades = new Grades();
		testGrades.setGradesProject(20);
		testGrades.setGradesProject(75);
		ArrayList<Double> result = testGrades.getGradesProject();
		ArrayList<Double> expected = new ArrayList<Double>();
		expected.add(20.0);
		expected.add(75.0);
		assertEquals(expected, result);
	}

	/**
	 * Tests creating Grades object, get test grades
	 */
	@Test
	public void testCreateGradesGetTestGrades1Added() {
		Grades testGrades = new Grades();
		testGrades.setGradesTest(33);
		ArrayList<Double> result = testGrades.getGradesTest();
		ArrayList<Double> expected = new ArrayList<Double>();
		expected.add(33.0);
		assertEquals(expected, result);
	}

	/**
	 * Tests creating Grades object, get test grades
	 */
	@Test
	public void testCreateGradesGetTestGrades2Added() {
		Grades testGrades = new Grades();
		testGrades.setGradesTest(33);
		testGrades.setGradesTest(92);
		ArrayList<Double> result = testGrades.getGradesTest();
		ArrayList<Double> expected = new ArrayList<Double>();
		expected.add(33.0);
		expected.add(92.0);
		assertEquals(expected, result);
	}

}
