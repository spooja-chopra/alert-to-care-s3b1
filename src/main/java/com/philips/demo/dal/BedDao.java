package com.philips.demo.dal;

import java.util.List;

import com.philips.demo.domain.Bed;

public interface BedDao {
	
	public Bed addBed(Bed bedEntity );
	public List<Bed> viewBedInfo();
	public List<Bed> viewBedInfoByAvailability(Boolean bedAvailability);
	public void removeBedInfo(Bed bedEntity);
	public Bed findBed(Integer bedId);
}
