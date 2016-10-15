package com.su.auction.service.impls;

import com.su.auction.dao.auction.domain.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Bogdan Daragan on 15.10.16.
 */
@Repository
interface ItemRepository extends CrudRepository<Item,Long> {
}