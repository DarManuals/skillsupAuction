package com.su.auction;

import com.su.auction.service.AuctionService;
import com.su.auction.service.AuctionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by bogdan on 17.09.16.
 */
@Configuration
@ComponentScan(basePackages = "com.su")
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);
        AuctionService service = ctx.getBean(AuctionServiceImpl.class);

        System.out.println(service.getUsers().size() );
    }
}