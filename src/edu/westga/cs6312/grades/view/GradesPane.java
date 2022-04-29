/**
 * 
 */

package edu.westga.cs6312.grades.view;

import java.io.File;

import edu.westga.cs6312.grades.model.Gradebook;
import edu.westga.cs6312.grades.model.Grades;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * Subclass of GridPane. Draws grades display.
 * 
 * @author Jennifer Parks
 * @version Apr 25, 2022
 *
 */
public class GradesPane extends GridPane {
	private Gradebook studentGrades;
	private GradesGUI userGUI;
	private ComboBox<String> textCombo;
	private int selectedGradesIndex;
	private File userDataFile;

	/**
	 * 2-parameter constructor, creates object
	 * 
	 * @param newGrades Grades object to be used to draw graph
	 * @param theGUI    The GradesGUI
	 * @precondition Grades cannot be null
	 */
	public GradesPane(Gradebook newGrades, GradesGUI theGUI) {
		if (theGUI == null) {
			throw new IllegalArgumentException("Cannot create graph from null data set");
		}
		this.studentGrades = newGrades;
		this.selectedGradesIndex = 0;
		this.userGUI = theGUI;
		super.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		super.setPrefSize(550, 600);
		super.setVgap(10);
		super.setHgap(35);
		super.setAlignment(Pos.TOP_CENTER);

		this.showMenu();
		if (!(newGrades == null)) {
			this.showHeader();
			this.showBarGraph();
		} else {
			Label noFileSelected = new Label("Please select a file");
			super.add(noFileSelected, 1, 1);
		}
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
		super.add(topMenuBar, 0, 0, 2, 1);
		menuFileOpen.setOnAction(new OpenFileDialog());
		menuHelpAbout.setOnAction(new OpenAboutPage());
	}

	private void showHeader() {
		Grades thisGrades = this.studentGrades.getGradebookData().get(this.selectedGradesIndex);

		this.textCombo = new ComboBox<>();
		for (Grades element : this.studentGrades.getGradebookData()) {
			this.textCombo.getItems().add(element.getFirstName() + " " + element.getLastName());
		}
		this.textCombo.setValue("Pick a name:");
		super.add(this.textCombo, 0, 1);
		this.textCombo.setOnAction(new ChangeStudent());

		Label studentName = new Label(thisGrades.getFirstName() + " " + thisGrades.getLastName());
		studentName.setFont(Font.font(20));
		super.add(studentName, 1, 1);

		Rectangle outsideSquare = new Rectangle();
		outsideSquare.widthProperty().bind(super.widthProperty().multiply(.9));
		outsideSquare.setHeight(450);
		outsideSquare.setFill(Color.TRANSPARENT);
		outsideSquare.setStroke(Color.BLACK);
		super.add(outsideSquare, 0, 3, 2, 1);

	}

	private void showBarGraph() {
		Grades currentStudent = this.studentGrades.getGradebookData().get(this.selectedGradesIndex);

		Label labAverageLabel = new Label("Lab Average: " + currentStudent.getLabAverage());
		Rectangle labAverage = new Rectangle(0, 50);
		labAverage.widthProperty().bind(super.widthProperty().multiply(currentStudent.getLabAverage()).multiply(.9));
		labAverage.setFill(Color.RED);

		Label projectAverageLabel = new Label("Project Average: " + currentStudent.getProjectAverage());
		Rectangle projectAverage = new Rectangle(0, 50);
		projectAverage.widthProperty()
				.bind(super.widthProperty().multiply(currentStudent.getProjectAverage()).multiply(.9));
		projectAverage.setFill(Color.ORANGE);

		Label testAverageLabel = new Label("Test Average: " + currentStudent.getTestAverage());
		Rectangle testAverage = new Rectangle(0, 50);
		testAverage.widthProperty().bind(super.widthProperty().multiply(currentStudent.getTestAverage()).multiply(.9));
		testAverage.setFill(Color.GREEN);

		Label straightAverageLabel = new Label("Straight Average: " + currentStudent.getStraightAverage());
		Rectangle straightAverage = new Rectangle(0, 50);
		straightAverage.widthProperty()
				.bind(super.widthProperty().multiply(currentStudent.getStraightAverage()).multiply(.9));
		straightAverage.setFill(Color.BLUE);

		Label weightedAverageLabel = new Label("Weighted Average: " + currentStudent.getWeightedAverage());
		Rectangle weightedAverage = new Rectangle(0, 50);
		weightedAverage.widthProperty()
				.bind(super.widthProperty().multiply(currentStudent.getWeightedAverage()).multiply(.9));
		weightedAverage.setFill(Color.PURPLE);

		VBox barGraph = new VBox(10);
		barGraph.getChildren().addAll(labAverageLabel, labAverage, projectAverageLabel, projectAverage,
				testAverageLabel, testAverage, straightAverageLabel, straightAverage, weightedAverageLabel,
				weightedAverage);

		super.add(barGraph, 0, 3, 2, 1);
	}

	/**
	 * Gets the user-selected File
	 * 
	 * @return File selected by user
	 */
	public File getDataFile() {
		return this.userDataFile;
	}

	private class OpenFileDialog implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Open New File");
			GradesPane.this.userDataFile = fileChooser.showOpenDialog(new Stage());
			GradesPane.this.userGUI.readData(GradesPane.this.userDataFile);
			GradesPane.this.studentGrades = GradesPane.this.userGUI.mainGradebook;
			GradesPane.super.getChildren().clear();
			GradesPane.this.showMenu();
			GradesPane.this.showHeader();
			GradesPane.this.showBarGraph();

		}
	}

	private class OpenAboutPage implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			Stage aboutStage = new Stage();
			GridPane aboutPane = new GridPane();
			aboutPane
					.setBackground(new Background(new BackgroundFill(Color.LAVENDER, CornerRadii.EMPTY, Insets.EMPTY)));
			aboutPane.setPrefSize(300, 300);
			aboutPane.setAlignment(Pos.CENTER);
			Label myName = new Label("Made by Jennifer Parks\nWith my rubber duck crew");
			aboutPane.add(myName, 0, 0);
			Scene theScene = new Scene(aboutPane);
			aboutStage.setScene(theScene);
			aboutStage.show();
		}
	}

	private class ChangeStudent implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			String menuResult = GradesPane.this.textCombo.getValue();
			GradesPane.this.selectedGradesIndex = GradesPane.this.textCombo.getItems().indexOf(menuResult);
			GradesPane.super.getChildren().clear();
			GradesPane.this.showMenu();
			GradesPane.this.showHeader();
			GradesPane.this.showBarGraph();
		}
	}

}
