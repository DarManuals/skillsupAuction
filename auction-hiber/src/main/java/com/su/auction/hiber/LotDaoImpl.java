package com.su.auction.hiber;

import com.su.auction.dao.LotDao;
import com.su.auction.dao.auction.domain.Lot;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Bogdan Daragan on 15.10.16.
 */
@Repository
public class LotDaoImpl implements LotDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Lot> getAll() {
        return em.createQuery("select l from Lot l").getResultList();
    }

    @Override
    @Transactional
    public void add(Lot obj) {
        em.persist(obj);
    }

    @Override
    public void remove(Lot obj) {
        em.remove(obj);
    }
}