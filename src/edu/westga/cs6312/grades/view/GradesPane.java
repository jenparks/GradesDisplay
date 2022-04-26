/**
 * 
 */

package edu.westga.cs6312.grades.view;

import edu.westga.cs6312.grades.model.Grades;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * Subclass of Pane. Draws grades display.
 * 
 * @author Jennifer Parks
 * @version Apr 25, 2022
 *
 */
public class GradesPane extends GridPane {
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
		this.showGrades();
	}

	/**
	 * Shows a basic grades display for one student
	 */
	public void showGrades() {
		Label studentName = new Label(this.studentGrades.getFirstName() + " " + this.studentGrades.getLastName());
		Label labAverage = new Label(this.studentGrades.sumGradesLab() + "");
		Label projectAverage = new Label(this.studentGrades.sumGradesProject() + "");
		Label testAverage = new Label(this.studentGrades.sumGradesTest() + "");
		int total = this.studentGrades.sumGradesLab() + this.studentGrades.sumGradesProject() + this.studentGrades.sumGradesTest();
		Label totalAverage = new Label(total + "");
		super.add(studentName, 0, 0);
		super.add(labAverage, 0, 1);
		super.add(projectAverage, 0, 2);
		super.add(testAverage, 0, 3);
		super.add(totalAverage, 0, 4);
	}
}
