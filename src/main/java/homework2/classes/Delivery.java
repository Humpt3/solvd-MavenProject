package homework2.classes;


import homework2.exceptions.KmLimitException;
import homework2.interfaces.IArrivalDate;
import homework2.linkedlist.LinkedList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Delivery{
    private static Logger logger = LogManager.getLogger(Delivery.class);

    private Origin origin;
    private Destination destination;
    private Client client;

    private String stateDelivery;




    public Delivery() {

    }

    public Delivery(Client client, Origin origin, Destination destination) {
        this.client = client;
        this.origin = origin;
        this.destination = destination;


        try {
            Delivery.kmValidation(destination);
        } catch (KmLimitException e) {
            logger.info(e.getMessage());
        }

    }



    public void setStateDelivery(String stateDelivery) {
        this.stateDelivery = stateDelivery;
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



    public Destination getDestination() {
        return destination;
    }





    public final void deliveryDetails(){
                    logger.info("******DETAILS OF THE DELIVERY******");
            logger.info(client.clientDetails());
            logger.info(client.getProduct().productDetails());
            logger.info("Origin: "+origin.originDetails() + " " + "Destination: " + destination.destinationDetails());

        }


    public double finalCost() {

                double cost = client.getProduct().getWeight() * client.getProduct().sizeOfProduct();

                if (client.getIsComercial() == true && client.getProduct().getWeight() > 1000) {
                    cost = cost - cost * 0.2;
                    logger.info("The total cost its: $" + cost + " " + "It has a discount of %20");
                    return cost;

                } else if (client.getIsComercial() == false && client.getProduct().getWeight() > 1000) {
                    cost = cost - cost * 0.1;
                    logger.info("The total cost its: $" + cost + " " + "It has a discount of %10");
                    return cost;

                } else {
                    logger.info("The total cost its: $" + cost + " " + "It has no discount");
                    return cost;
                }
            }


    public double calculateKm(){
        return destination.getKm();
    }




    // method for exception

    public static void kmValidation(Destination destination) throws KmLimitException {
        /*if (destination.getKm() > 10000) {
            throw new CustomException("allowed kilometers exceeded");
        }*/

        if (destination.getKm() < 1) {
            throw new KmLimitException();
        }
    }

    public void addAvaliableDriver(LinkedList linkedList, Employee employee){
        if(employee.isAvaliable() == true){
            linkedList.insert(employee);
        }
    }

    public void addAvaliableTransport(LinkedList linkedList, Transport transport){
        if(transport.isAvaliable() == true){
            linkedList.insert(transport);
        }
    }

    public double arrivalDate(Destination destination, IArrivalDate arrivalDate){
        return arrivalDate.dateOfArrival(destination);
    }

    public double lambdaArrivalDate(Destination destination){
        return this.arrivalDate(destination, (d -> (d.getKm() * 0.2 + 10)));
    }






}












