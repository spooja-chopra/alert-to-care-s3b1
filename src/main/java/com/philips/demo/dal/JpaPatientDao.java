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
    EntityManager em;

	@Override
	public Patient addPatient(Patient patient, int bedId) {
		Bed bed = em.find(Bed.class, bedId);
		patient.setBed(bed);
        em.persist(patient);
        return patient;
	}

	@Override
	public List<Patient> findAll() {
		return GenericUtils.castList(Patient.class, em.createQuery("SELECT p from Patient p").getResultList());
	}

	@Override
	public Patient findPatient(int id) {
		return em.find(Patient.class, id); 
	}

	@Override
	public void deletePatient(int id) {
		// TODO Auto-generated method stub
		em.createQuery("DELETE FROM Patient WHERE patient_Id = :paramId").setParameter("paramId", id).executeUpdate();
	}
	
	
}
