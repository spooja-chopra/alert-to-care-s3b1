package com.philips.demo.dal;

import java.util.List;

import com.philips.Entity.BedEntity;

public interface IBedDao {

	public BedEntity addBed(BedEntity bEntity );
	public List<BedEntity> viewBedInfo();
	public List<BedEntity> viewBedInfoByICU(Integer ICU_Number);
	public List<BedEntity> viewBedInfoByAvailability(Boolean bed_Availability);
	public void removeBedInfo(BedEntity bEntity);
	public BedEntity findBed(Integer b_ID);
	
	
}