package com.philips.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.demo.dal.BedDao;
import com.philips.demo.dal.PatientDao;
import com.philips.demo.domain.Bed;
import com.philips.demo.domain.Patient;

@Service
public class PatientServiceImpl implements PatientService{
	
	@Autowired
	PatientDao patientDao;

    @Autowired
    BedDao bedDao;
    
    public void setBedDao(BedDao bedDao) {
    	this.bedDao = bedDao;
    }
    
    public void setPatientDao(PatientDao patientDao) {
    	this.patientDao = patientDao;
    }
    
    @Override
    public Patient addNewPatient(Patient patient, int bedId) {
        Bed bed = bedDao.findBed(bedId); 
        if (bed == null) return null;

        if (bed.isBedAvailability()) {
           return patientDao.addPatient(patient, bedId);
        } else {
            return null;
        }
    }

	@Override
	public List<Patient> getAllPatients() {
		
		return patientDao.findAll();
	}

	@Override
	public Patient getPatient(int patientId) {
		return patientDao.findPatient(patientId);
	}

	@Override
	public boolean dischargePatient(int patientId, int bedId) {
		Patient patient = patientDao.findPatient(patientId);
        if (patient == null) 
        	return false;

        patientDao.deletePatient(patientId, bedId);
        return true;
	}
}
