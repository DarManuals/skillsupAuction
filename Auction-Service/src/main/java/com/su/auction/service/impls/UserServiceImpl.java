package com.su.auction.service.impls;

import com.su.auction.dao.UserDao;
import com.su.auction.dao.auction.domain.User;
import com.su.auction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bogdan on 18.09.16.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User createUser(String login, String firstName, String lastName) {
        User user = new User(null, login, firstName, lastName, null);
        userDao.add(user);
        return user;
    }
}