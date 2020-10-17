package com.philips.demo.dalTesting;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import com.philips.demo.dal.JpaPatientDao;
import com.philips.demo.dal.PatientDao;
import com.philips.demo.domain.Bed;
import com.philips.demo.domain.Patient;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(value = { JpaPatientDao.class })
public class PatientDaoTests {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private PatientDao patientDao;
	
	
	@Test
	public void testAddPatient() {
		Patient newPatient = getPatient();
		Patient savedInDb = entityManager.persist(newPatient);
		
		Patient getFromDb = patientDao.findPatient(savedInDb.getPatient_Id());
	
		assertThat(savedInDb.getAge()).isEqualTo(23);
		assertThat(savedInDb.getName()).isEqualTo("Ravikumar Tiwari");
		assertThat(savedInDb.getPhone_Number()).isEqualTo("1258795367");
		assertThat(getFromDb).isEqualTo(savedInDb);
		
	}
	
	private Patient getPatient() {
		Patient patient = new Patient();
		patient.setName("Ravikumar Tiwari");
		patient.setAge(23);
		patient.setPhone_Number("1258795367");
		patient.setBed(getBed());
		return patient;
	}
	
	private Bed getBed() {
		Bed myBed = new Bed();
		myBed.setBedSerialNumber(101);
		myBed.setBedAvailability(true);
		myBed.seticuNumber(1);
		entityManager.persist(myBed);
		return myBed;
	}
}
