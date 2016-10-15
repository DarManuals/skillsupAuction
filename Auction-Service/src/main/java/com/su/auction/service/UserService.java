package com.su.auction.service;

import com.su.auction.dao.auction.domain.Item;
import com.su.auction.dao.auction.domain.Lot;
import com.su.auction.dao.auction.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bogdan on 18.09.16.
 */
public interface UserService {
    List<User> getAll();
    User createUser(String login, String firstName, String lastName);
}