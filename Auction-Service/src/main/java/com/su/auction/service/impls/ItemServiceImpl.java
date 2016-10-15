package com.su.auction.service.impls;

import com.su.auction.dao.auction.domain.Item;
import com.su.auction.service.ItemService;
import com.su.auction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by bogdan on 18.09.16.
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemDao;

    @Override
    public List<Item> getAll() {
        return StreamSupport
                .stream(itemDao.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Item createItem(String title, String description) {
        Item item = new Item(null, title, description);
        return itemDao.save(item);
    }
}