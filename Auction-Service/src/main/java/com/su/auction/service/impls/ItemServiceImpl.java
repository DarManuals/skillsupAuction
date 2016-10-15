package com.su.auction.service.impls;

import com.su.auction.dao.ItemDao;
import com.su.auction.dao.auction.domain.Item;
import com.su.auction.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bogdan on 18.09.16.
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDao itemDao;

    @Override
    public List<Item> getAll() {
        return itemDao.getAll();
    }

    @Override
    public Item createItem(String title, String description) {
        Item item = new Item(null, title, description);
        itemDao.add(item);
        return item;
    }
}