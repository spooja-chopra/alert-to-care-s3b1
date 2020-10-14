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
	private Integer patient_Id;
	private String name;
	private Integer age;
	private String phone_Number;
	
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="bed_Id")
	Bed bed;
	
	public Patient() {
	
	}
	
	public Patient(String name, int age, String phone_Number) {
	    this.name = name;
	    this.age = age;
	    this.phone_Number = phone_Number;
	}


	
	public Integer getPatient_Id() {
		return patient_Id;
	}

	public void setPatient_Id(Integer patient_Id) {
		this.patient_Id = patient_Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
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
		if (bed == null) {
	      this.bed.setBed_Availability(true);
	      this.bed = null;
	    } else {
	      this.bed = bed; 
	      this.bed.setBed_Availability(false);
	    }
	}
	
	
}
