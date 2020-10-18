package com.philips.demo.webTesting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.philips.demo.domain.Bed;
import com.philips.demo.service.BedService;
import com.philips.demo.web.BedController;

public class BedControllerTests {
	@Test
    public void addNewBedInfoTest() {
        Bed bed = new Bed();
        bed.setBedId(1);
        BedService bs = Mockito.mock(BedService.class);
        Mockito.when(bs.addNewBed(Mockito.any(Bed.class))).thenReturn(bed);
        BedController bc = new BedController();
        bc.setBedService(bs);

        ResponseEntity<Bed> response = bc.addNewBedInfo(bed);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("beds/1", response.getHeaders().getLocation().toString());
    }

    @Test
    public void getAllBedsReturnsEmptyListWhenThereAreNoBeds() {
        BedService bs = Mockito.mock(BedService.class);
        Mockito.when(bs.getAllBedsInfo()).thenReturn(null);
        BedController bc = new BedController();
        bc.setBedService(bs);

        ResponseEntity<List<Bed>> response = bc.viewAllBedInfo();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(0, response.getBody().size());
    }
  
    @Test
    public void getAllBedsReturnsListOfBedsWhenThereAreBeds() {
        List<Bed> beds = new ArrayList<>();
        beds.add(new Bed());
        BedService bs = Mockito.mock(BedService.class);
        Mockito.when(bs.getAllBedsInfo()).thenReturn(beds);
        BedController bc = new BedController();
        bc.setBedService(bs);

        ResponseEntity<List<Bed>> response = bc.viewAllBedInfo();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().containsAll(beds));
    }

    @Test
    public void getBedByIdReturnsNotFoundForInvalidId() {
        BedService bs = Mockito.mock(BedService.class);
        Mockito.when(bs.getBedById(Mockito.anyInt())).thenReturn(null);
        BedController bc = new BedController();
        bc.setBedService(bs);

        ResponseEntity<Bed> response = bc.viewBedInfoById(1);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void getBedByIdReturnsBedForValidId() {
        BedService bs = Mockito.mock(BedService.class);
        Bed bed = new Bed();
        Mockito.when(bs.getBedById(1)).thenReturn(bed);
        BedController bc = new BedController();
        bc.setBedService(bs);

        ResponseEntity<Bed> response = bc.viewBedInfoById(1);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(bed, response.getBody());
    }
    
        
    public void getBedByAvailabilityReturnsBedForValidId() {
        BedService bs = Mockito.mock(BedService.class);
        List<Bed> beds = new ArrayList<>();
        beds.add(new Bed());
        Mockito.when(bs.getBedByAvaialability(true)).thenReturn(beds);
        BedController bc = new BedController();
        bc.setBedService(bs);

        ResponseEntity<List<Bed>> response = bc.viewByAvailability(true);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(beds, response.getBody());
    }


    @Test
    public void deleteBedReturnsNoContentIfBedIsDeleted() {
        BedService bs = Mockito.mock(BedService.class);
        Bed bed = new Bed();
        Mockito.when(bs.getBedById(1)).thenReturn(bed);
        Mockito.when(bs.deleteBed(1)).thenReturn(true);
        BedController bc = new BedController();
        bc.setBedService(bs);

        ResponseEntity<Bed> response = bc.deleteBed(1);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    public void deleteBedReturnsBadRequestForInvalidId() {
        BedService bs = Mockito.mock(BedService.class);
        Mockito.when(bs.getBedById(1)).thenReturn(null);
        BedController bc = new BedController();
        bc.setBedService(bs);

        ResponseEntity<Bed> response = bc.deleteBed(1);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
    
    


}
