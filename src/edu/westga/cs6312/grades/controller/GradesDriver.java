/**
 * 
 */

package edu.westga.cs6312.grades.controller;

import edu.westga.cs6312.grades.view.GradesGUI;
import edu.westga.cs6312.grades.view.GradesPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This is the driver for the application
 * 
 * @author Jennifer Parks
 * @version Apr 25, 2022
 *
 */
public class GradesDriver extends Application {

	/**
	 * Entry point into the application
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}

	/**
	 * Starts the GUI by building the Stage and showing it
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		GradesGUI userGUI = new GradesGUI();

		primaryStage.setTitle("Jennifer Parks - Gradebook Project");
		GradesPane thePane = userGUI.getGradesPane();
		if (thePane == null) {
			System.out.println("Error in creating Pane, possibly due to incorrect file reading");
		} else {
			Scene theScene = new Scene(thePane);
			primaryStage.setScene(theScene);
			primaryStage.show();
		}
	}

}
