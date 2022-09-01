package homework2.classes;

import homework2.enums.AllowedDestinations;
import homework2.interfaces.ITracing;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Destination implements ITracing {
    private static Logger logger = LogManager.getLogger(Destination.class);
    private AllowedDestinations country;
    private String city;
    private String adress;

    private double km;

    public Destination() {
    }

    public Destination(AllowedDestinations country, String city, String adress, double km) {
        this.country = country;
        this.city = city;
        this.adress = adress;
        this.km=km;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(AllowedDestinations country) {
        this.country = country;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public String getAdress() {
        return adress;
    }

    public String getCity() {
        return city;
    }

    public AllowedDestinations getCountry() {
        return country;
    };

    public double getKm() {
        return km;
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
