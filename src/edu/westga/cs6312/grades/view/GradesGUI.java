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
	private boolean studentAddError;

	/**
	 * Constructor that gets data read from file & creates Grades bar graph
	 */
	public GradesGUI() {
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
	 * Getter for Gradebook from the GradesGUI
	 * 
	 * @return Gradebook from the GradesGUI
	 */
	public Gradebook getGUIGradebook() {
		return this.mainGradebook;
	}

	/**
	 * Reads in a new file & added to Gradebook object
	 * 
	 * @param dataFile File to be read
	 */
	public void readData(File dataFile) {
		try {
			this.mainGradebook = new Gradebook();
			this.studentAddError = false;
			Scanner dataFromFile = new Scanner(dataFile);
			String nextWholeLine = dataFromFile.nextLine();
			Grades addGrades = this.readEachUserGrades(nextWholeLine);
			this.mainGradebook.addToPotentialPoints(addGrades);
			do {
				nextWholeLine = dataFromFile.nextLine();
				addGrades = this.readEachUserGrades(nextWholeLine);
				try {
					this.mainGradebook.addToGradebook(addGrades);
				} catch (IllegalArgumentException ex) {
					this.studentAddError = true;
				}
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
	public void createGradesPane() {
		try {
			this.userPane = new GradesPane(this.mainGradebook, this);
		} catch (IllegalArgumentException ex) {
			System.out.println("Grades data is empty");
		}
	}

	/**
	 * Returns true if there was an error adding one or more students to the
	 * gradebook
	 * 
	 * @return True if error adding students to gradebook
	 */
	public boolean getStudentAddStatus() {
		return this.studentAddError;
	}

}
