/**
 * 
 */

package edu.westga.cs6312.grades.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.westga.cs6312.grades.model.Gradebook;
import edu.westga.cs6312.grades.model.Grades;

/**
 * Creates GUI for gradebook display
 * 
 * @author Jennifer Parks
 * @version Apr 25, 2022
 *
 */
public class GradesGUI {
	private Gradebook mainGradebook;
	private GradesPane userPane;
	private File userDataFile;

	/**
	 * Constructor that gets data read from file & creates Grades bar graph
	 */
	public GradesGUI() {
		this.mainGradebook = new Gradebook();
		this.userDataFile = new File("data.txt");
		this.readData();
		this.createGradesPane();
	}

	/**
	 * Getter for GradesPane
	 * 
	 * @return GradesPane to be used in creating bar graph display
	 */
	public GradesPane getGradesPane() {
		return this.userPane;
	}

	/**
	 * Helper method - reads in a file
	 */
	private void readData() {
		try {
			Scanner dataFromFile = new Scanner(this.userDataFile);
			String nextWholeLine = dataFromFile.nextLine();
			Grades addGrades = this.readEachUserGrades(nextWholeLine);
			this.mainGradebook.addToPotentialPoints(addGrades);
			do {
				nextWholeLine = dataFromFile.nextLine();
				addGrades = this.readEachUserGrades(nextWholeLine);
				this.mainGradebook.addToGradebook(addGrades);
			} while (dataFromFile.hasNextLine());
			dataFromFile.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Error with file, try again");
		}
	}

	/**
	 * Helper method - reads each line and returns a Grades object
	 * 
	 * @param nextWholeLine Next line to be parsed into Grades
	 * @return Grades object with grades added
	 */
	private Grades readEachUserGrades(String nextWholeLine) {
		Grades dataEntryGrades = new Grades();

		try {
			Scanner nextInputLine = new Scanner(nextWholeLine);
			nextInputLine.useDelimiter(",");

			String id = nextInputLine.next();
			dataEntryGrades.setStudentID(id);
			String firstname = nextInputLine.next();
			dataEntryGrades.setFirstName(firstname);
			String lastname = nextInputLine.next();
			dataEntryGrades.setLastName(lastname);
			while (nextInputLine.hasNextInt()) {
				int grade = nextInputLine.nextInt();
				dataEntryGrades.setGradesLab(grade);
			}
			nextInputLine.next();
			while (nextInputLine.hasNextInt()) {
				int grade = nextInputLine.nextInt();
				dataEntryGrades.setGradesProject(grade);
			}
			nextInputLine.next();
			while (nextInputLine.hasNextInt()) {
				int grade = nextInputLine.nextInt();
				dataEntryGrades.setGradesTest(grade);
			}
			nextInputLine.close();
		} catch (NoSuchElementException ex) {
			System.out.println("The file is not formatted correctly");
		}
		return dataEntryGrades;
	}

	/**
	 * Helper method - creates & saves GradesPane from data in file
	 */
	private void createGradesPane() {
		try {
			this.userPane = new GradesPane(this.mainGradebook);
		} catch (IllegalArgumentException ex) {
			System.out.println("Grades data is empty");
		}
	}
	
}
