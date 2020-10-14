package com.philips.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bed_info")
public class Bed {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bed_Id;
	private String bed_Serial_Number;
	private boolean bed_Availability;
	private Integer icu_Number;
	
	
	public Bed() {
	
	}
	  
	public Bed(int bed_Id, String bed_Serial_Number, boolean bed_Availability, int icu_Number) {
		
		this.bed_Id = bed_Id;
		this.bed_Serial_Number = bed_Serial_Number;
		this.bed_Availability = bed_Availability;
		this.icu_Number = icu_Number;
	}

	public Integer getBed_Id() {
		return bed_Id;
	}

	public void setBed_Id(Integer bed_Id) {
		this.bed_Id = bed_Id;
	}

	public String getBed_Serial_Number() {
		return bed_Serial_Number;
	}

	public void setBed_Serial_Number(String bed_Serial_Number) {
		this.bed_Serial_Number = bed_Serial_Number;
	}

	public boolean isBed_Availability() {
		return bed_Availability;
	}

	public void setBed_Availability(boolean bed_Availability) {
		this.bed_Availability = bed_Availability;
	}

	public Integer getIcu_Number() {
		return icu_Number;
	}

	public void setIcu_Number(Integer icu_Number) {
		this.icu_Number = icu_Number;
	}
	
}
