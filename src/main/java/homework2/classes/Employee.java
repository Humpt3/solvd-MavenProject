package homework2.classes;

import homework2.enums.TypeOfLicenses;
import homework2.linkedlist.LinkedList;

public class Employee {
    private TypeOfLicenses license;

    private int yearsOfWork;
    private String name;
    private boolean isAvaliable;

    public Employee(TypeOfLicenses license, int yearsOfWork, String name, boolean isAvaliable) {
        this.license = license;
        this.yearsOfWork = yearsOfWork;
        this.name = name;
        this.isAvaliable = isAvaliable;

    }

    public TypeOfLicenses getLicense() {
        return license;
    }

    public void setLicense(TypeOfLicenses license) {
        license = license;
    }

    public void setYearsOfWork(int yearsOfWork) {
        this.yearsOfWork = yearsOfWork;
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

    public int getYearsOfWork() {
        return yearsOfWork;
    }

    public String employeeDetails(){
        return "Name: " + getName() + " " +" Amount of years working on the company: " + yearsOfWork+" "+ "Driver License: " + getLicense();

    }

}
