package com.philips.demo.serviceTesting;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.philips.demo.domain.Vital;
import com.philips.demo.service.monitoring.RangeChecker;

public class MonitoringServiceTests {

	private String message;
	
	@Test
	public void vitalCheckSpo2Test() {
		RangeChecker checker = new RangeChecker(90, 100);
		Vital.setSpo2(100);
		Integer spo2 = Vital.getSpo2();
		message = checker.contains(spo2);
		assertEquals("Vital is Normal",message);
	}
	
	@Test
	public void vitalCheckBpmTest() {
		RangeChecker checker = new RangeChecker(70, 150);
		Vital.setBpm(100);
		Integer bpm = Vital.getBpm();
		message = checker.contains(bpm);
		assertEquals("Vital is Normal", message);
	}
	
	@Test
	public void vitalCheckRespRateTest() {
		RangeChecker checker = new RangeChecker(30, 95);
		Vital.setRespRate(50);
		Integer respRate = Vital.getRespRate();
		message = checker.contains(respRate);
		assertEquals("Vital is Normal", message);
	}
}
