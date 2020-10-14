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
	private int bedID;
	@Column(name="bed_Serial_Number")
	private int bedSerialNumber;
	@Column(name="bed_Availability")
	private boolean bedAvailability;
	@Column(name="icu_Number")
	private int ICUNumber;
	
	public Bed() {
	  }
	  
	public Bed(boolean bedAvailability) {
	    this.bedAvailability = bedAvailability;
	  }
	
	public int getBedID() {
		return bedID;
	}
	public void setBedID(int bedID) {
		this.bedID = bedID;
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
	public int getICUNumber() {
		return ICUNumber;
	}
	public void setICUNumber(int iCUNumber) {
		ICUNumber = iCUNumber;
	}
	
	@Override
	public String toString() {
		return "Bed [bedId=" + bedID + ", isAvailable=" + bedAvailability + "]";
	}
	
}
