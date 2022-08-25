package homework2.classes;

import homework2.linkedlist.LinkedList;

public class Employee {
    private int License;
    private String name;
    private boolean isAvaliable;

    public Employee(int license, String name, boolean isAvaliable) {
        License = license;
        this.name = name;
        this.isAvaliable = isAvaliable;
    }

    public int getLicense() {
        return License;
    }

    public void setLicense(int license) {
        License = license;
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

    public void addAvaliableDriver(LinkedList linkedList){
        if(this.isAvaliable() == true){
            linkedList.add(this);
        }
    }


}
