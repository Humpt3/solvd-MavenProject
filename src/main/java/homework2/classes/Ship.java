package homework2.classes;

import homework2.interfaces.IExtraCharge;
import homework2.linkedlist.LinkedList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Ship extends Transport implements IExtraCharge {

    private static Logger logger = LogManager.getLogger(Ship.class);

    public Ship(int model, String license, boolean isAvaliable) {
        super(model, license, isAvaliable);

    }

    @Override
    public void messageExtraCharge() {
        logger.info("This will have an extra charge of: $500");
    }

    @Override
    public double addExtraCharge() {
        return 500;
    }

    /* public double calculateCost(){
                        double tcost=0;
                        if(this.getKm() <= 1000){
                            tcost = getProduct().getCost() + 200;
                        }
                        return tcost;

                    }
                */
    @Override
    public void printData(Delivery delivery) {
        if(delivery.calculateKm() > 3000 && this.isAvaliable() == true){
            double fcost = delivery.finalCost() + this.addExtraCharge();
            this.messageExtraCharge();
            logger.info("Final cost its: " + fcost);
            logger.info("Delivery will be sent by a Ship, model: " + this.getModel() + " " + "license: " + this.getLicense());
        }

    }

    @Override
    public void transportsAvaliables(LinkedList<Transport> transports) {
        if(isAvaliable()== true){
            transports.add(this);
        }
    }

}


