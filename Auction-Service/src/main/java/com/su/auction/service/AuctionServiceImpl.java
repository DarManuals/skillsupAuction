package com.su.auction.service;

import com.su.auction.dao.ItemDao;
import com.su.auction.dao.LotDao;
import com.su.auction.dao.UserDao;
import com.su.auction.dao.auction.domain.Item;
import com.su.auction.dao.auction.domain.Lot;
import com.su.auction.dao.auction.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by bogdan on 17.09.16.
 */
@Service
public class AuctionServiceImpl implements AuctionService {

    @Autowired
    private LotDao lotDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ItemDao itemDao;

    public void setLotDao(LotDao lotDao) {
        this.lotDao = lotDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setItemDao(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    @Override
    public Lot createLot(Item item, User user, BigDecimal startPrice) {
        return null;
    }

    @Override
    public List<Lot> getActiveLots() {
        return lotDao.getAll()
                .stream()
                .filter(lot -> lot.getEndDate() == null)
                .collect(Collectors.toList());
    }

    @Override
    public List<User> getUsers() {
        return userDao.getAll();
    }
}
