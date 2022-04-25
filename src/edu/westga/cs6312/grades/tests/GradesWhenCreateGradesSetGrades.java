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
		ArrayList<Integer> result = testGrades.getGradesLab();
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(50);
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
		ArrayList<Integer> result = testGrades.getGradesLab();
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(50);
		expected.add(70);
		assertEquals(expected, result);
	}

	/**
	 * Tests creating Grades object, get project grades
	 */
	@Test
	public void testCreateGradesGetProjectGrades1Added() {
		Grades testGrades = new Grades();
		testGrades.setGradesProject(20);
		ArrayList<Integer> result = testGrades.getGradesProject();
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(20);
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
		ArrayList<Integer> result = testGrades.getGradesProject();
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(20);
		expected.add(75);
		assertEquals(expected, result);
	}

	/**
	 * Tests creating Grades object, get test grades
	 */
	@Test
	public void testCreateGradesGetTestGrades1Added() {
		Grades testGrades = new Grades();
		testGrades.setGradesTest(33);
		ArrayList<Integer> result = testGrades.getGradesTest();
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(33);
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
		ArrayList<Integer> result = testGrades.getGradesTest();
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(33);
		expected.add(92);
		assertEquals(expected, result);
	}

}
