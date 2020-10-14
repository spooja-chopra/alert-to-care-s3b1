package com.philips.demo.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.philips.demo.domain.Bed;
import com.philips.demo.utils.GenericUtils;

@Transactional
@Repository
public class JpaBedDao implements BedDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Bed addBed(Bed bEntity) {
		em.persist(bEntity);
		return bEntity;
	}

	@Override
	public List<Bed> viewBedInfo() {
		
        return GenericUtils.castList(Bed.class, em.createQuery("select b from Bed b").getResultList());
	}

	@Override
	public List<Bed> viewBedInfoByICU(Integer ICU_Number) {
		return GenericUtils.castList(Bed.class,em.createQuery("select b from Bed b where b.ICUNumber = :paramId").setParameter("paramId", ICU_Number).getResultList());
	}

	@Override
	public List<Bed> viewBedInfoByAvailability(Boolean bed_Availability) {
		return GenericUtils.castList(Bed.class,em.createQuery("select b  from Bed b where b.bedAvailability = :paramId").setParameter("paramId", bed_Availability).getResultList());
	}

	
	@Override
	public void removeBedInfo(Bed bEntity) {
		em.remove(bEntity);
	}

	@Override
	public Bed findBed(Integer b_ID) {
		 return em.find(Bed.class, b_ID);
	}
	
}
