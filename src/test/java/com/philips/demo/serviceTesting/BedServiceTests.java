package com.philips.demo.serviceTesting;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import com.philips.demo.dal.BedDao;
import com.philips.demo.domain.Bed;
import com.philips.demo.domain.Patient;
import com.philips.demo.service.BedServiceImpl;

public class BedServiceTests {

	 @Test
	    public void addNewBedTest() {
	        Bed bed = new Bed();
	        BedServiceImpl bsi = new BedServiceImpl();
	        BedDao dao = Mockito.mock(BedDao.class);
	        Mockito.when(dao.addBed(bed)).thenReturn(bed);
	        bsi.setBedDao(dao);
	        Bed refBed = bsi.addNewBed(bed);
	        
	        
	        assertTrue(refBed.isBedAvailability());
	        
	 }
	 
	  @Test
	    public void getAllBedsTest() {
		    List<Bed> beds = new ArrayList<>();
        	beds.add(new Bed());
	        BedServiceImpl bsi = new BedServiceImpl();
	        BedDao dao = Mockito.mock(BedDao.class);
	        Mockito.when(dao.viewBedInfo()).thenReturn(beds);
	        
	        bsi.setBedDao(dao);
	        assertTrue(beds.containsAll(bsi.getAllBedsInfo()));
	    }
	  
	  @Test
	    public void findBedByAvailabilityTest() {
		  	List<Bed> beds = new ArrayList<>();
	        beds.add(new Bed());
	        BedServiceImpl bsi = new BedServiceImpl();
	        BedDao dao = Mockito.mock(BedDao.class);
	        Mockito.when(dao.viewBedInfoByAvailability(true)).thenReturn(beds);
	        bsi.setBedDao(dao);

	        assertEquals(beds, bsi.getBedByAvaialability(true));
	        
	    }

	  
	  @Test
	    public void findBedByIdTest() {
	        Bed bed = new Bed();
	        BedServiceImpl bsi = new BedServiceImpl();
	        BedDao dao = Mockito.mock(BedDao.class);
	        Mockito.when(dao.findBed(1)).thenReturn(bed);
	        
	        bsi.setBedDao(dao);

	        assertEquals(bed, bsi.getBedById(1));
	    }
	  
	
	  @Test
	    public void deletingNonExistingBedReturnsFalse() {
	        BedServiceImpl bsi = new BedServiceImpl();
	        BedDao dao = Mockito.mock(BedDao.class);
	        Mockito.when(dao.findBed(1)).thenReturn(null);
	        bsi.setBedDao(dao);

	        assertFalse(bsi.deleteBed(1));

	    }

	    @Test
	    public void deletingAnUnavailableBedReturnsFalse() {
	        BedServiceImpl bsi = new BedServiceImpl();
	        BedDao dao = Mockito.mock(BedDao.class);
	        Mockito.when(dao.findBed(1)).thenReturn(new Bed(false));
	        bsi.setBedDao(dao);
	        
	        assertFalse(bsi.deleteBed(1));
	    }

	  


}
