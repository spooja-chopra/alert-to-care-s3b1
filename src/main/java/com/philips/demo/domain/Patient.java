package com.philips.demo.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "patient_info")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "patient_Id")
	private int patientId;
	@Column(name = "name")
	private String name;
	@Column(name = "age")
	private int age;
	@Column(name = "phone_Number")
	private String phoneNumber;
	
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="bed_Id")
	Bed bed;
	
	public Patient() {
	
	}
	
	public Patient(String name, int age, String phoneNumber, Bed bed) {
	    this.name = name;
	    this.age = age;
	    this.phoneNumber = phoneNumber;
	    this.bed = bed;
	}


	
	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public Bed getBed() {
		return bed;
	}


	public void setBed(Bed bed) {
		if(bed != null) {
			this.bed = bed; 
			this.bed.setBedAvailability(false);
	    }
	}
	
	public void freeBed(Bed bed) {
		if(bed != null) {
			this.bed = bed; 
	        this.bed.setBedAvailability(true);
	    }
	}
	
	@Override
	public String toString() {
	    return "Patient [age=" + age + ", id=" + patientId + ", name=" + name + ", phoneNumber=" + phoneNumber + "]";
	}

	
	
}
