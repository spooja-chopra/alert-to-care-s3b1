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
    EntityManager em;

    @Override
    public Bed addBed(Bed bed) {
        em.persist(bed);
        return bed;
    }

    @Override
    public List<Bed> findAll() {
        return GenericUtils.castList(Bed.class, em.createQuery("select b from bed b").getResultList());
    }

    @Override
    public Bed findBed(int bedId) {
        return em.find(Bed.class, bedId);
    }

    @Override
    public void deleteBed(int bedId) { // deleting a bed and updating the list of beds in ICU
        em.createQuery("delete from Bed b where b.bedId = :paramId").setParameter("paramId", bedId).executeUpdate();
    }
	
}
