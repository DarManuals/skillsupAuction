package com.su.auction.hiber;

import com.su.auction.dao.ItemDao;
import com.su.auction.dao.auction.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Bogdan Daragan on 15.10.16.
 */
@Component
public class ItemDaoImpl implements ItemDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Item> getAll() {
        return em.createQuery("select i from Item i").getResultList();
    }

    @Override
    @Transactional
    public void add(Item obj) {
        em.persist(obj);
    }

    @Override
    @Transactional
    public void remove(Item obj) {
        em.remove(obj);
    }
}
