package com.su.auction.daoimpl;

import com.su.auction.dao.UserDao;
import com.su.auction.dao.auction.domain.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bogdan on 17.09.16.
 */
@Component
public class UserDaoImpl implements UserDao {

    private List<User> users = new ArrayList<>();

    @PostConstruct
    public void genarateUser(){
        users.add(new User("jonny", "John", "Smith"));
        users.add(new User("tommy", "Tom", "Tompson"));
        users.add(new User("aron", "Aron", "White"));
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public void add(User obj) {
        users.add(obj);
    }

    @Override
    public void remove(User obj) {
        users.remove(obj);
    }
}
