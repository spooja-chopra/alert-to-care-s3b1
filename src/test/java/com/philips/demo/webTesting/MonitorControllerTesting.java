package com.philips.demo.webTesting;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.philips.demo.domain.Bed;
import com.philips.demo.domain.Patient;
import com.philips.demo.domain.Vital;
import com.philips.demo.service.BedService;
import com.philips.demo.service.PatientService;
import com.philips.demo.service.Monitoring.MonitoringService;
import com.philips.demo.service.Monitoring.MonitoringServiceImp;
import com.philips.demo.web.BedController;
import com.philips.demo.web.MonitoringController;

public class MonitorControllerTesting {
	
	
		
	
	 /*@Test
	 public void monitorBpm() {
		 Vital vital = new Vital();
		 PatientService ps = Mockito.mock(PatientService.class);
		 Patient p = new Patient();
		 Mockito.when(ps.getPatient(1)).thenReturn(p);	 
		 MonitoringService ms = Mockito.mock(MonitoringService.class);
		 Mockito.when(ms.vitalCheckBpm(Mockito.anyInt())).thenReturn(null);
		 MonitoringController mc = new MonitoringController();
		 mc.setMonitoringService(ms);

		 ResponseEntity<Vital> response = mc.checkForBpm(1,vital.getBpm());
		 assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
 }*/
    
}
