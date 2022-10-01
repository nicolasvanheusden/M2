package fr.uge.jee.annotations.onlineshop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        var shop = applicationContext.getBean(OnlineShop.class);
        shop.printDescription();

    }
}
