package com.su.auction.hiber;

import com.su.auction.dao.UserDao;
import com.su.auction.dao.auction.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Bogdan Daragan on 15.10.16.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getAll() {
        return em.createQuery("select u from User u").getResultList();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void add(User obj) {
        em.persist(obj);
    }

    @Override
    @Transactional
    public void remove(User obj) {
        em.remove(obj);
    }
}