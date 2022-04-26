/**
 * 
 */

package edu.westga.cs6312.grades.view;

import java.io.File;
import java.io.FileNotFoundException;
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

	/**
	 * Constructor that gets data read from file & creates PieGraph
	 */
	public GradesGUI() {
		this.mainGradebook = new Gradebook();
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
		try {
			Scanner dataFromFile = new Scanner(new File("data.txt"));
			String nextWholeLine = dataFromFile.nextLine();
			Grades addGrades = this.readEachUserGrades(nextWholeLine);
			this.mainGradebook.addToPotentialPoints(addGrades);
			do {
				nextWholeLine = dataFromFile.nextLine();
				addGrades = this.readEachUserGrades(nextWholeLine);
				this.mainGradebook.addToGradebook(addGrades);
			} while (dataFromFile.hasNextLine());
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
