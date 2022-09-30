package fr.uge.jee;

import fr.uge.jee.bookstore.Library;
import fr.uge.jee.onlineshop.OnlineShop;
import fr.uge.jee.printers.CustomizableMessagePrinter;
import fr.uge.jee.printers.MessagePrinter;
import fr.uge.jee.printers.SimpleMessagePrinter;
import fr.uge.jee.printers.SlowConstructionMessagePrinter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config-printers.xml");

       /* var printer = (MessagePrinter) context.getBean("frenchPrinter");
        printer.printMessage();*/

        MessagePrinter printer = context.getBean("printerServiceCount",MessagePrinter.class);
        printer.printMessage();
        printer.printMessage();
        printer.printMessage();
        MessagePrinter printer2 =  context.getBean("printerServiceCount",MessagePrinter.class);
        printer2.printMessage();


        ApplicationContext bookContext = new ClassPathXmlApplicationContext("config-bookstore.xml");

        Library library = bookContext.getBean("library", Library.class);
        System.out.println(library);


        ApplicationContext shopContext = new ClassPathXmlApplicationContext("config-online.xml");

        OnlineShop onlineShop = shopContext.getBean("amazon", OnlineShop.class);
        onlineShop.printDescription();


        ApplicationContext shopContextV2 = new ClassPathXmlApplicationContext("config-onlineshopv2.xml");

        OnlineShop onlineShopv2 = shopContextV2.getBean("amazon", OnlineShop.class);
        onlineShopv2.printDescription();

        ApplicationContext shopContextV3 = new ClassPathXmlApplicationContext("config-onlineshopv3.xml");

        OnlineShop onlineShopv3 = shopContextV3.getBean(OnlineShop.class);
        onlineShopv3.printDescription();



    }
}