/**
 * 
 */

package edu.westga.cs6312.grades.view;

import edu.westga.cs6312.grades.model.Grades;
import javafx.scene.layout.Pane;

/**
 * Subclass of Pane. Draws grades display.
 * 
 * @author Jennifer Parks
 * @version Apr 25, 2022
 *
 */
public class GradesPane extends Pane {
	private Grades studentGrades;
	
	/**
	 * 1-parameter constructor, creates object
	 * 
	 * @param newGrades Grades object to be used to draw pie graph
	 * @precondition Grades cannot be null
	 */
	public GradesPane(Grades newGrades) {
		if (newGrades == null) {
			throw new IllegalArgumentException("Cannot create pie graph from null data set");
		}
		super.setPrefSize(450, 450);
		this.studentGrades = newGrades;
	}

}
