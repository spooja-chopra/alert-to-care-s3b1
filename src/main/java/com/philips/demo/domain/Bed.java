package com.philips.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bed_info")
public class Bed {
	
	@Id
	@Column(name="bed_Id")
	private int bedId;
	@Column(name="bed_Serial_Number")
	private int bedSerialNumber;
	@Column(name="bed_Availability")
	private boolean bedAvailability;
	@Column(name="icu_Number")
	private int icuNumber;
	
	public Bed() {
	  }
	  
	public Bed(boolean bedAvailability) {
	    this.bedAvailability = bedAvailability;
    }
	
	public int getBedId() {
		return bedId;
	}
	public void setBedId(int bedId) {
		this.bedId = bedId;
	}
	public int getBedSerialNumber() {
		return bedSerialNumber;
	}
	public void setBedSerialNumber(int bedSerialNumber) {
		this.bedSerialNumber = bedSerialNumber;
	}
	public boolean isBedAvailability() {
		return bedAvailability;
	}
	public void setBedAvailability(boolean bedAvailability) {
		this.bedAvailability = bedAvailability;
	}
	public int geticuNumber() {
		return icuNumber;
	}
	public void seticuNumber(int icuNumber) {
		this.icuNumber = icuNumber;
	}
	
	@Override
	public String toString() {
		return "Bed [bedId=" + bedId + ", isAvailable=" + bedAvailability + "]";
	}
	
}
