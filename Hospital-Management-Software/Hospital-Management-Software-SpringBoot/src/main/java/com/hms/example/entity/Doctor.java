package com.hms.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Doctor {
   @Id
	private String name;
	private String email;
	private String mobile;
	private String password;
	private String qualification;
	private String experience;
	private String address;
	public String getName() {
		return name;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Doctor(String name, String email, String mobile, String password, String qualification, String experience,
			String address) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.qualification = qualification;
		this.experience = experience;
		this.address = address;
	}
	public Doctor() {
		super();
	}
	
	
	
	
}
