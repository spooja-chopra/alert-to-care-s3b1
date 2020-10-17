package com.philips.demo.domain;

import javax.persistence.CascadeType;
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
	private int patient_Id;//primitive data types
	private String name;
	private int age;
	private String phone_Number;
	
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="bed_Id")
	Bed bed;
	
	public Patient() {
	
	}
	
	public Patient(String name, int age, String phone_Number, Bed bed) {
	    this.name = name;
	    this.age = age;
	    this.phone_Number = phone_Number;
	    this.bed = bed;
	}


	
	public int getPatient_Id() {
		return patient_Id;
	}

	public void setPatient_Id(int patient_Id) {
		this.patient_Id = patient_Id;
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

	public String getPhone_Number() {
		return phone_Number;
	}

	public void setPhone_Number(String phone_Number) {
		this.phone_Number = phone_Number;
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
	    return "Patient [age=" + age + ", id=" + patient_Id + ", name=" + name + ", phoneNumber=" + phone_Number + "]";
	}

	
	
}
