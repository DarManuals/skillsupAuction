package com.su.auction.service;

import com.su.auction.dao.auction.domain.Item;
import com.su.auction.dao.auction.domain.Lot;
import com.su.auction.dao.auction.domain.User;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by bogdan on 17.09.16.
 */
public interface AuctionService {

    Lot createLot(Item item, User user, BigDecimal startPrice);
    List<Lot> getActiveLots();
    List<User> getUsers();
    void placeBid(Lot lot, User buyer);
    void placeBid(Lot lot, BigDecimal newPrice, User buyer);
    Lot closeLot(Lot lot);
    List<String> getLotBidsHistory(Lot lot);
}