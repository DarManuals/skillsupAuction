package com.su.auction.daoimpl;

import com.su.ItemDao;
import com.su.domain.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bogdan on 17.09.16.
 */
public class ItemDaoImpl implements ItemDao {

    private List<Item> items = new ArrayList<>();

    @Override
    public List<Item> getAll() {
        return items;
    }

    @Override
    public void add(Item obj) {
        items.add(obj);
    }

    @Override
    public void remove(Item obj) {
        items.remove(obj);
    }
}
