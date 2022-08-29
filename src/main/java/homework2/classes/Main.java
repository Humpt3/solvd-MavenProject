package homework2.classes;

import homework2.exceptions.SizeLimitException;
import homework2.linkedlist.LinkedList;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class Main {
    private static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {


        // EMPLOYEES
        Employee ricardo = new Employee(344141, "Ricardo Monzón", true);
        Employee mauro = new Employee(133124, "Mauro Benavidez", false);
        Employee hugo = new Employee(656464, "Hugo Sosa", true);

        LinkedList<Employee> avaliableEmployees = new LinkedList<Employee>();

        // TRANSPORTS

        Transport car1 = new Car(213,"CA2313", true);
        Transport ship1 = new Ship(551, "SH3313", true);
        Transport truck1 = new Truck(131, "TR331", false);

        LinkedList<Transport> avaliableTransports = new LinkedList<Transport>();


        Product iphone = new Product("Iphone", 20, 30, 40, 50);
        Client jose = new Client("Jose", "Los cocos 5231", "4446894", false,iphone);
        Origin argentina = new Origin(34000000, "Buenos Aires");
        Destination china = new Destination("China", "Shangai", "someStreet222", 5000);

        Delivery delivery1 = new Delivery(jose,argentina, china);

        delivery1.addAvaliableDriver(avaliableEmployees,ricardo);
        delivery1.addAvaliableDriver(avaliableEmployees, mauro);
        delivery1.addAvaliableDriver(avaliableEmployees, hugo);



        delivery1.addAvaliableTransport(avaliableTransports, car1);
        delivery1.addAvaliableTransport(avaliableTransports, truck1);
        delivery1.addAvaliableTransport(avaliableTransports, ship1);

        Company company = new Company("Rappi", "Calle falsa 123", avaliableEmployees, avaliableTransports, delivery1);


 try {
            Product.sizeValidation(iphone);
            company.printDetails();
            car1.printData(delivery1);
            ship1.printData(delivery1);
            truck1.printData(delivery1);
        } catch (SizeLimitException e) {
            logger.info(e.getMessage());
        }
        delivery1.setStateDelivery("Shipped");


       // delivery2.setStateDelivery("Delivered");

        argentina.tracking(delivery1);



        logger.info(ricardo.equals(mauro));
        logger.info(mauro.hashCode());
        logger.info(hugo.hashCode());


    }


}
