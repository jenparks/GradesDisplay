/**
 * 
 */

package edu.westga.cs6312.grades.model;

import java.util.ArrayList;

/**
 * Models a collection of one student's grades
 * 
 * @author Jennifer Parks
 * @version Apr 25, 2022
 *
 */
public class Grades {
	private String studentID;
	private String firstName;
	private String lastName;
	private ArrayList<Integer> gradesLab;
	private ArrayList<Integer> gradesProject;
	private ArrayList<Integer> gradesTest;

	/**
	 * 0-parameter constructor, initializes variables
	 */
	public Grades() {
		this.studentID = "";
		this.firstName = "";
		this.lastName = "";
		this.gradesLab = new ArrayList<Integer>();
		this.gradesProject = new ArrayList<Integer>();
		this.gradesTest = new ArrayList<Integer>();
	}

	/**
	 * Sets student ID
	 * 
	 * @param idNumber New student ID number
	 * @precondition Can't be null or empty
	 */
	public void setStudentID(String idNumber) {
		if (idNumber == null || idNumber.equals("")) {
			throw new IllegalArgumentException("Student ID can't be null or empty");
		}
		this.studentID = idNumber;
	}

	/**
	 * Gets student ID
	 * 
	 * @return String of student ID number
	 */
	public String getStudentID() {
		return this.studentID;
	}

	/**
	 * Sets student first name
	 * 
	 * @param name Student's first name
	 * @precondition Can't be null or empty
	 */
	public void setFirstName(String name) {
		if (name == null || name.equals("")) {
			throw new IllegalArgumentException("First name can't be null or empty");
		}
		this.firstName = name;
	}

	/**
	 * Gets student's first name
	 * 
	 * @return String of student's first name
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * Sets student last name
	 * 
	 * @param name Student's last name
	 * @precondition Can't be null or empty
	 */
	public void setLastName(String name) {
		if (name == null || name.equals("")) {
			throw new IllegalArgumentException("Last name can't be null or empty");
		}
		this.lastName = name;
	}

	/**
	 * Gets student's last name
	 * 
	 * @return String of student's last name
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * Adds a new grade to the lab arraylist
	 * 
	 * @param newGrade Grade to be added to lab arraylist
	 * @precondition Grade added must be <= 100 & >= 0
	 */
	public void setGradesLab(int newGrade) {
		if (newGrade < 0 || newGrade > 100) {
			throw new IllegalArgumentException("Added grade must be between 0 and 100");
		}
		this.gradesLab.add(newGrade);
	}

	/**
	 * Gets student's lab grades
	 * 
	 * @return ArrayList of student's lab grades
	 */
	public ArrayList<Integer> getGradesLab() {
		return this.gradesLab;
	}

	/**
	 * Adds a new grade to the project arraylist
	 * 
	 * @param newGrade Grade to be added to project arraylist
	 * @precondition Grade added must be <= 100 & >= 0
	 */
	public void setGradesProject(int newGrade) {
		if (newGrade < 0 || newGrade > 100) {
			throw new IllegalArgumentException("Added grade must be between 0 and 100");
		}
		this.gradesProject.add(newGrade);
	}

	/**
	 * Gets student's project grades
	 * 
	 * @return ArrayList of student's project grades
	 */
	public ArrayList<Integer> getGradesProject() {
		return this.gradesProject;
	}

	/**
	 * Adds a new grade to the test arraylist
	 * 
	 * @param newGrade Grade to be added to test arraylist
	 * @precondition Grade added must be <= 100 & >= 0
	 */
	public void setGradesTest(int newGrade) {
		if (newGrade < 0 || newGrade > 100) {
			throw new IllegalArgumentException("Added grade must be between 0 and 100");
		}
		this.gradesTest.add(newGrade);
	}

	/**
	 * Gets student's test grades
	 * 
	 * @return ArrayList of student's test grades
	 */
	public ArrayList<Integer> getGradesTest() {
		return this.gradesTest;
	}
}
