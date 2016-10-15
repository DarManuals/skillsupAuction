package com.su.auction.service.impls;

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
import java.util.stream.StreamSupport;

/**
 * Created by bogdan on 17.09.16.
 */
@Service
public class AuctionServiceImpl implements AuctionService {

    @Autowired
    private LotRepository lotRepository;
    @Autowired
    private UserRepository userDao;
    @Autowired
    private ItemRepository itemDao;

    @Override
    public Lot createLot(Item item, User user, BigDecimal startPrice) {
        Lot lot = new Lot(null, item, user, startPrice, new Date(), null, null, startPrice);
        return lotRepository.save(lot);
    }

    @Override
    public List<Lot> getActiveLots() {

        return StreamSupport.stream(lotRepository.findAll().spliterator(), false)
                .filter(lot -> lot.getEndDate() == null)
                .collect(Collectors.toList());
    }

    @Override
    public List<User> getUsers() {
        return StreamSupport
                .stream(userDao.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public void placeBid(Lot lot, User user) {
        lot.setCurrentPrice(lot.getCurrentPrice().add(BigDecimal.ONE) );
        lot.setBuyer(user);
        /*lot.addBidsHistory(user, lot.getCurrentPrice() );*/
    }

    @Override
    public void placeBid(Lot lot, BigDecimal newPrice, User user) {
        lot.setCurrentPrice(newPrice);
        lot.setBuyer(user);
        //lot.addBidsHistory(user, newPrice);
    }

    @Override
    public Lot closeLot(Lot lot) {
        lot.setEndDate(new Date());
        return lot;
    }

    /*@Override
    public List<String> getLotBidsHistory(Lot lot) {
        return lot.getBidsHistory();
    }*/
}