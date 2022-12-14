package homework2.classes;

import homework2.enums.AllowedDestinations;
import homework2.enums.ProductCategory;
import homework2.enums.TypeOfLicenses;
import homework2.exceptions.SizeLimitException;
import homework2.linkedlist.LinkedList;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Consumer;


public class Main {
    private static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {


        // EMPLOYEES
        Employee ricardo = new Employee(TypeOfLicenses.B1,20, "Ricardo Monzón", true);
        Employee mauro = new Employee(TypeOfLicenses.C1,5, "Mauro Benavidez", false);
        Employee hugo = new Employee(TypeOfLicenses.G4,15, "Hugo Sosa", true);

        LinkedList<Employee> avaliableEmployees = new LinkedList<Employee>();

        // TRANSPORTS

        Transport car1 = new Car(213,true);
        Transport ship1 = new Ship(551, true);
        Transport truck1 = new Truck(131,  false);

        Product iphone = new Product("Iphone", ProductCategory.ELECTRONIC, 20, 30, 40, 50);
        Client jose = new Client("Jose", "Los cocos 5231", "4446894", false,iphone);
        Origin argentina = new Origin("Buenos Aires");
        Destination china = new Destination(AllowedDestinations.FRANCE, "París", "someStreet222", 5000);

        Delivery delivery1 = new Delivery(jose,argentina, china);

        LinkedList<Transport> avaliableTransports = new LinkedList<Transport>();

        Company company = new Company("Rappi", "Calle falsa 123", avaliableEmployees, avaliableTransports, delivery1);

        company.addEmployee(hugo);
        company.addEmployee(mauro);
        company.addEmployee(ricardo);

        company.addTransport(car1);
        company.addTransport(ship1);
        company.addTransport(truck1);

        delivery1.addAvaliableDriver(avaliableEmployees,ricardo);
        delivery1.addAvaliableDriver(avaliableEmployees, mauro);
        delivery1.addAvaliableDriver(avaliableEmployees, hugo);



        delivery1.addAvaliableTransport(avaliableTransports, car1);
        delivery1.addAvaliableTransport(avaliableTransports, truck1);
        delivery1.addAvaliableTransport(avaliableTransports, ship1);


        //streams
        company.showTransports();
        company.numberAvaliableTr();
        company.employeeNamesToUpperCase();
        company.nameMatchEmployee();
        company.listLicenses();


 try {
            Product.sizeValidation(iphone);
            company.printDetails();
            car1.printData(delivery1, ricardo);
            ship1.printData(delivery1, hugo);
            truck1.printData(delivery1, mauro);
        } catch (SizeLimitException e) {
            logger.info(e.getMessage());
        }
        delivery1.setStateDelivery("Shipped");


       // delivery2.setStateDelivery("Delivered");

        argentina.tracking(delivery1);

        // LAMBDAS

        logger.info("The amount of days avaliable for the employee: "+ ricardo.getName() + " " + "are :"+company.vacationsLambda(ricardo));
        logger.info("the approximate arrival date is in:  "+delivery1.lambdaArrivalDate(china)+" "+ "days");




        logger.info(ricardo.equals(mauro));
        logger.info(mauro.hashCode());
        logger.info(hugo.hashCode());


    }


}
