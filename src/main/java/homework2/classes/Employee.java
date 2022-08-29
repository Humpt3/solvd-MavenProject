package homework2.classes;

import homework2.linkedlist.LinkedList;

public class Employee {
    private int license;
    private String name;
    private boolean isAvaliable;

    public Employee(int license, String name, boolean isAvaliable) {
        this.license = license;
        this.name = name;
        this.isAvaliable = isAvaliable;
    }

    public int getLicense() {
        return license;
    }

    public void setLicense(int license) {
        license = license;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvaliable() {
        return isAvaliable;
    }

    public void setAvaliable(boolean avaliable) {
        isAvaliable = avaliable;
    }


    public String employeeDetails(){
        return "Name: " + getName() + " " + "Driver License: " + getLicense();
    }

}
