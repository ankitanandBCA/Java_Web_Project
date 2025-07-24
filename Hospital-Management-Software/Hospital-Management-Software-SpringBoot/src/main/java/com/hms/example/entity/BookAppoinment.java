package com.hms.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BookAppoinment {
	@Id
	private String name;
	private String email;
	private String mobile;
	private String address;
	private String specilist;
	private String appoinment_date;
	private String time;
	private String description;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSpecilist() {
		return specilist;
	}
	public void setSpecilist(String specilist) {
		this.specilist = specilist;
	}
	public String getAppoinment_date() {
		return appoinment_date;
	}
	public void setAppoinment_date(String appoinment_date) {
		this.appoinment_date = appoinment_date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BookAppoinment(String name, String email, String mobile, String address, String specilist,
			String appoinment_date, String time, String description) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.specilist = specilist;
		this.appoinment_date = appoinment_date;
		this.time = time;
		this.description = description;
	}
	
	
	public BookAppoinment()
	{
		
	}

}
