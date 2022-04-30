/**
 * 
 */

package edu.westga.cs6312.grades.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

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
public class GradebookWhenCreateGradebook {

	/**
	 * Tests creating Gradebook object, add object to student gradebook
	 */
	@Test
	public void testCreateGradebook1Student() {
		Gradebook testGradebook = new Gradebook();
		Grades addGrades1 = new Grades();
		testGradebook.addToGradebook(addGrades1);
		ArrayList<Grades> expected = new ArrayList<Grades>();
		expected.add(addGrades1);
		ArrayList<Grades> result = testGradebook.getGradebookData();
		assertEquals(expected, result);
	}

	/**
	 * Tests creating Gradebook object, add object to potential points
	 */
	@Test
	public void testCreateGradebook1PotentialPoints() {
		Gradebook testGradebook = new Gradebook();
		Grades addGrades1 = new Grades();
		testGradebook.addToPotentialPoints(addGrades1);
		Grades result = testGradebook.getPotentialPoints();
		assertEquals(addGrades1, result);
	}

}
