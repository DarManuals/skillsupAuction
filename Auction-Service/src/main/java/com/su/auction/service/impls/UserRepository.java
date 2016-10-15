package com.su.auction.service.impls;


import com.su.auction.dao.auction.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface UserRepository extends CrudRepository<User,Long> {
}