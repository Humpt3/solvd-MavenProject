package homework2.classes;

import homework2.linkedlist.LinkedList;

public abstract class Transport {
    private int model;
    private String license;

    private boolean isAvaliable;





    public Transport(int model, String license,boolean isAvaliable) {
        this.model = model;
        this.license = license;
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



    public abstract void printData(Delivery delivery);

    public abstract void transportsAvaliables(LinkedList<Transport> transports);
}
