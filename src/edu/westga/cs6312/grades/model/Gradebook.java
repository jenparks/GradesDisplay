/**
 * 
 */

package edu.westga.cs6312.grades.model;

import java.util.ArrayList;
import java.util.Collections;

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
	 * @param newTotalGrades Grades object to set as maximum potential points
	 * @precondition Grades cannot be null
	 */
	public void addToPotentialPoints(Grades newTotalGrades) {
		if (newTotalGrades == null) {
			throw new IllegalArgumentException("Cannot add null grades");
		}
		this.potentialPoints = newTotalGrades;
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
	 * Adds total potential points to Grade object & adds to the student ArrayList
	 * (represents one student's scores)
	 * 
	 * @param newGrades Grades object to add to ArrayList
	 * @precondition Grades cannot be null
	 * @precondition Number of graded items for student must be the same for the
	 *               total points, for a given category
	 */
	public void addToGradebook(Grades newGrades) {
		if (newGrades == null) {
			throw new IllegalArgumentException("Cannot add null grades");
		}
		if (newGrades.getGradesLab().size() != this.potentialPoints.getGradesLab().size()
				|| newGrades.getGradesProject().size() != this.potentialPoints.getGradesProject().size()
				|| newGrades.getGradesTest().size() != this.potentialPoints.getGradesTest().size()) {
			throw new IllegalArgumentException(
					"Number of graded items for Student is different than for Total Points - Student not added");
		} else {
			newGrades.setTotalPoints(this.potentialPoints);
			this.studentGradebook.add(newGrades);
		}
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
	 * Calculates & returns the class average for labs, as a decimal
	 * 
	 * @return Class average for labs
	 */
	public double getClassAverageLab() {
		double total = 0;
		for (Grades element : this.studentGradebook) {
			total += element.getLabAverage();
		}
		double average = total / this.studentGradebook.size();
		return average;
	}

	/**
	 * Calculates & returns the class average for projects, as a decimal
	 * 
	 * @return Class average for projects
	 */
	public double getClassAverageProject() {
		double total = 0;
		for (Grades element : this.studentGradebook) {
			total += element.getProjectAverage();
		}
		double average = total / this.studentGradebook.size();
		return average;
	}

	/**
	 * Calculates & returns the class average for tests, as a decimal
	 * 
	 * @return Class average for tests
	 */
	public double getClassAverageTest() {
		double total = 0;
		for (Grades element : this.studentGradebook) {
			total += element.getTestAverage();
		}
		double average = total / this.studentGradebook.size();
		return average;
	}

	/**
	 * Calculates & returns the class average for straight averages, as a decimal
	 * 
	 * @return Class average for straight averages
	 */
	public double getClassAverageStraight() {
		double total = 0;
		for (Grades element : this.studentGradebook) {
			total += element.getStraightAverage();
		}
		double average = total / this.studentGradebook.size();
		return average;
	}

	/**
	 * Calculates & returns the class average for weighted averages, as a decimal
	 * 
	 * @return Class average for weighted averages
	 */
	public double getClassAverageWeighted() {
		double total = 0;
		for (Grades element : this.studentGradebook) {
			total += element.getWeightedAverage();
		}
		double average = total / this.studentGradebook.size();
		return average;
	}

	/**
	 * Sorts Grades (students) in the Gradebook, by last then first name
	 */
	public void sortGradebook() {
		Collections.sort(this.studentGradebook);
	}

}
