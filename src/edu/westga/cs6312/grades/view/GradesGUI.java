/**
 * 
 */

package edu.westga.cs6312.grades.view;

import edu.westga.cs6312.grades.model.Grades;

/**
 * Creates GUI for gradebook display
 * 
 * @author Jennifer Parks
 * @version Apr 25, 2022
 *
 */
public class GradesGUI {
	private Grades studentGrades;
	private GradesPane userPane;

	/**
	 * Constructor that gets data read from file & creates PieGraph
	 */
	public GradesGUI() {
		this.readData();
		this.createGradesPane();
	}

	/**
	 * Getter for GradesPane
	 * 
	 * @return GradesPane to be used in creating pie graph display
	 */
	public GradesPane getPieGraphPane() {
		return this.userPane;
	}

	/**
	 * Helper method - reads in a file
	 */
	private void readData() {

	}

	/**
	 * Helper method - creates & saves GradesPane from data in file
	 */
	private void createGradesPane() {
		try {
			this.userPane = new GradesPane(this.studentGrades);
		} catch (IllegalArgumentException ex) {
			System.out.println("Grades data is empty");
		}
	}

}
