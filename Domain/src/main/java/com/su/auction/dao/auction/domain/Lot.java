package com.su.auction.dao.auction.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by bogdan on 17.09.16.
 */
public class Lot {
    private Item item;
    private User owner;
    private BigDecimal startPrice;
    private Date datePlaced;
    private Date endDate;
    private User buyer;
    private BigDecimal currentPrice;
    private List<History> bidsHistory = new LinkedList<>();

    public Lot() {
    }

    public Lot(Item item, User owner, BigDecimal startPrice, Date datePlaced, User buyer, BigDecimal currentPrice) {
        this.item = item;
        this.owner = owner;
        this.startPrice = startPrice;
        this.datePlaced = datePlaced;
        this.buyer = buyer;
        this.currentPrice = currentPrice;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public BigDecimal getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(BigDecimal startPrice) {
        this.startPrice = startPrice;
    }

    public Date getDatePlaced() {
        return datePlaced;
    }

    public void setDatePlaced(Date datePlaced) {
        this.datePlaced = datePlaced;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lot lot = (Lot) o;

        if (item != null ? !item.equals(lot.item) : lot.item != null) return false;
        if (owner != null ? !owner.equals(lot.owner) : lot.owner != null) return false;
        if (startPrice != null ? !startPrice.equals(lot.startPrice) : lot.startPrice != null) return false;
        if (datePlaced != null ? !datePlaced.equals(lot.datePlaced) : lot.datePlaced != null) return false;
        if (endDate != null ? !endDate.equals(lot.endDate) : lot.endDate != null) return false;
        if (buyer != null ? !buyer.equals(lot.buyer) : lot.buyer != null) return false;
        return currentPrice != null ? currentPrice.equals(lot.currentPrice) : lot.currentPrice == null;

    }

    @Override
    public int hashCode() {
        int result = item != null ? item.hashCode() : 0;
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (startPrice != null ? startPrice.hashCode() : 0);
        result = 31 * result + (datePlaced != null ? datePlaced.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (buyer != null ? buyer.hashCode() : 0);
        result = 31 * result + (currentPrice != null ? currentPrice.hashCode() : 0);
        return result;
    }

    private class History {
        private User user;
        private BigDecimal price;

        public History(User user, BigDecimal price) {
            this.user = user;
            this.price = price;
        }

        @Override
        public String toString() {
            return "History{" +
                    "user=" + user.getLogin() +
                    ", price=" + price +
                    '}';
        }
    }

    public void addBidsHistory(User user, BigDecimal price) {
        this.bidsHistory.add(new History(user, price) );
    }

    public void showHistory(){

        System.out.println("--- Lot history: " + item.getTitle() + " ---" );

        for(int i = 0; i < bidsHistory.size(); i++){
            System.out.println(i + " - " + bidsHistory.get(i) );
        }
    }
}