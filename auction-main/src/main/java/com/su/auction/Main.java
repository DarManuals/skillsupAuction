package com.su.auction;

import com.su.auction.dao.auction.domain.Item;
import com.su.auction.dao.auction.domain.Lot;
import com.su.auction.dao.auction.domain.User;
import com.su.auction.service.AuctionService;
import com.su.auction.service.ItemService;
import com.su.auction.service.UserService;
import com.su.auction.service.impls.AuctionServiceImpl;
import com.su.auction.service.impls.ItemServiceImpl;
import com.su.auction.service.impls.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.stream.IntStream;

/**
 * Created by bogdan on 17.09.16.
 */
@Configuration
@ComponentScan(basePackages = "com.su")
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);
        AuctionService auctionService = ctx.getBean(AuctionServiceImpl.class);
        UserService userService =ctx.getBean(UserServiceImpl.class);
        ItemService itemService = ctx.getBean(ItemServiceImpl.class);

        User jonny = userService.createUser("jonny", "John", "Smith");
        User tommy = userService.createUser("tommy", "Tom", "Tompson");
        User arny = userService.createUser("arny", "Arnold", "Shwarz");

        Item one = itemService.createItem("kettle", "Goot staff for boiling some water");
        Item two = itemService.createItem("pen", "IPen is the best pen");

        Lot lot = auctionService.createLot(one, jonny, BigDecimal.ONE);
        auctionService.placeBid(lot, tommy);
        auctionService.placeBid(lot, BigDecimal.TEN, arny);
        auctionService.placeBid(lot, tommy);

        Lot closed = auctionService.closeLot(lot);
        System.out.println("Lot \'" + closed.getItem().getTitle() + "\' is closed. Best price is $" +
        lot.getCurrentPrice() + " by " + closed.getBuyer().getFirstName() + ". Lot closed on " +
                new SimpleDateFormat("dd.MM.yyyy 'at' HH:mm:ss").format(closed.getEndDate()) );

        lot.getBidsHistory().stream().forEach(h -> System.out.println(h));
    }
}