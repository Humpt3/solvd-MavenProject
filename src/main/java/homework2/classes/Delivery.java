package homework2.classes;


import homework2.exceptions.KmLimitException;
import homework2.linkedlist.LinkedList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Delivery {
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
            logger.info(origin.originDetails() + " " + destination.destinationDetails());

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
            linkedList.add(this);
        }
    }

    public void addAvaliableTransport(LinkedList linkedList, Transport transport){
        if(transport.isAvaliable() == true){
            linkedList.add(this);
        }
    }

}




   /* public void createTransport() {
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


    */











