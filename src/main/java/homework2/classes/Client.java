package homework2.classes;

import homework2.exceptions.PhoneNumberException;
import homework2.linkedlist.LinkedList;

public class Client {
    private String name;
    private String adress;
    private String phone;
    private boolean isComercial;

    private Product product;


    public Client() {

    }

    public Client(String name, String adress, String phone, boolean isComercial, Product product) {
        this.name = name;
        this.adress = adress;
        this.phone = phone;
        this.isComercial = isComercial;
        this.product = product;

        try {
            Client.phoneNumbValidation(phone);
        } catch (PhoneNumberException e) {
            System.out.println(e.getMessage());
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setComercial(boolean comercial) {
        isComercial = comercial;
    }


    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public String getPhone() {
        return phone;
    }

    public Product getProduct() {
        return product;
    }

    public boolean getIsComercial() {
        return isComercial;
    }


    public String clientDetails() {
        return "Client name: '" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", phone=" + phone +
                ", is Comercial=" + isComercial +
                '}';
    }

    //method for exception

    public static void phoneNumbValidation(String phone) throws PhoneNumberException {
        if (phone.length() < 1 && phone.length() > 12) {
            throw new PhoneNumberException();

        }

    }

}
