package com.philips.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.demo.dal.BedDao;
import com.philips.demo.domain.Bed;

@Service
public class BedServiceImpl implements IBedService{

	@Autowired
	BedDao bedDao;

	@Override
	public Bed addNewBed(Bed bed) {
		//bed.setBedAvailability(true);
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
