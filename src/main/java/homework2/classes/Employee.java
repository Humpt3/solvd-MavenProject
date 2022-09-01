package homework2.classes;

import homework2.enums.TypeOfLicenses;
import homework2.linkedlist.LinkedList;

public class Employee {
    private TypeOfLicenses license;
    private String name;
    private boolean isAvaliable;

    public Employee(TypeOfLicenses license, String name, boolean isAvaliable) {
        this.license = license;
        this.name = name;
        this.isAvaliable = isAvaliable;
    }

    public TypeOfLicenses getLicense() {
        return license;
    }

    public void setLicense(TypeOfLicenses license) {
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
