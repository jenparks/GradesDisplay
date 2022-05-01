/**
 * 
 */

package edu.westga.cs6312.grades.view;

import java.io.File;

import edu.westga.cs6312.grades.model.Gradebook;
import edu.westga.cs6312.grades.model.Grades;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
		super.setPrefSize(550, 550);
		super.setVgap(10);
		super.setHgap(35);
		super.setAlignment(Pos.TOP_CENTER);

		this.showMenu();
		if (newGrades != null) {
			this.drawAllGraphParts();
		} else {
			Label noFileSelected = new Label("Please select a file");
			noFileSelected.setFont(new Font(20));
			super.add(noFileSelected, 1, 1);
		}
	}

	private void drawAllGraphParts() {
		this.showAverageLines();
		this.showHeader();
		this.showBarGraph();
		this.showAverageLinesLabels();
		this.showBarGraphLabels();
	}

	private void showMenu() {
		Menu fileMenu = new Menu("_File");
		MenuItem menuFileOpen = new MenuItem("_Open");
		fileMenu.setMnemonicParsing(true);
		menuFileOpen.setMnemonicParsing(true);
		fileMenu.getItems().add(menuFileOpen);

		Menu helpMenu = new Menu("_Help");
		MenuItem menuHelpAbout = new MenuItem("_About");
		helpMenu.setMnemonicParsing(true);
		menuHelpAbout.setMnemonicParsing(true);
		helpMenu.getItems().add(menuHelpAbout);

		MenuBar topMenuBar = new MenuBar();
		topMenuBar.setMinWidth(530);
		topMenuBar.getMenus().add(fileMenu);
		topMenuBar.getMenus().add(helpMenu);
		super.add(topMenuBar, 0, 0, 2, 1);
		menuFileOpen.setOnAction(new OpenFileDialog());
		menuHelpAbout.setOnAction(new OpenAboutPage());
		
		menuFileOpen.setAccelerator(KeyCombination.keyCombination("Ctrl+O"));
		menuHelpAbout.setAccelerator(KeyCombination.keyCombination("Ctrl+A"));
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

		for (int count = 0; count < 11; count++) {
			Rectangle innerLines = new Rectangle();
			innerLines.widthProperty().bind(super.widthProperty().multiply(count * .09));
			innerLines.setHeight(300);
			innerLines.setFill(Color.TRANSPARENT);
			innerLines.setStroke(Color.GRAY);
			super.add(innerLines, 0, 3, 3, 1);
			Label lineNames = new Label(count * 10 + "%");
			lineNames.translateXProperty().bind(super.widthProperty().multiply(count * .09));
			super.add(lineNames, 0, 4, 3, 1);
		}
	}

	private void showBarGraphLabels() {
		Grades currentStudent = this.studentGrades.getGradebookData().get(this.selectedGradesIndex);
		Label labAverageLabel = new Label("Lab Avg: " + String.format("%.01f", currentStudent.getLabAverage() * 100));
		Label projectAverageLabel = new Label(
				"Project Avg: " + String.format("%.01f", currentStudent.getProjectAverage() * 100));
		Label testAverageLabel = new Label(
				"Test Avg: " + String.format("%.01f", currentStudent.getTestAverage() * 100));
		Label straightAverageLabel = new Label(
				"Straight Avg: " + String.format("%.01f", currentStudent.getStraightAverage() * 100));
		Label weightedAverageLabel = new Label(
				"Weighted Avg: " + String.format("%.01f", currentStudent.getWeightedAverage() * 100));
		labAverageLabel.setBackground(new Background(new BackgroundFill(Color.PINK, CornerRadii.EMPTY, Insets.EMPTY)));
		projectAverageLabel
				.setBackground(new Background(new BackgroundFill(Color.GOLD, CornerRadii.EMPTY, Insets.EMPTY)));
		testAverageLabel
				.setBackground(new Background(new BackgroundFill(Color.GREENYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
		straightAverageLabel
				.setBackground(new Background(new BackgroundFill(Color.POWDERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		weightedAverageLabel
				.setBackground(new Background(new BackgroundFill(Color.LAVENDER, CornerRadii.EMPTY, Insets.EMPTY)));

		VBox barLabels = new VBox(43);
		barLabels.setPadding(new Insets(15, 0, 0, 0));
		barLabels.getChildren().addAll(labAverageLabel, projectAverageLabel, testAverageLabel, straightAverageLabel,
				weightedAverageLabel);
		super.add(barLabels, 0, 3);
	}

	private void showBarGraph() {
		Grades currentStudent = this.studentGrades.getGradebookData().get(this.selectedGradesIndex);

		Rectangle labAverage = new Rectangle(0, 50);
		labAverage.widthProperty().bind(super.widthProperty().multiply(currentStudent.getLabAverage()).multiply(.9));
		labAverage.setFill(Color.RED);

		Rectangle projectAverage = new Rectangle(0, 50);
		projectAverage.widthProperty()
				.bind(super.widthProperty().multiply(currentStudent.getProjectAverage()).multiply(.9));
		projectAverage.setFill(Color.ORANGE);

		Rectangle testAverage = new Rectangle(0, 50);
		testAverage.widthProperty().bind(super.widthProperty().multiply(currentStudent.getTestAverage()).multiply(.9));
		testAverage.setFill(Color.GREEN);

		Rectangle straightAverage = new Rectangle(0, 50);
		straightAverage.widthProperty()
				.bind(super.widthProperty().multiply(currentStudent.getStraightAverage()).multiply(.9));
		straightAverage.setFill(Color.BLUE);

		Rectangle weightedAverage = new Rectangle(0, 50);
		weightedAverage.widthProperty()
				.bind(super.widthProperty().multiply(currentStudent.getWeightedAverage()).multiply(.9));
		weightedAverage.setFill(Color.PURPLE);

		VBox barGraph = new VBox(10);
		barGraph.getChildren().addAll(labAverage, projectAverage, testAverage, straightAverage, weightedAverage);
		super.add(barGraph, 0, 3, 3, 1);
	}

	private void showAverageLines() {
		Rectangle classLabAverageLine = new Rectangle(0, 300);
		classLabAverageLine.widthProperty()
				.bind(super.widthProperty().multiply(this.studentGrades.getClassAverageLab()).multiply(.9));
		classLabAverageLine.setFill(Color.TRANSPARENT);
		classLabAverageLine.setStroke(Color.RED);
		super.add(classLabAverageLine, 0, 3, 3, 1);

		Rectangle classProjectAverageLine = new Rectangle(0, 300);
		classProjectAverageLine.widthProperty()
				.bind(super.widthProperty().multiply(this.studentGrades.getClassAverageProject()).multiply(.9));
		classProjectAverageLine.setFill(Color.TRANSPARENT);
		classProjectAverageLine.setStroke(Color.ORANGE);
		super.add(classProjectAverageLine, 0, 3, 3, 1);

		Rectangle classTestAverageLine = new Rectangle(0, 300);
		classTestAverageLine.widthProperty()
				.bind(super.widthProperty().multiply(this.studentGrades.getClassAverageTest()).multiply(.9));
		classTestAverageLine.setFill(Color.TRANSPARENT);
		classTestAverageLine.setStroke(Color.GREEN);
		super.add(classTestAverageLine, 0, 3, 3, 1);

		Rectangle classStraightAverageLine = new Rectangle(0, 300);
		classStraightAverageLine.widthProperty()
				.bind(super.widthProperty().multiply(this.studentGrades.getClassAverageStraight()).multiply(.9));
		classStraightAverageLine.setFill(Color.TRANSPARENT);
		classStraightAverageLine.setStroke(Color.BLUE);
		super.add(classStraightAverageLine, 0, 3, 3, 1);

		Rectangle classWeightedAverageLine = new Rectangle(0, 300);
		classWeightedAverageLine.widthProperty()
				.bind(super.widthProperty().multiply(this.studentGrades.getClassAverageWeighted()).multiply(.9));
		classWeightedAverageLine.setFill(Color.TRANSPARENT);
		classWeightedAverageLine.setStroke(Color.PURPLE);
		super.add(classWeightedAverageLine, 0, 3, 3, 1);
	}

	private void showAverageLinesLabels() {
		Label labAverageLabel = new Label(
				"Class Avg: " + String.format("%.01f", this.studentGrades.getClassAverageLab() * 100));
		Label projectAverageLabel = new Label(
				"Class Project: " + String.format("%.01f", this.studentGrades.getClassAverageProject() * 100));
		Label testAverageLabel = new Label(
				"Class Test: " + String.format("%.01f", this.studentGrades.getClassAverageTest() * 100));
		Label straightAverageLabel = new Label(
				"Class Straight: " + String.format("%.01f", this.studentGrades.getClassAverageStraight() * 100));
		Label weightedAverageLabel = new Label(
				"Class Weighted: " + String.format("%.01f", this.studentGrades.getClassAverageWeighted() * 100));
		labAverageLabel.setBackground(new Background(new BackgroundFill(Color.PINK, CornerRadii.EMPTY, Insets.EMPTY)));
		projectAverageLabel
				.setBackground(new Background(new BackgroundFill(Color.GOLD, CornerRadii.EMPTY, Insets.EMPTY)));
		testAverageLabel
				.setBackground(new Background(new BackgroundFill(Color.GREENYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
		straightAverageLabel
				.setBackground(new Background(new BackgroundFill(Color.POWDERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		weightedAverageLabel
				.setBackground(new Background(new BackgroundFill(Color.LAVENDER, CornerRadii.EMPTY, Insets.EMPTY)));

		VBox lineLabels = new VBox(43);
		lineLabels.setPadding(new Insets(15, 0, 0, 0));
		lineLabels.getChildren().addAll(labAverageLabel, projectAverageLabel, testAverageLabel, straightAverageLabel,
				weightedAverageLabel);
		super.setHalignment(lineLabels, HPos.RIGHT);
		super.add(lineLabels, 2, 3);
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
			GradesPane.this.studentGrades = GradesPane.this.userGUI.getGUIGradebook();
			if (GradesPane.this.userGUI.getStudentAddStatus()) {
				Alert studentAddErrorAlert = new Alert(AlertType.ERROR);
				studentAddErrorAlert.setTitle("Error Adding Student");
				studentAddErrorAlert.setHeaderText("Error Adding One Or More Students");
				studentAddErrorAlert.setContentText("Check your data file and try again");
				studentAddErrorAlert.show();
			}
			GradesPane.super.getChildren().clear();
			GradesPane.this.studentGrades.sortGradebook();
			GradesPane.this.showMenu();
			GradesPane.this.drawAllGraphParts();
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
			GradesPane.this.drawAllGraphParts();
		}
	}

}
