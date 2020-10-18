package com.philips.demo.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.philips.demo.domain.Patient;
import com.philips.demo.domain.Vital;
import com.philips.demo.service.PatientService;
import com.philips.demo.service.monitoring.MonitoringService;

@RestController
public class MonitoringController {
	
	private String message;
	@Autowired
	MonitoringService monitorService;
	
	@Autowired
	PatientService patientService;
	
	public void setMonitoringService(MonitoringService monitorService) {
		this.monitorService = monitorService;
	}
	
	
	@PostMapping("/monitor/bpm/{pid}")
	public ResponseEntity<String> checkForBpm(@PathVariable("pid") int patientId,@RequestBody Vital vital)
	{	 Patient patient = patientService.getPatient(patientId);
		if (patient == null)
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 message = monitorService.vitalCheckBpm(vital.getBpm());
		return new ResponseEntity<>(message, HttpStatus.OK);
		
	}

	@PostMapping("/monitor/spo2/{pid}")
	public ResponseEntity<String> checkForSpo2(@PathVariable("pid") int patientId,@RequestBody Vital vital)
	{	 Patient patient = patientService.getPatient(patientId);
		if (patient == null)
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 message = monitorService.vitalCheckSpo2(vital.getSpo2());
		return new ResponseEntity<>(message, HttpStatus.OK);
		
		
	}
	
	@PostMapping("/monitor/respRape/{pid}")
	public ResponseEntity<String> checkForRespRate(@PathVariable("pid") int patientId,@RequestBody Vital vital)
	{	 Patient patient = patientService.getPatient(patientId);
		if (patient == null)
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 message = monitorService.vitalCheckRespRate(vital.getRespRate());
		return new ResponseEntity<>(message, HttpStatus.OK);
		
		
	}
}
