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

	/**
	 * Tests creating Gradebook object, calculate average lab grades
	 */
	@Test
	public void testCreateGradebookGetAverageLab() {
		Gradebook testGradebook = new Gradebook();
		
		Grades addGradesPotential = new Grades();
		addGradesPotential.setGradesLab(100);
		addGradesPotential.setGradesLab(100);
		testGradebook.addToPotentialPoints(addGradesPotential);
		Grades addGradesStudent = new Grades();
		addGradesStudent.setGradesLab(90);
		addGradesStudent.setGradesLab(80);
		testGradebook.addToGradebook(addGradesStudent);
		
		ArrayList<Double> result = testGradebook.getAverageGradesLab();
		ArrayList<Double> expected = new ArrayList<Double>();
		expected.add(85.0);
		assertEquals(expected, result);
	}

	/**
	 * Tests creating Gradebook object, calculate average project grades
	 */
	@Test
	public void testCreateGradebookGetAverageProject() {
		Gradebook testGradebook = new Gradebook();
		
		Grades addGradesPotential = new Grades();
		addGradesPotential.setGradesProject(100);
		addGradesPotential.setGradesProject(100);
		testGradebook.addToPotentialPoints(addGradesPotential);
		Grades addGradesStudent = new Grades();
		addGradesStudent.setGradesProject(70);
		addGradesStudent.setGradesProject(90);
		testGradebook.addToGradebook(addGradesStudent);
		
		ArrayList<Double> result = testGradebook.getAverageGradesProject();
		ArrayList<Double> expected = new ArrayList<Double>();
		expected.add(80.0);
		assertEquals(expected, result);
	}

	/**
	 * Tests creating Gradebook object, calculate average test grades
	 */
	@Test
	public void testCreateGradebookGetAverageTest() {
		Gradebook testGradebook = new Gradebook();
		
		Grades addGradesPotential = new Grades();
		addGradesPotential.setGradesTest(100);
		addGradesPotential.setGradesTest(100);
		testGradebook.addToPotentialPoints(addGradesPotential);
		Grades addGradesStudent = new Grades();
		addGradesStudent.setGradesTest(50);
		addGradesStudent.setGradesTest(90);
		testGradebook.addToGradebook(addGradesStudent);
		
		ArrayList<Double> result = testGradebook.getAverageGradesTest();
		ArrayList<Double> expected = new ArrayList<Double>();
		expected.add(70.0);
		assertEquals(expected, result);
	}

}
