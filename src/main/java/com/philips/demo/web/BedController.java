package com.philips.web;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.philips.Entity.Bed;
import com.philips.exceptions.BedNotFoundException;
import com.philips.service.IBedService;

@RestController
public class BedController {

	@Autowired
	private IBedService bedService;
	
	@PostMapping("/addBed")
	public ResponseEntity<Bed> addNewBed(@RequestBody Bed bed) {
		 Bed bed1 = new Bed(true);
	        Bed newBed = bedService.addNewBed(bed1);
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(URI.create("/beds/" + newBed.getBedID()));
	        return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/viewall")
	public ResponseEntity<List<Bed>> viewall(){
		List<Bed> beds = bedService.getAllBedsInfo();
        if (beds == null) {
            return new ResponseEntity<>(new ArrayList<Bed>(), HttpStatus.OK);
        }
        return new ResponseEntity<>(beds, HttpStatus.OK);
	
	
	}
	
	
	@GetMapping("/viewbybedid/{bedid}")
	public ResponseEntity<Bed> viewBedInfoById(@PathVariable("bedid") int bid) {
		 Bed bed = bedService.getBedById(bid);

	        if (bed != null){
	            return new ResponseEntity<>(bed, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }	
	}
	
	
	
	@DeleteMapping("/deleteBedId/{bedid}")
	public String deleteEmp(@PathVariable("bedid") int bid) throws BedNotFoundException {
		Bed bEntity1 = bedService.getBedById(bid);
		if(bEntity1 == null)
			throw new BedNotFoundException("Bed Not Found for id" + bid);
		bedService.deleteBed(bid);
		return "Bed Deleted for the Id" + bid;
			
	} 
	
	@GetMapping("/viewbyAvailability/{Availability}")
	public ResponseEntity<List<Bed>> viewbyAvailability1(@PathVariable("Availability") Boolean Availability) throws BedNotFoundException{
		List<Bed> beds = bedService.getBedByAvaialability(Availability);
        if (beds == null) {
            return new ResponseEntity<>(new ArrayList<Bed>(), HttpStatus.OK);
        }
        return new ResponseEntity<>(beds, HttpStatus.OK);
	
	
	}
	
	@GetMapping("/viewbyICUNumber/{ICUNumber}")
	public ResponseEntity<List<Bed>> viewbyICUNumber(@PathVariable("ICUNumber") Integer ICUNumber){
		List<Bed> beds = bedService.getBedByICUNumber(ICUNumber);
        if (beds == null) {
            return new ResponseEntity<>(new ArrayList<Bed>(), HttpStatus.OK);
        }
        return new ResponseEntity<>(beds, HttpStatus.OK);
	
	
	}
	
	
}












