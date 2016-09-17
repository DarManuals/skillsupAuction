package com.su.auction;

import com.su.auction.service.AuctionService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by bogdan on 17.09.16.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:service-beans.xml");
        AuctionService service = (AuctionService) ctx.getBean("auctionSevice");
        System.out.println(service.getUsers().size() );
    }
}