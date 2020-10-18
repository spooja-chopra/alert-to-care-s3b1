package com.philips.demo.dalTesting;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import com.philips.demo.dal.BedDao;
import com.philips.demo.dal.JpaBedDao;
import com.philips.demo.domain.Bed;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(value = {JpaBedDao.class })
public class BedDaoTests {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private BedDao bedDao;
	
	
	@Test
	public void testAddBed() {
		Bed newBed = getBed();
		Bed savedInDb = bedDao.addBed(newBed);
		
		Bed getFromDb = entityManager.find(Bed.class, newBed.getBedId());
	
		assertThat(getFromDb.getBedSerialNumber()).isEqualTo(28);
		assertThat(getFromDb.geticuNumber()).isEqualTo(2);
		assertThat(getFromDb.isBedAvailability()).isTrue();
		assertThat(getFromDb).isEqualTo(savedInDb);
		
	}
	
	@Test
	public void testViewAllBedInfo() {
		
		Bed newBed = getBed();
		Bed savedInDb = entityManager.persist(newBed);
		
		List<Bed> getFromDb = bedDao.viewBedInfo();
	
		assertThat(getFromDb.get(0).getBedSerialNumber()).isEqualTo(28);
		assertThat(getFromDb.get(0).geticuNumber()).isEqualTo(2);
		assertThat(getFromDb.get(0).isBedAvailability()).isTrue();
		assertThat(getFromDb.get(0)).isEqualTo(savedInDb);
		
	}	
	
	@Test
	public void testFindBedById() {
		
		Bed newBed = getBed();
		Bed savedInDb = entityManager.persist(newBed);
		
		Bed getFromDb = bedDao.findBed(savedInDb.getBedId());
	
		
		assertThat(getFromDb).isEqualTo(savedInDb);
		
	}	
	
	@Test
	public void testViewBedByAvailability() {
		
		Bed newBed = getBed();
		Bed savedInDb = entityManager.persist(newBed);
		
		List<Bed> getFromDb = bedDao.viewBedInfoByAvailability(true);
	
		assertThat(getFromDb.get(0).isBedAvailability()).isTrue();
		assertThat(getFromDb.get(0)).isEqualTo(savedInDb);
		
	}	
	
	private Bed getBed() {
		Bed bed = new Bed();
		bed.setBedSerialNumber(28);
		bed.setBedAvailability(true);
		bed.setIcuNumber(2);
		entityManager.persist(bed);
		return bed;
	}
	
	
}

