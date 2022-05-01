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
public class Grades implements Comparable<Grades> {
	private String studentID;
	private String firstName;
	private String lastName;
	private ArrayList<Double> gradesLab;
	private ArrayList<Double> gradesProject;
	private ArrayList<Double> gradesTest;
	private Grades totalPoints;

	/**
	 * 0-parameter constructor, initializes variables
	 */
	public Grades() {
		this.studentID = "";
		this.firstName = "";
		this.lastName = "";
		this.gradesLab = new ArrayList<Double>();
		this.gradesProject = new ArrayList<Double>();
		this.gradesTest = new ArrayList<Double>();
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
	 * @precondition Grade added must be >= 0
	 */
	public void setGradesLab(double newGrade) {
		if (newGrade < 0) {
			throw new IllegalArgumentException("Added grade must be >= 0");
		}
		this.gradesLab.add(newGrade);
	}

	/**
	 * Gets student's lab grades
	 * 
	 * @return ArrayList of student's lab grades
	 */
	public ArrayList<Double> getGradesLab() {
		return this.gradesLab;
	}

	/**
	 * Adds a new grade to the project arraylist
	 * 
	 * @param newGrade Grade to be added to project arraylist
	 * @precondition Grade added must be >= 0
	 */
	public void setGradesProject(double newGrade) {
		if (newGrade < 0) {
			throw new IllegalArgumentException("Added grade must be >= 0");
		}
		this.gradesProject.add(newGrade);
	}

	/**
	 * Gets student's project grades
	 * 
	 * @return ArrayList of student's project grades
	 */
	public ArrayList<Double> getGradesProject() {
		return this.gradesProject;
	}

	/**
	 * Adds a new grade to the test arraylist
	 * 
	 * @param newGrade Grade to be added to test arraylist
	 * @precondition Grade added must be >= 0
	 */
	public void setGradesTest(double newGrade) {
		if (newGrade < 0) {
			throw new IllegalArgumentException("Added grade must be >= 0");
		}
		this.gradesTest.add(newGrade);
	}

	/**
	 * Gets student's test grades
	 * 
	 * @return ArrayList of student's test grades
	 */
	public ArrayList<Double> getGradesTest() {
		return this.gradesTest;
	}

	/**
	 * Gets sum of student's lab grades
	 * 
	 * @return Sum of student's lab grades
	 */
	public double sumGradesLab() {
		double sum = 0;
		for (int count = 0; count < this.gradesLab.size(); count++) {
			sum += this.gradesLab.get(count);
		}
		return sum;
	}

	/**
	 * Gets sum of student's project grades
	 * 
	 * @return Sum of student's project grades
	 */
	public double sumGradesProject() {
		double sum = 0;
		for (int count = 0; count < this.gradesProject.size(); count++) {
			sum += this.gradesProject.get(count);
		}
		return sum;
	}

	/**
	 * Gets sum of student's test grades
	 * 
	 * @return Sum of student's test grades
	 */
	public double sumGradesTest() {
		double sum = 0;
		for (int count = 0; count < this.gradesTest.size(); count++) {
			sum += this.gradesTest.get(count);
		}
		return sum;
	}

	/**
	 * Sets the object that holds total points for the grades
	 * 
	 * @param allPoints Grades object that has all available points
	 */
	public void setTotalPoints(Grades allPoints) {
		this.totalPoints = allPoints;
	}

	/**
	 * Calculates & returns average of lab grades
	 * 
	 * @return Average lab grade, expressed as decimal (not percent)
	 */
	public double getLabAverage() {
		double average = this.sumGradesLab() / this.totalPoints.sumGradesLab();
		return average;
	}

	/**
	 * Calculates & returns average of project grades
	 * 
	 * @return Average project grade, expressed as decimal (not percent)
	 */
	public double getProjectAverage() {
		double average = this.sumGradesProject() / this.totalPoints.sumGradesProject();
		return average;
	}

	/**
	 * Calculates & returns average of test grades
	 * 
	 * @return Average test grade, expressed as decimal (not percent)
	 */
	public double getTestAverage() {
		double average = this.sumGradesTest() / this.totalPoints.sumGradesTest();
		return average;
	}

	/**
	 * Calculates straight average
	 * 
	 * @return Straight average
	 */
	public double getStraightAverage() {
		double earned = this.sumGradesLab() + this.sumGradesProject() + this.sumGradesTest();
		double possible = this.totalPoints.sumGradesLab() + this.totalPoints.sumGradesProject()
				+ this.totalPoints.sumGradesTest();
		return (earned / possible);
	}

	/**
	 * Calculates weighted average (also tries to account for java floating point
	 * issues)
	 * 
	 * @return Weighted average
	 */
	public double getWeightedAverage() {
		double average = 0.20 * this.getLabAverage() + 0.35 * this.getProjectAverage() + 0.45 * this.getTestAverage();
		int mathAverage = (int) (average * 1000);
		average = (double) mathAverage / 1000;
		return average;
	}

	/**
	 * Uses Comparable interface, overrides compareTo() method
	 */
	@Override
	public int compareTo(Grades comparedGrades) {
		if (this.lastName.equals(comparedGrades.lastName) && this.firstName.equals(comparedGrades.firstName)) {
			return 0;
		} else if (this.lastName.equals(comparedGrades.lastName)
				&& this.firstName.compareTo(comparedGrades.firstName) >= 1) {
			return 1;
		} else if (this.lastName.compareTo(comparedGrades.lastName) >= 1) {
			return 1;
		} else {
			return -1;
		}
	}

}
