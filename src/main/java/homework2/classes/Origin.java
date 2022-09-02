package homework2.classes;

import homework2.interfaces.ITracing;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Origin implements ITracing {
    private static Logger logger = LogManager.getLogger(Origin.class);

    private String location;

    public final static double km = 0;

    public Origin() {
    }

    public Origin(String location) {

        this.location = location;
    }






    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String originDetails() {
        return "Location: " + getLocation();
    }

    @Override
    public void tracking(Delivery delivery) {
        if (delivery.getStateDelivery() == "Shipped") {
            logger.info("The product has been Shipped");
        } else {
            logger.info("The product has not yet been shipped");
        }
    }
}
