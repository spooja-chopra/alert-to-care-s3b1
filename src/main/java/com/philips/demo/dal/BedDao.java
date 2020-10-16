package com.philips.demo.dal;

import java.util.List;

import com.philips.demo.domain.Bed;

public interface BedDao {
	
	public Bed addBed(Bed bEntity );
	public List<Bed> viewBedInfo();
	public List<Bed> viewBedInfoByAvailability(Boolean bed_Availability);
	public void removeBedInfo(Bed bEntity);
	public Bed findBed(Integer b_ID);
}
