package com.philips.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.philips.Entity.Bed;
import com.philips.dao.IBedDao;

public class BedServiceImp implements IBedService{
	@Autowired
	IBedDao bedDao;

	@Override
	public Bed addNewBed(Bed bed) {
		 bed.setBedAvailability(true);
	        return bedDao.addBed(bed);
	}

	@Override
	public List<Bed> getAllBedsInfo() {
		return bedDao.viewBedInfo();
	}

	@Override
	public Bed getBedById(int bedid) {
		return bedDao.findBed(bedid);
	}

	@Override
	public List<Bed> getBedByAvaialability(boolean bedAvailability) {
		return bedDao.viewBedInfoByAvailability(bedAvailability);
	}

	@Override
	public List<Bed> getBedByICUNumber(int ICUNumber) {
		return bedDao.viewBedInfoByICU(ICUNumber);
	}

	@Override
	public boolean deleteBed(int bedid) {
		 Bed bed = bedDao.findBed(bedid);
	        if (bed == null) 
	        	return false;
	        if (bed.isBedAvailability()) {
	            bedDao.removeBedInfo(bed);
	            return true;
	        }

	        return false;
	    }

}