package homework2.classes;

import homework2.interfaces.IExtraCharge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Car extends Transport implements IExtraCharge {

    private static Logger logger = LogManager.getLogger(Car.class);


    public Car(int model, String license) {
        super(model, license);

    }

    @Override
    public void messageExtraCharge() {
        logger.info("This will have an extra charge of: $50");
    }

    @Override
    public double addExtraCharge() {
        return 50;
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
    public void printData() {
        logger.info("Delivery will be sent by a car, model: " + this.getModel() + " " + "license: " + this.getLicense());
    }
}

