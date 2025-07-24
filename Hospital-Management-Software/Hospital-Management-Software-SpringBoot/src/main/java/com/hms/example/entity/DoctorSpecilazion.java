package com.hms.example.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class DoctorSpecilazion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String specilazion;
	public DoctorSpecilazion( String specilazion) {
		super();
	
		this.specilazion = specilazion;
	}
	public DoctorSpecilazion() {
		super();
	}
	public String getSpecilazion() {
		return specilazion;
	}
	public void setSpecilazion(String specilazion) {
		this.specilazion = specilazion;
	}
	
	

}
