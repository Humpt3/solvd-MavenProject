package homework2.classes;

import homework2.exceptions.SizeLimitException;
import homework2.linkedlist.LinkedList;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class Main {
    private static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {



        //products


        Product iphone = new Product("Iphone", 20, 30, 40, 50);
        Product macbook = new Product("Macbook", 20, 30, 40, 120);
        Product samsung = new Product("Galaxy S7", 30, 12, 12, 80);
        Product nokia = new Product("Nokia 1.3", 15, 15, 15, 60);
        Product hp = new Product("G7 250g", 50, 40, 30, 130);

        LinkedList phones = new LinkedList();
        LinkedList computers = new LinkedList();

        phones.add(iphone);
        phones.add(samsung);
        phones.add(nokia);
        phones.print();
        int countPhones = phones.getCount();
        logger.info("List Size: "+countPhones);

        computers.add(macbook);
        computers.add(hp);
        computers.print();
        int countComputers = computers.getCount();
        logger.info("List Size: "+countComputers);


        //Clients
        Client jose = new Client("Jose", "Los cocos 5231", "4446894", false,iphone);
        Client juan = new Client("Juan", "Los cocos 5321", "4462394", true, macbook);
        Client lucas = new Client("Lucas", "Fake street 123", "44434111", false, samsung);
        Client ibm = new Client("IBM", "1 Orchard Rd Armonk (HQ), NY", "+00013131554", true, hp);

        //Origins
        Origin argentina = new Origin(332, 543123, "Argentina");
        Origin argentina1 = new Origin(32, 5431233, "Argentina");
        Origin argentina2 = new Origin(132, 4413213, "Argentina");

        //Destinations
        Destination japan = new Destination("Japan", "Tokyo", "tokyostreet 222");
        Destination china = new Destination("China", "Shangai", "chinastreet 222");
        Destination russia = new Destination("Russia", "Saint petersburg", "The place where Rodion lives");

        LinkedList destinations = new LinkedList();
        destinations.add(japan);
        destinations.add(china);
        destinations.add(russia);
        destinations.print();

        int countDestinations = destinations.getCount();
        logger.info("List Size: "+countDestinations);


        Delivery delivery1 = new Delivery(200, jose, argentina, japan);
        Delivery delivery2 = new Delivery(1200, juan, argentina1, china);
        Delivery delivery3 = new Delivery(3500, ibm, argentina2, russia);


        delivery1.finalMethod();
        try {
            Product.sizeValidation(iphone);
            delivery1.finalCost();
        } catch (SizeLimitException e) {
            logger.info(e.getMessage());
        }

        delivery1.createTransport();

        delivery1.setStateDelivery("Shipped");

        delivery2.finalMethod();
        try {
            Product.sizeValidation(macbook);
            delivery2.finalCost();
        } catch (SizeLimitException e) {
            logger.info(e.getMessage());
        }
        delivery2.createTransport();

        delivery2.setStateDelivery("Delivered");

        argentina.tracking(delivery1);
        argentina1.tracking(delivery2);


        logger.info(juan.equals(jose));
        logger.info(juan.hashCode());
        logger.info(jose.hashCode());


    }


}
