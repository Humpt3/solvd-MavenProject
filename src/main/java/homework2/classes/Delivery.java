package homework2.classes;


import homework2.exceptions.KmLimitException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;

public class Delivery {
    private static Logger logger = LogManager.getLogger(Delivery.class);

    private Origin origin;
    private Destination destination;
    private double km;
    private Client client;

    private Transport transport;
    private String stateDelivery;


    public Delivery() {

    }

    public Delivery(double km, Client client, Origin origin, Destination destination) {
        this.km = km;
        this.client = client;
        this.origin = origin;
        this.destination = destination;


        try {
            Delivery.kmValidation(km);
        } catch (KmLimitException e) {
            logger.info(e.getMessage());
        }

    }


    public void setKm(double km) {
        this.km = km;
    }


    public void setStateDelivery(String stateDelivery) {
        this.stateDelivery = stateDelivery;
    }


    public double getKm() {
        return km;
    }

    public String getStateDelivery() {
        return stateDelivery;
    }

    public Origin getOrigin() {
        return origin;
    }

    public Client getClient() {
        return client;
    }

    public Transport getTransport() {
        return transport;
    }

    public Destination getDestination() {
        return destination;
    }





    public final void finalMethod() {
                    logger.info("******DETAILS OF THE DELIVERY******");
            logger.info(this.getClient().clientDetails());
            logger.info(this.getOrigin().originDetails() + " " + this.getDestination().destinationDetails());

        }


    public double finalCost() {

                double cost = this.getClient().getProduct().getWeight() * this.getClient().getProduct().sizeOfProduct();

                if (this.getClient().getIsComercial() == true && this.getClient().getProduct().getWeight() > 1000) {
                    cost = cost - cost * 0.2;
                    logger.info("The total cost its: $" + cost + " " + "It has a discount of %20");
                    return cost;

                } else if (this.getClient().getIsComercial() == false && this.getClient().getProduct().getWeight() > 1000) {
                    cost = cost - cost * 0.1;
                    logger.info("The total cost its: $" + cost + " " + "It has a discount of %10");
                    return cost;

                } else {
                    logger.info("The total cost its: $" + cost + " " + "It has no discount");
                    return cost;
                }
            }



    public void createTransport() {
        if (this.getKm() < 1000) {
            Car car1 = new Car(1984, "GD3SDQ");
           this.setStateDelivery("shipped");
            car1.printData();
            double fcost = finalCost() + car1.addExtraCharge();
            car1.messageExtraCharge();
            logger.info("Final cost its: " + fcost);

        } else if (this.getKm() > 1000 && this.getKm() < 3000) {
            Truck truck1 = new Truck(1988, "HE3GG3");
            this.setStateDelivery("shipped");
            truck1.printData();
            double fcost = finalCost() + truck1.addExtraCharge();
            truck1.messageExtraCharge();
            logger.info("Final cost its: " + fcost);
        } else {
            Ship ship1 = new Ship(2001, "EEE33B5");
            this.setStateDelivery("shipped");
            ship1.printData();
            double fcost = finalCost() + ship1.addExtraCharge();
            ship1.messageExtraCharge();
            logger.info("Final cost its: " + fcost);
        }
    }









    // method for exception

    public static void kmValidation(double km) throws KmLimitException {
      /*  if (delivery.getKm() > 10000) {
            throw new CustomException("allowed kilometers exceeded");
        }*/

        if (km < 1) {
            throw new KmLimitException();
        }
    }

}










