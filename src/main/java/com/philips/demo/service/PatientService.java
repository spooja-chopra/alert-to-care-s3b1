package com.philips.demo.service;

import java.util.List;

import com.philips.demo.domain.Patient;

public interface PatientService {
	
	Patient addNewPatient(Patient patient, int bedId);
    List<Patient> getAllPatients();
    Patient getPatient(int patientId);
    boolean dischargePatient(int patientId, int bedId);
}
