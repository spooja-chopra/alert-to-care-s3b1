package com.philips.demo.service.monitoring;

public interface MonitoringService {
	
		public String vitalCheckSpo2(int spo2);
		public String vitalCheckBpm(int bpm);
		public String vitalCheckRespRate(int respRate);
}
