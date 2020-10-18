package com.philips.demo.serviceTesting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import com.philips.demo.dal.BedDao;
import com.philips.demo.dal.PatientDao;
import com.philips.demo.domain.Bed;
import com.philips.demo.domain.Patient;
import com.philips.demo.service.PatientServiceImpl;

public class PatientServiceImplTest {
	
	@Test
    public void addNewPatientTestWhenBedDoesNotExist() {
        BedDao bedDao = Mockito.mock(BedDao.class);
        PatientDao patientDao = Mockito.mock(PatientDao.class);
        Patient patient = new Patient();

        Mockito.when(bedDao.findBed(1)).thenReturn(null);

        PatientServiceImpl psi = new PatientServiceImpl();
        psi.setBedDao(bedDao);
        psi.setPatientDao(patientDao);
        
        assertNull(psi.addNewPatient(patient, 1));
    }
	
	@Test
    public void addNewPatientTestWhenBedIsNotAvailable() {
        BedDao bedDao = Mockito.mock(BedDao.class);
        PatientDao patientDao = Mockito.mock(PatientDao.class);
        Patient patient = new Patient();

        Mockito.when(bedDao.findBed(1)).thenReturn(new Bed(false));

        PatientServiceImpl psi = new PatientServiceImpl();
        psi.setBedDao(bedDao);
        psi.setPatientDao(patientDao);
        
        assertNull(psi.addNewPatient(patient, 1));
    }
	
	@Test
    public void addNewPatientTestWhenBedIsAvailable() {
        BedDao bedDao = Mockito.mock(BedDao.class);
        PatientDao patientDao = Mockito.mock(PatientDao.class);
        Patient patient = new Patient();

        Mockito.when(bedDao.findBed(1)).thenReturn(new Bed(true));
        Mockito.when(patientDao.addPatient(patient, 1)).thenReturn(patient);

        PatientServiceImpl psi = new PatientServiceImpl();
        psi.setBedDao(bedDao);
        psi.setPatientDao(patientDao);
        
        assertEquals(patient,psi.addNewPatient(patient, 1));
    }
	
	@Test
	public void getAllPatientsTest() {
		PatientDao patientDao = Mockito.mock(PatientDao.class);
        List<Patient> patients = List.of(new Patient());

        Mockito.when(patientDao.findAll()).thenReturn(patients);

        PatientServiceImpl psi = new PatientServiceImpl();
        psi.setPatientDao(patientDao);

        assertTrue(patients.containsAll(psi.getAllPatients()));
	}
	
	@Test
    public void getPatientTest() {
        PatientDao patientDao = Mockito.mock(PatientDao.class);
        Patient patient = new Patient();

        Mockito.when(patientDao.findPatient(1)).thenReturn(patient);

        PatientServiceImpl psi = new PatientServiceImpl();
        psi.setPatientDao(patientDao);

        assertEquals(patient, psi.getPatient(1));
    }
	
	@Test
    public void dischargePatientWhenPatientIsNull() {
        PatientDao patientDao = Mockito.mock(PatientDao.class);
        BedDao bedDao = Mockito.mock(BedDao.class);

        Mockito.when(patientDao.findPatient(1)).thenReturn(null);

        PatientServiceImpl psi = new PatientServiceImpl();
        psi.setPatientDao(patientDao);
        psi.setBedDao(bedDao);

        assertFalse(psi.dischargePatient(1,1));
    }
	
	
	@Test
    public void dischargePatientWhenPatientExists() {
        PatientDao patientDao = Mockito.mock(PatientDao.class);
        BedDao bedDao = Mockito.mock(BedDao.class);
        
        Patient patient = new Patient();
        Bed bed = new Bed(true);
        patient.setBed(bed);

        Mockito.when(patientDao.findPatient(1)).thenReturn(patient);
        
        PatientServiceImpl psi = new PatientServiceImpl();
        psi.setPatientDao(patientDao);
        psi.setBedDao(bedDao);

        assertTrue(psi.dischargePatient(1,1));
    }
	
}
