package com.su.auction.service.impls;


import com.su.auction.dao.auction.domain.Lot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface LotRepository extends CrudRepository<Lot, Long> {
}