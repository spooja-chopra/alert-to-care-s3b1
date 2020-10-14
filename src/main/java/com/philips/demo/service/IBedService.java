package com.philips.demo.service;

import java.util.List;

import com.philips.demo.domain.Bed;

public interface IBedService {
	Bed addNewBed(Bed bEntity);
	List<Bed> getAllBedsInfo();
	Bed getBedById(int bedid);
	List<Bed> getBedByAvaialability(boolean bedAvailability);
	List<Bed> getBedByICUNumber(int ICUNumber);
	boolean deleteBed(int bedid);
}
