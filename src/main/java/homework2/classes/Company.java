package homework2.classes;

import homework2.linkedlist.LinkedList;

public class Company {
    private String name;
    private String adress;

    private LinkedList<Employee> avaliableEmployees;
    private LinkedList<Transport> avaliableTransports;

    private Delivery delivery;

    public Company(String name, String adress, LinkedList<Employee> avaliableEmployees, LinkedList<Transport> avaliableTransports, Delivery delivery) {
        this.name = name;
        this.adress = adress;
        this.avaliableEmployees=avaliableEmployees;
        this.avaliableTransports = avaliableTransports;
        this.delivery=delivery;
    }


    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public LinkedList<Employee> getAvaliableEmployees() {
        return avaliableEmployees;
    }

    public void setEmployees(LinkedList<Employee> employees) {
        this.avaliableEmployees = employees;
    }

    public LinkedList<Transport> getAvaliableTransports() {
        return avaliableTransports;
    }

    public void setTransports(LinkedList<Transport> transports) {
        this.avaliableTransports = transports;
    }

    public void printDetails(){
        getAvaliableTransports().print();
        getAvaliableEmployees().print();

        delivery.deliveryDetails();




    }
}
