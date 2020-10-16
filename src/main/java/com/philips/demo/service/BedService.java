package com.philips.demo.service;

import java.util.List;

import com.philips.demo.domain.Bed;

public interface BedService {
	Bed addNewBed(Bed bedEntity);
	List<Bed> getAllBedsInfo();
	Bed getBedById(int bedId);
	List<Bed> getBedByAvaialability(boolean bedAvailability);
	boolean deleteBed(int bedId);
}
