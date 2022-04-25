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
public class GradesWhenCreateGradesSetStrings {

	/**
	 * Tests creating Grades object, get ID
	 */
	@Test
	public void testCreateGradesGetID() {
		Grades testGrades = new Grades();
		String result = testGrades.getStudentID();
		assertEquals("", result);
	}

	/**
	 * Tests creating Grades object, set & get ID
	 */
	@Test
	public void testCreateGradesSetAndGetID() {
		Grades testGrades = new Grades();
		testGrades.setStudentID("1234");
		String result = testGrades.getStudentID();
		assertEquals("1234", result);
	}

	/**
	 * Tests creating Grades object, get first name
	 */
	@Test
	public void testCreateGradesGetFirstName() {
		Grades testGrades = new Grades();
		String result = testGrades.getFirstName();
		assertEquals("", result);
	}

	/**
	 * Tests creating Grades object, set & get first name
	 */
	@Test
	public void testCreateGradesSetAndGetFirstName() {
		Grades testGrades = new Grades();
		testGrades.setFirstName("Jen");
		String result = testGrades.getFirstName();
		assertEquals("Jen", result);
	}

	/**
	 * Tests creating Grades object, get last name
	 */
	@Test
	public void testCreateGradesGetLastName() {
		Grades testGrades = new Grades();
		String result = testGrades.getLastName();
		assertEquals("", result);
	}

	/**
	 * Tests creating Grades object, set & get last name
	 */
	@Test
	public void testCreateGradesSetAndGetLastName() {
		Grades testGrades = new Grades();
		testGrades.setLastName("Parks");
		String result = testGrades.getLastName();
		assertEquals("Parks", result);
	}

}
