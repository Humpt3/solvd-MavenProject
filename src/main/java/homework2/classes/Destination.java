package homework2.classes;

import homework2.interfaces.ITracing;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Destination implements ITracing {
    private static Logger logger = LogManager.getLogger(Destination.class);
    private String country;
    private String city;
    private String adress;

    public Destination() {
    }

    public Destination(String country, String city, String adress) {
        this.country = country;
        this.city = city;
        this.adress = adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAdress() {
        return adress;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String destinationDetails() {
        return "Adress: " + getAdress() + " " + "City: " + getCity() + " " + "Country: " + getCountry();
    }

    @Override
    public void tracking(Delivery delivery) {
        if (delivery.getStateDelivery() == "Delivered") {
            logger.info("The product has been Delivered");
        } else {
            logger.info("The product has not yet arrived");
        }
    }
}
