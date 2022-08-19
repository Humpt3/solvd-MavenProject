package homework2.classes;

import homework2.interfaces.ITracing;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Origin implements ITracing {
    private static Logger logger = LogManager.getLogger(Origin.class);
    private int branchNumber;

    private int phoneNumber;
    private String location;

    public Origin() {
    }

    public Origin(int branchNumber, int phoneNumber, String location) {
        this.branchNumber = branchNumber;
        this.phoneNumber = phoneNumber;
        this.location = location;
    }

    public int getBranchNumber() {
        return branchNumber;
    }

    public void setBranchNumber(int branchNumber) {
        this.branchNumber = branchNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String originDetails() {
        return "Branch number: " + getBranchNumber() + " " + "Phone number: " + getPhoneNumber() + " " + "Location: " + getLocation();
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
