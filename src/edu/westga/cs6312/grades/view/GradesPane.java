/**
 * 
 */

package edu.westga.cs6312.grades.view;

import edu.westga.cs6312.grades.model.Gradebook;
import edu.westga.cs6312.grades.model.Grades;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

/**
 * Subclass of GridPane. Draws grades display.
 * 
 * @author Jennifer Parks
 * @version Apr 25, 2022
 *
 */
public class GradesPane extends GridPane {
	private Gradebook studentGrades;

	/**
	 * 1-parameter constructor, creates object
	 * 
	 * @param newGrades Grades object to be used to draw pie graph
	 * @precondition Grades cannot be null
	 */
	public GradesPane(Gradebook newGrades) {
		if (newGrades == null) {
			throw new IllegalArgumentException("Cannot create pie graph from null data set");
		}
		this.studentGrades = newGrades;
		super.setPrefSize(550, 550);
		super.setVgap(10);
		super.setHgap(35);
		super.setBackground(new Background(new BackgroundFill(Color.MINTCREAM, CornerRadii.EMPTY, Insets.EMPTY)));
		this.showMenu();
		this.showBarGraph();

	}

	/**
	 * Shows a basic grades display for one student
	 */
	private void showGrades() {
		Grades thisGrades = this.studentGrades.getGradebookData().get(0);

		this.studentGrades.getAverageGradesLab().get(0);
		Label studentName = new Label(thisGrades.getFirstName() + " " + thisGrades.getLastName());
		Label labAverage = new Label(this.studentGrades.getAverageGradesLab().get(0) + "");
		Label projectAverage = new Label(this.studentGrades.getAverageGradesProject().get(0) + "");
		Label testAverage = new Label(this.studentGrades.getAverageGradesTest().get(0) + "");
		Label totalAverage = new Label(this.studentGrades.getAverageOverallStraight().get(0) + "");
		Label weightedAverage = new Label(this.studentGrades.getAverageOverallWeighted().get(0) + "");
		super.add(studentName, 0, 0);
		super.add(labAverage, 0, 1);
		super.add(projectAverage, 0, 2);
		super.add(testAverage, 0, 3);
		super.add(totalAverage, 0, 4);
		super.add(weightedAverage, 0, 5);
	}

	private void showMenu() {
		Menu fileMenu = new Menu("_File");
		MenuItem menuFileOpen = new MenuItem("_Open");
		fileMenu.getItems().add(menuFileOpen);

		Menu helpMenu = new Menu("_Help");
		MenuItem menuHelpAbout = new MenuItem("_About");
		helpMenu.getItems().add(menuHelpAbout);

		MenuBar topMenuBar = new MenuBar();
		topMenuBar.getMenus().add(fileMenu);
		topMenuBar.getMenus().add(helpMenu);

		super.add(topMenuBar, 0, 0);
	}

	private void showBarGraph() {
		Grades thisGrades = this.studentGrades.getGradebookData().get(0);
		Label studentName = new Label(thisGrades.getFirstName() + " " + thisGrades.getLastName());
		studentName.setFont(Font.font(20));
		super.setHalignment(studentName, HPos.CENTER);

		Rectangle outsideSquare = new Rectangle(400, 400);
		outsideSquare.setFill(Color.TRANSPARENT);
		outsideSquare.setStroke(Color.BLACK);

		Rectangle labAverage = new Rectangle(400, 50);
		labAverage.setFill(Color.RED);
		Rectangle projectAverage = new Rectangle(400, 50);
		projectAverage.setFill(Color.ORANGE);
		Rectangle testAverage = new Rectangle(400, 50);
		testAverage.setFill(Color.GREEN);
		Rectangle straightAverage = new Rectangle(400, 50);
		straightAverage.setFill(Color.BLUE);
		Rectangle weightedAverage = new Rectangle(400, 50);
		weightedAverage.setFill(Color.PURPLE);

		super.add(studentName, 0, 2, 1, 2);
		super.add(outsideSquare, 0, 3, 1, 6);
		super.add(labAverage, 0, 3);
		super.add(projectAverage, 0, 4);
		super.add(testAverage, 0, 5);
		super.add(straightAverage, 0, 6);
		super.add(weightedAverage, 0, 7);
	}
}
