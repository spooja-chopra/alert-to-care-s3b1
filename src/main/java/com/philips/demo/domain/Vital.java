package com.philips.demo.domain;

public class Vital {
	private static int bpm;
	private static int spo2;
	private static int respRate;

	private Vital() {
		throw new IllegalStateException("Vital class");
	}

	public static int getBpm() {
		return bpm;
	}

	public static void setBpm(int bpm) {
		Vital.bpm = bpm;
	}

	public static int getSpo2() {
		return spo2;
	}

	public static void setSpo2(int spo2) {
		Vital.spo2 = spo2;
	}

	public static int getRespRate() {
		return respRate;
	}

	public static void setRespRate(int respRate) {
		Vital.respRate = respRate;
	}

}
