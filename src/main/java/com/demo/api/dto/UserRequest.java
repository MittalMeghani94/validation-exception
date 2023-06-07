package com.demo.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class UserRequest {

	@NotNull(message="username should not be null")
	private String name;
	
	@Email(message="invalid email address")
	private String email;
	
	@Pattern(regexp ="^\\d{10}$", message="invalid moblile number")
	private String mobile;
	
	@Min(18)
	@Max(60)
	private int age;
	
	private String gender;
	
	@NotBlank
	private String nationality;

	public UserRequest() {

	}

	public UserRequest(String name, String email, String mobile, int age, String gender, String nationality) {
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.age = age;
		this.gender = gender;
		this.nationality = nationality;
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
