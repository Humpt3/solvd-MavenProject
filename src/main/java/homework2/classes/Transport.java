package homework2.classes;

import homework2.linkedlist.LinkedList;

public abstract class Transport {
    private int model;
    private String license;

    private boolean isAvaliable;
    protected Delivery delivery;




    public Transport(int model, String license, Delivery delivery, boolean isAvaliable) {
        this.model = model;
        this.license = license;
        this.delivery = delivery;
        this.isAvaliable = isAvaliable;

    }

    public void setAvaliable(boolean avaliable) {
        isAvaliable = avaliable;
    }


    public boolean isAvaliable() {
        return isAvaliable;
    }

    public void setLicense(String license) {
        license = license;
    }

    public void setModel(int model) {
        this.model = model;
    }


    public String getLicense() {
        return license;
    }

    public int getModel() {
        return model;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public abstract void printData();

    public abstract void transportsAvaliables(LinkedList<Transport> transports);
}
