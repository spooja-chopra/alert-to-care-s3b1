package com.philips.demo.domain;

public class Vital {
	private static int Bpm;
	private static int Spo2;
	private static int RespRate;

	
	public int getBpm() {
		return Bpm;
	}
	
	public static Integer setBpm(int bpm) {
		return Bpm = bpm;
	}
	
	public int getSpo2() {
		return Spo2;
	}
	
	public static Integer setSpo2(int spo2) {
		return Spo2 = spo2;
	}
	
	public int getRespRate() {
		return RespRate;
	}
	
	public static Integer setRespRate(int respRate) {
		return RespRate = respRate;
	}

	public Vital() {
	
	}
	
	
	
}
