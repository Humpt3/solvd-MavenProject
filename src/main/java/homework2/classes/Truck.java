package homework2.classes;

import homework2.enums.TypeOfLicenses;
import homework2.interfaces.IExtraCharge;
import homework2.linkedlist.LinkedList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Truck extends Transport implements IExtraCharge {
    private static Logger logger = LogManager.getLogger(Truck.class);


    public Truck(int model, boolean isAvaliable) {
        super(model,isAvaliable);

    }


    @Override
    public void messageExtraCharge() {
        logger.info("This will have an extra charge of: $150");
    }

    @Override
    public double addExtraCharge() {
        return 150;
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
    public void printData(Delivery delivery, Employee employee) {
        if(delivery.calculateKm() > 1000 && delivery.calculateKm()< 3000 && this.isAvaliable() == true && (employee.getLicense() == TypeOfLicenses.C1)){
            double fcost = delivery.finalCost() + this.addExtraCharge();
            this.messageExtraCharge();
            logger.info("Final cost its: " + fcost);
            logger.info("Delivery will be sent by a Truck, model: " + this.getModel());
            logger.info("The Drivers name is: "+employee.getName() + " " + "License: "+employee.getLicense());

        }


    }

    @Override
    public void transportsAvaliables(LinkedList<Transport> transports) {
        if(isAvaliable()== true){
            transports.insert(this);
        }
    }
}


