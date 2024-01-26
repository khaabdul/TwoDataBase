package com.MysqlMongo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Student")
public class StudentBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private long number;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public StudentBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentBean(int id, String name, String email, long number) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.number = number;
	}

	@Override
	public String toString() {
		return "StudentBean [id=" + id + ", name=" + name + ", email=" + email + ", number=" + number + "]";
	}

}
