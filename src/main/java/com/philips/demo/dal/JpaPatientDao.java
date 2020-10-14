package com.philips.demo.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.philips.demo.domain.Bed;
import com.philips.demo.domain.Patient;
import com.philips.demo.utils.GenericUtils;

@Transactional
@Repository
public class JpaPatientDao implements PatientDao{
	
	@PersistenceContext
    EntityManager eManager;

	@Override
	public Patient addPatient(Patient patient, int bedId) {
		Bed bed = eManager.find(Bed.class, bedId);
		patient.setBed(bed);
		eManager.persist(patient);
        return patient;
	}

	@Override
	public List<Patient> findAll() {
		return GenericUtils.castList(Patient.class, eManager.createQuery("SELECT p from Patient p").getResultList());
	}

	@Override
	public Patient findPatient(int id) {
		return eManager.find(Patient.class, id); 
	}

	@Override
	public void deletePatient(int patientId, int bedId) {
		// TODO Auto-generated method stub
		Patient patient = eManager.find(Patient.class, patientId);
		Bed bed = eManager.find(Bed.class, bedId);
		patient.freeBed(bed);
		
		eManager.createQuery("DELETE FROM Patient WHERE patient_Id = :paramId").setParameter("paramId", patientId).executeUpdate();
	}
	
	
}
