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

	/**
	 * 0-parameter constructor, initializes object
	 */
	public Gradebook() {
		this.studentGradebook = new ArrayList<Grades>();
	}

	/**
	 * Adds a new Grades object to the ArrayList
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
}
