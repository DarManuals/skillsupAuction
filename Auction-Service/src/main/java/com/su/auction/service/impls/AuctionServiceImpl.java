package com.su.auction.service.impls;

import com.su.auction.dao.ItemDao;
import com.su.auction.dao.LotDao;
import com.su.auction.dao.UserDao;
import com.su.auction.dao.auction.domain.Item;
import com.su.auction.dao.auction.domain.Lot;
import com.su.auction.dao.auction.domain.User;
import com.su.auction.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
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

    @Override
    public Lot createLot(Item item, User user, BigDecimal startPrice) {
        Lot lot = new Lot(item, user, startPrice, new Date(), null, startPrice);
        lotDao.add(lot);
        return lot;
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

    @Override
    public void placeBid(Lot lot, User user) {
        lot.setCurrentPrice(lot.getCurrentPrice().add(BigDecimal.ONE) );
        lot.setBuyer(user);
        lot.addBidsHistory(user, lot.getCurrentPrice() );
    }

    @Override
    public void placeBid(Lot lot, BigDecimal newPrice, User user) {
        lot.setCurrentPrice(newPrice);
        lot.setBuyer(user);
        lot.addBidsHistory(user, newPrice);
    }

    @Override
    public Lot closeLot(Lot lot) {
        lot.setEndDate(new Date());
        return lot;
    }
}