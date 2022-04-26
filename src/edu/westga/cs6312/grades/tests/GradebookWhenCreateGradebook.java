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
 * Creates JUnit test cases for Grades class
 * 
 * @author Jennifer Parks
 * @version Apr 26, 2022
 *
 */
public class GradebookWhenCreateGradebook {

	/**
	 * Tests creating Gradebook object
	 */
	@Test
	public void testCreateGradebook() {
		Gradebook testGradebook = new Gradebook();
		Grades addGrades1 = new Grades();
		testGradebook.addToGradebook(addGrades1);
		ArrayList<Grades> expected = new ArrayList<Grades>();
		expected.add(addGrades1);
		ArrayList<Grades> result = testGradebook.getGradebookData();
		assertEquals(expected, result);
	}

}
