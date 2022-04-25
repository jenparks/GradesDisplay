/**
 * 
 */

package edu.westga.cs6312.grades.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.westga.cs6312.grades.model.Grades;

/**
 * Creates GUI for gradebook display
 * 
 * @author Jennifer Parks
 * @version Apr 25, 2022
 *
 */
public class GradesGUI {
	private Grades studentGrades;
	private GradesPane userPane;

	/**
	 * Constructor that gets data read from file & creates PieGraph
	 */
	public GradesGUI() {
		this.studentGrades = new Grades();
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
	 * 
	 * NOTE: this version removes first line which gives full points values
	 */
	private void readData() {
		try {
			Scanner dataFromFile = new Scanner(new File("data.txt"));
			String nextWholeLine = dataFromFile.nextLine();
			while (dataFromFile.hasNextLine()) {
				nextWholeLine = dataFromFile.nextLine();
				Scanner nextInputLine = new Scanner(nextWholeLine);
				nextInputLine.useDelimiter(",");
				String id = nextInputLine.next();
				this.studentGrades.setStudentID(id);
				String firstname = nextInputLine.next();
				this.studentGrades.setFirstName(firstname);
				String lastname = nextInputLine.next();
				this.studentGrades.setLastName(lastname);
				while (nextInputLine.hasNextInt()) {
					int grade = nextInputLine.nextInt();
					this.studentGrades.setGradesLab(grade);
				}
				String gap1 = nextInputLine.next();
				System.out.println(gap1);
				while (nextInputLine.hasNextInt()) {
					int grade = nextInputLine.nextInt();
					this.studentGrades.setGradesProject(grade);
				}
				String gap2 = nextInputLine.next();
				System.out.println(gap2);
				while (nextInputLine.hasNextInt()) {
					int grade = nextInputLine.nextInt();
					this.studentGrades.setGradesProject(grade);
				}
				nextInputLine.close();
			}
		} catch (FileNotFoundException ex) {
			System.out.println("Error with file, try again");
		}
	}

	/**
	 * Helper method - creates & saves GradesPane from data in file
	 */
	private void createGradesPane() {
		try {
			this.userPane = new GradesPane(this.studentGrades);
		} catch (IllegalArgumentException ex) {
			System.out.println("Grades data is empty");
		}
	}

}
