package com.MysqlMongo.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document(collection = "Courses")
public class CoursesBean {
	@Id
	private int id;
	private String courseName;
	private String email;
	private int cost;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public CoursesBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CoursesBean(int id, String courseName, String email, int cost) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.email = email;
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "CoursesBean [id=" + id + ", courseName=" + courseName + ", email=" + email + ", cost=" + cost + "]";
	}

}
