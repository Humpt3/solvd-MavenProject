package homework2.classes;

import homework2.interfaces.IVacations;
import homework2.linkedlist.LinkedList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Company {
    private static Logger logger = LogManager.getLogger(Company.class);
    private String name;
    private String adress;

    private ArrayList<Employee> employees;
    private ArrayList<Transport> transports;

    private LinkedList<Employee> avaliableEmployees;
    private LinkedList<Transport> avaliableTransports;

    private Delivery delivery;

    public Company(String name, String adress, LinkedList<Employee> avaliableEmployees, LinkedList<Transport> avaliableTransports, Delivery delivery) {
        this.name = name;
        this.adress = adress;
        this.transports = new ArrayList<>();
        this.employees = new ArrayList<>();
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
        getAvaliableTransports().display();
        getAvaliableEmployees().display();

        delivery.deliveryDetails();

    }

    public void showTransports(){
        if(transports.isEmpty()){
            logger.info("There are no transports");
        }
        else {
            for(int i=0; i<transports.size();i++){
                logger.info(transports.get(i));
            }
        }

    }

    public void showEmployees(){
        if(employees.isEmpty()){
            logger.info("There are no employees");
        }
        else{
            for (int i = 0; i < employees.size(); i++) {
                logger.info(employees.get(i));

            }
        }
    }

    public void addTransport(Transport transport){
        transports.add(transport);
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    // streams
    public void numberAvaliableTr(){
        long count = transports.stream().filter(transport -> transport.isAvaliable()).count();
        logger.info(count+ " Number of transports avaliable for the delivery ");
    }

    public void employeeNamesToUpperCase(){
        List<String> names = new ArrayList<>();
        for (int i = 0; i < employees.size(); i++) {
            names.add(employees.get(i).getName());
        }
        names.stream().map(String::toUpperCase).forEach(System.out::println);
    }

    public void nameMatchEmployee(){
        boolean noSosa = employees.stream().noneMatch(employee -> employee.getName().equals("Hugo Sosa"));
        if(noSosa == true){
            logger.info("There is no employee with the name Hugo Sosa");
        }
        else{
            logger.info("There is one employee with that name");
        }

    }

    public void listLicenses(){
        List<String> listOfLicenses = employees.stream().map(employee -> employee.getLicense().getVehicule()).collect(Collectors.toList());
        logger.info("List of licenses: "+listOfLicenses);

    }





}
