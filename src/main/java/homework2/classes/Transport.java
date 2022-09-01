package homework2.classes;

import homework2.linkedlist.LinkedList;

public abstract class Transport {
    private int model;

    private boolean isAvaliable;





    public Transport(int model, boolean isAvaliable) {
        this.model = model;
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




    public int getModel() {
        return model;
    }



    public abstract void printData(Delivery delivery, Employee employee);

    public abstract void transportsAvaliables(LinkedList<Transport> transports);
}
