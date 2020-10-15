package com.philips.demo.service.Monitoring;

public class rangeChecker {
	    private int low;
	    private int high;

	    public rangeChecker(int low, int high){
	        this.low = low;
	        this.high = high;
	    }
	    

	    public String contains(int number){
	        if(number>high)
	        	return "Vital is high";
	        else if(number<low)
	        	return "Vital is Low";
	        else
	        	return"Vital is Normal";
	        		
	    }
}

