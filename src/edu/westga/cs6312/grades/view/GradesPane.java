/**
 * 
 */

package edu.westga.cs6312.grades.view;

import edu.westga.cs6312.grades.model.Gradebook;
import edu.westga.cs6312.grades.model.Grades;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
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
	private ComboBox<String> textCombo;

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
		super.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		super.setPrefSize(550, 550);
		super.setVgap(10);
		super.setHgap(35);
		super.setAlignment(Pos.CENTER);

		this.showMenu();
		this.showBarGraph();

	}

	private void showMenu() {
		Grades thisGrades = this.studentGrades.getGradebookData().get(0);

		Menu fileMenu = new Menu("_File");
		MenuItem menuFileOpen = new MenuItem("_Open");
		fileMenu.getItems().add(menuFileOpen);

		Menu helpMenu = new Menu("_Help");
		MenuItem menuHelpAbout = new MenuItem("_About");
		helpMenu.getItems().add(menuHelpAbout);

		MenuBar topMenuBar = new MenuBar();
		topMenuBar.getMenus().add(fileMenu);
		topMenuBar.getMenus().add(helpMenu);

		super.add(topMenuBar, 0, 0, 2, 1);

		this.textCombo = new ComboBox<>();
		for (Grades element : this.studentGrades.getGradebookData()) {
			String name = element.getFirstName() + " " + element.getLastName();
			this.textCombo.getItems().add(name);
		}
		this.textCombo.setValue("Pick a name:");
		super.add(this.textCombo, 0, 1);

		Label studentName = new Label(thisGrades.getFirstName() + " " + thisGrades.getLastName());
		studentName.setFont(Font.font(20));
		super.setHalignment(studentName, HPos.CENTER);
		super.add(studentName, 0, 2);

		this.textCombo.setOnAction(new ChangeStudent());
	}

	private void showBarGraph() {
		Rectangle outsideSquare = new Rectangle(400, 450);
		outsideSquare.widthProperty().bind(super.widthProperty().multiply(.90));
		outsideSquare.setFill(Color.TRANSPARENT);
		outsideSquare.setStroke(Color.BLACK);

		Label labAverageLabel = new Label("Lab Average: " + this.studentGrades.getAverageGradesLab().get(0));
		Rectangle labAverage = new Rectangle(0, 50);
		labAverage.widthProperty().bind(
				super.widthProperty().multiply(this.studentGrades.getAverageGradesLab().get(0) / 100).multiply(.9));
		labAverage.setFill(Color.RED);

		Label projectAverageLabel = new Label(
				"Project Average: " + this.studentGrades.getAverageGradesProject().get(0));
		Rectangle projectAverage = new Rectangle(0, 50);
		projectAverage.widthProperty().bind(
				super.widthProperty().multiply(this.studentGrades.getAverageGradesProject().get(0) / 100).multiply(.9));
		projectAverage.setFill(Color.ORANGE);

		Label testAverageLabel = new Label("Test Average: " + this.studentGrades.getAverageGradesTest().get(0));
		Rectangle testAverage = new Rectangle(0, 50);
		testAverage.widthProperty().bind(
				super.widthProperty().multiply(this.studentGrades.getAverageGradesTest().get(0) / 100).multiply(.9));
		testAverage.setFill(Color.GREEN);

		Label straightAverageLabel = new Label(
				"Straight Average: " + this.studentGrades.getAverageOverallStraight().get(0));
		Rectangle straightAverage = new Rectangle(0, 50);
		straightAverage.widthProperty().bind(super.widthProperty()
				.multiply(this.studentGrades.getAverageOverallStraight().get(0) / 100).multiply(.9));
		straightAverage.setFill(Color.BLUE);

		Label weightedAverageLabel = new Label(
				"Weighted Average: " + this.studentGrades.getAverageOverallWeighted().get(0));
		Rectangle weightedAverage = new Rectangle(0, 50);
		weightedAverage.widthProperty().bind(super.widthProperty()
				.multiply(this.studentGrades.getAverageOverallWeighted().get(0) / 100).multiply(.9));
		weightedAverage.setFill(Color.PURPLE);

		VBox barGraph = new VBox(10);
		barGraph.getChildren().addAll(labAverageLabel, labAverage, projectAverageLabel, projectAverage,
				testAverageLabel, testAverage, straightAverageLabel, straightAverage, weightedAverageLabel,
				weightedAverage);

		super.add(outsideSquare, 0, 3);
		super.add(barGraph, 0, 3);
	}

	private class ChangeStudent implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			String menuResult = GradesPane.this.textCombo.getValue();
			int indexFromArray = GradesPane.this.textCombo.getItems().indexOf(menuResult);
		}
	}

}
