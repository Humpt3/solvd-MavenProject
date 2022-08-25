package homework2.classes;

import homework2.linkedlist.LinkedList;

public class Company {
    private String name;
    private String Adress;
    private LinkedList<Employee> employees;
    private LinkedList<Transport> transports;

    public Company(String name, String adress, LinkedList<Employee> employees, LinkedList<Transport> transports) {
        this.name = name;
        Adress = adress;
        this.employees = employees;
        this.transports = transports;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    public LinkedList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(LinkedList<Employee> employees) {
        this.employees = employees;
    }

    public LinkedList<Transport> getTransports() {
        return transports;
    }

    public void setTransports(LinkedList<Transport> transports) {
        this.transports = transports;
    }
}
