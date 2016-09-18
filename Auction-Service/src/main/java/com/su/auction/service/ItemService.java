package com.su.auction.service;

import com.su.auction.dao.auction.domain.Item;

import java.util.List;

/**
 * Created by bogdan on 18.09.16.
 */
public interface ItemService {
    List<Item> getAll();
    Item createItem(String title, String description);
}