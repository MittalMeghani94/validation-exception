package com.demo.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")

public class User {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String email;
	private String mobile;
	private int age;
	private String gender;
	private String nationality;

	public User() {
		
	}

	public User(String name, String email, String mobile, int age, String gender, String nationality) {
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.age = age;
		this.gender = gender;
		this.nationality = nationality;
	}

	public User(int id, String name, String email, String mobile, int age, String gender, String nationality) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.age = age;
		this.gender = gender;
		this.nationality = nationality;
	}

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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	
}
