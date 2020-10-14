package com.philips.demo.dal;

import java.util.List;

import com.philips.demo.domain.Bed;

public interface BedDao {
	
	Bed addBed(Bed bed);
    List<Bed> findAll(); // display all beds in an ICU
    Bed findBed(int bedId);
    void deleteBed(int bedId);
}
