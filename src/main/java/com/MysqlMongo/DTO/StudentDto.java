package com.MysqlMongo.DTO;

import java.util.List;

import com.MysqlMongo.CustomeAnotation.MyDTO;

@MyDTO
public class StudentDto {
	private String name;
	private String email;
	private long number;
	private List<CoursesDto> coursesDto;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public List<CoursesDto> getCoursesDto() {
		return coursesDto;
	}

	public void setCoursesDto(List<CoursesDto> coursesDto) {
		this.coursesDto = coursesDto;
	}

	public StudentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentDto(String name, String email, long number, List<CoursesDto> coursesDto) {
		super();
		this.name = name;
		this.email = email;
		this.number = number;
		this.coursesDto = coursesDto;
	}

	@Override
	public String toString() {
		return "StudentDto [name=" + name + ", email=" + email + ", number=" + number + ", coursesDto=" + coursesDto
				+ "]";
	}

}
