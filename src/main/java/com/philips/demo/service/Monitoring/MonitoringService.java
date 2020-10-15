package com.philips.demo.service.Monitoring;

import org.springframework.stereotype.Service;

@Service
public class MonitoringService implements IMonitoringService {
	
	private String message;
	@Override
	public String vitalCheckSpo2(int spo2) {
		rangeChecker checker = new rangeChecker(90, 100);
		message = checker.contains(spo2);
		return "Spo2" + message; 
	}

	@Override
	public String vitalCheckBpm(int bpm) {
		rangeChecker checker = new rangeChecker(70, 150);
		message = checker.contains(bpm);
		return "Bpm" + message;
		
	}

	@Override
	public String vitalCheckRespRate(int respRate) {
		rangeChecker checker = new rangeChecker(30, 95);
		message = checker.contains(respRate);
		return "respRate" + message;
	}
	
	
	
}
