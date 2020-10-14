package com.philips.demo.dal;

import java.util.List;

import com.philips.demo.domain.Patient;

public interface PatientDao {
	
	Patient addPatient(Patient patient, int bedId);
	List<Patient> findAll();
	Patient findPatient(int id);
	void deletePatient(int id);

}
