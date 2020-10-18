package com.philips.demo.serviceTesting;




import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.philips.demo.domain.Vital;
import com.philips.demo.service.Monitoring.RangeChecker;

public class MonitoringServiceTests {

	private String message;
	@Test
	public void vitalCheckSpo2Test() {
		RangeChecker checker = new RangeChecker(90, 100);
		Integer spo2 = Vital.setSpo2(100);
		message = checker.contains(spo2);
		assertEquals(message,"Vital is Normal");
		
		
	}
	@Test
	public void vitalCheckBpmTest() {
		RangeChecker checker = new RangeChecker(70, 150);
		Integer bpm = Vital.setBpm(100);
		message = checker.contains(bpm);
		assertEquals(message,"Vital is Normal");
		
		
	}
	@Test
	public void vitalCheckRespRateTest() {
		RangeChecker checker = new RangeChecker(30, 95);
		Integer respRate = Vital.setRespRate(50);
		message = checker.contains(respRate);
		assertEquals(message,"Vital is Normal");
		
		
	}
}
