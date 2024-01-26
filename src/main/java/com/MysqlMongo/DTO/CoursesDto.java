package com.MysqlMongo.DTO;

import com.MysqlMongo.CustomeAnotation.MyDTO;

@MyDTO
public class CoursesDto {
	private String courseName;
	private String email;
	private int cost;

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

	public CoursesDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CoursesDto(String courseName, String email, int cost) {
		super();
		this.courseName = courseName;
		this.email = email;
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "CoursesDto [courseName=" + courseName + ", email=" + email + ", cost=" + cost + "]";
	}

}
