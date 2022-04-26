/**
 * 
 */

package edu.westga.cs6312.grades.model;

import java.util.ArrayList;

/**
 * Models a collection of multiple students' grades
 * 
 * @author Jennifer Parks
 * @version Apr 25, 2022
 *
 */
public class Gradebook {
	private ArrayList<Grades> studentGradebook;
	private Grades potentialPoints;

	/**
	 * 0-parameter constructor, initializes object
	 */
	public Gradebook() {
		this.studentGradebook = new ArrayList<Grades>();
		this.potentialPoints = new Grades();
	}

	/**
	 * Sets a Grades object as the maximum value of potential points for all graded
	 * elements
	 * 
	 * @param newGrades Grades object to set as maximum potential points
	 * @precondition Grades cannot be null
	 */
	public void addToPotentialPoints(Grades newGrades) {
		if (newGrades == null) {
			throw new IllegalArgumentException("Cannot add null grades");
		}
		this.potentialPoints = newGrades;
	}

	/**
	 * Gets Grades object of maximum potential points
	 * 
	 * @return Grades collection of maximum potential points
	 */
	public Grades getPotentialPoints() {
		return this.potentialPoints;
	}

	/**
	 * Adds a new Grades object to the student ArrayList (represents one student's
	 * scores)
	 * 
	 * @param newGrades Grades object to add to ArrayList
	 * @precondition Grades cannot be null
	 */
	public void addToGradebook(Grades newGrades) {
		if (newGrades == null) {
			throw new IllegalArgumentException("Cannot add null grades");
		}
		this.studentGradebook.add(newGrades);
	}

	/**
	 * Gets collection of Grades
	 * 
	 * @return ArrayList of Grades objects
	 */
	public ArrayList<Grades> getGradebookData() {
		return this.studentGradebook;
	}

	/**
	 * Calculates average lab grades for each student in Gradebook
	 * 
	 * @return ArrayList of all average lab grades (by student)
	 */
	public ArrayList<Double> getAverageGradesLab() {
		ArrayList<Double> labAverages = new ArrayList<Double>();
		for (Grades element : this.studentGradebook) {
			double average = ((double) element.sumGradesLab() / this.potentialPoints.sumGradesLab()) * 100;
			labAverages.add(average);
		}
		return labAverages;
	}

	/**
	 * Calculates average project grades for each student in Gradebook
	 * 
	 * @return ArrayList of all average project grades (by student)
	 */
	public ArrayList<Double> getAverageGradesProject() {
		ArrayList<Double> projectAverages = new ArrayList<Double>();
		for (Grades element : this.studentGradebook) {
			double average = ((double) element.sumGradesProject() / this.potentialPoints.sumGradesProject()) * 100;
			projectAverages.add(average);
		}
		return projectAverages;
	}

	/**
	 * Calculates average test grades for each student in Gradebook
	 * 
	 * @return ArrayList of all average test grades (by student)
	 */
	public ArrayList<Double> getAverageGradesTest() {
		ArrayList<Double> testAverages = new ArrayList<Double>();
		for (Grades element : this.studentGradebook) {
			double average = ((double) element.sumGradesTest() / this.potentialPoints.sumGradesTest()) * 100;
			testAverages.add(average);
		}
		return testAverages;
	}

	/**
	 * Calculates overall grade for each student in Gradebook - uses straight
	 * average
	 * 
	 * @return ArrayList of all overall average grades (by student)
	 */
	public ArrayList<Double> getAverageOverallStraight() {
		ArrayList<Double> finalAverages = new ArrayList<Double>();
		for (Grades element : this.studentGradebook) {
			int sumStudentGrades = element.sumGradesLab() + element.sumGradesProject() + element.sumGradesTest();
			int sumPotentialPoints = this.potentialPoints.sumGradesLab() + this.potentialPoints.sumGradesProject()
					+ this.potentialPoints.sumGradesTest();
			double average = ((double) sumStudentGrades / sumPotentialPoints) * 100;
			finalAverages.add(average);
		}
		return finalAverages;
	}
}
