package com.philips.demo.domain;

public class Vital {
	private Integer getBpm;
	private Integer getSpo2;
	private Integer getRespRate;
	
	public Vital(Integer getBpm, Integer getSpo2, Integer getRespRate) {
		super();
		this.getBpm = getBpm;
		this.getSpo2 = getSpo2;
		this.getRespRate = getRespRate;
	}
	
	public Integer getGetBpm() {
		return getBpm;
	}
	
	public Integer getGetSpo2() {
		return getSpo2;
	}
	
	public Integer getGetRespRate() {
		return getRespRate;
	}
	
	
}
