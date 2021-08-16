package com.andrew.hibernate;

/*
 A simple Plain Old Java Object (POJO) for modeling 
 entities in database
 */
public class Student {
	private int id;
	private String name;
	private String rollNo;
	private String grade;

	public Student() {
	}

	public Student(int id, String name, String rollNo, String grade) {
		this.setId(id);
		this.setName(name);
		this.setRollNo(rollNo);
		this.setGrade(grade);
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the rollNo
	 */
	public String getRollNo() {
		return rollNo;
	}

	/**
	 * @param rollNo the rollNo to set
	 */
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
}
