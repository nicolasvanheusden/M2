package fr.uge.jee.annotations.onlineshop;

import fr.uge.jee.annotations.onlineshop.delivery.StandardDelivery;
import fr.uge.jee.annotations.onlineshop.insurance.ReturnInsurance;
import fr.uge.jee.annotations.onlineshop.insurance.ThiefInsurance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Set;

@Configuration
@ComponentScan
@PropertySource("classpath:onlineshop.properties")
public class Config {
//    @Bean
//    StandardDelivery standardDelivery() {
//        var standard = new StandardDelivery();
//        standard.setDelay(999);
//        return standard;
//    }
//
//    @Bean
//    ReturnInsurance returnInsurance() {
//        return new ReturnInsurance();
//    }
//
//    @Bean
//    ThiefInsurance thiefInsurance() {
//        return new ThiefInsurance();
//    }
//
//    @Bean
//    OnlineShop onlineShop() {
//        var shop = new OnlineShop();
//        shop.setName("Amazon");
//        shop.setDeliveryOptions(Set.of(standardDelivery()));
//        shop.setInsurances(Set.of(returnInsurance(), thiefInsurance()));
//        return shop;
//    }

}


