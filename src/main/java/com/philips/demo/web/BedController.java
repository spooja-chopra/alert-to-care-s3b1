package com.philips.demo.web;

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

import com.philips.demo.domain.Bed;
import com.philips.demo.service.BedService;

@RestController
public class BedController {
	@Autowired
	BedService bedService;

	@PostMapping("/beds")
	public ResponseEntity<Bed> addNewBedInfo(@RequestBody Bed bed) {
		Bed newBed = bedService.addNewBed(bed);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(URI.create("/beds/" + newBed.getBedId()));
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

	@GetMapping("/beds")
	public ResponseEntity<List<Bed>> viewAllBedInfo() {
		List<Bed> beds = bedService.getAllBedsInfo();
		if (beds == null) {
			return new ResponseEntity<>(new ArrayList<Bed>(), HttpStatus.OK);
		}
		return new ResponseEntity<>(beds, HttpStatus.OK);

	}

	@GetMapping("/beds/{bedid}")
	public ResponseEntity<Bed> viewBedInfoById(@PathVariable("bedid") int bid) {
		Bed bed = bedService.getBedById(bid);

		if (bed != null) {
			return new ResponseEntity<>(bed, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/beds/{bedid}")
	public ResponseEntity<Bed> deleteEmp(@PathVariable("bedid") int bid) {
		Bed bEntity1 = bedService.getBedById(bid);
		if (bEntity1 != null) {
			boolean flag = bedService.deleteBed(bid);
			if (flag) {
				return new ResponseEntity<>(bEntity1, HttpStatus.NO_CONTENT);
			}
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/beds/{Availability}")
	public ResponseEntity<List<Bed>> viewByAvailability(@PathVariable("Availability") Boolean availability) {
		List<Bed> beds = bedService.getBedByAvaialability(availability);
		if (beds == null) {
			return new ResponseEntity<>(new ArrayList<Bed>(), HttpStatus.OK);
		}
		return new ResponseEntity<>(beds, HttpStatus.OK);

	}
}
