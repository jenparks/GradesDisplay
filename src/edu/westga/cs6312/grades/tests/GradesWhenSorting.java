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
public class GradesWhenSorting {

	/**
	 * Tests sorting two students, same last name
	 */
	@Test
	public void testSort2StudentsSameLast() {
		Grades testGrades1 = new Grades();
		testGrades1.setFirstName("John");
		testGrades1.setLastName("Smith");

		Grades testGrades2 = new Grades();
		testGrades1.setFirstName("Jane");
		testGrades1.setLastName("Smith");

		int result = testGrades1.compareTo(testGrades2);
		assertEquals(-1, result);
	}

	/**
	 * Tests sorting two students, different last name
	 */
	@Test
	public void testSort2StudentsDifferentLast() {
		Grades testGrades1 = new Grades();
		testGrades1.setFirstName("John");
		testGrades1.setLastName("Andrews");

		Grades testGrades2 = new Grades();
		testGrades1.setFirstName("Jane");
		testGrades1.setLastName("Smith");

		int result = testGrades1.compareTo(testGrades2);
		assertEquals(-1, result);
	}

}
