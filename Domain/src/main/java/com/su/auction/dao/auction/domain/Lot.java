package com.su.auction.dao.auction.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by bogdan on 17.09.16.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Lot {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Item item;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    private BigDecimal startPrice;
    private Date datePlaced;
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private User buyer;

    private BigDecimal currentPrice;

    /*@Transient
    private List<String> bidsHistory = new LinkedList<>();

    public void addBidsHistory(User user, BigDecimal price) {
        bidsHistory.add(bidsHistory.size() + ". History for [" + getItem().getTitle() + "]: " +
                user.getLogin() + " set price $" + price.toString() );
    }

    public List<String> getBidsHistory() {
        return bidsHistory;
    }*/
}