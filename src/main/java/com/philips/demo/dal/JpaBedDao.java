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
	public Bed addBed(Bed bedEntity) {
		em.persist(bedEntity);
		return bedEntity;
	}

	@Override
	public List<Bed> viewBedInfo() {
		
        return GenericUtils.castList(Bed.class, em.createQuery("select b from Bed b").getResultList());
	}

	@Override
	public List<Bed> viewBedInfoByAvailability(Boolean bedAvailability) {
		return GenericUtils.castList(Bed.class,em.createQuery("select b  from Bed b where b.bedAvailability = :paramId").setParameter("paramId", bedAvailability).getResultList());
	}

	
	@Override
	public void removeBedInfo(Bed bedEntity) {
		em.remove(bedEntity);
	}

	@Override
	public Bed findBed(Integer bedId) {
		 return em.find(Bed.class, bedId);
	}
	
}
