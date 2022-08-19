package homework2.classes;

import homework2.exceptions.NameProductException;
import homework2.exceptions.SizeLimitException;
import homework2.exceptions.WeightLimitsException;

public class Product {

    private String nameProduct;
    private double width;
    private double length;
    private double height;
    private double weight;

    public Product() {

    }

    public Product(String nameProduct, double width, double length, double height, double weight) {
        this.nameProduct = nameProduct;
        this.width = width;
        this.length = length;
        this.height = height;
        this.weight = weight;

        try {
            Product.nameProductValidation(nameProduct);
        } catch (NameProductException e) {
            System.out.println(e.getMessage());
        }


        try {
            Product.weightValidation(weight);
        } catch (WeightLimitsException e) {
            System.out.println(e.getMessage());
        }

    }

    //setters
    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


    //getters
    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public double getWeight() {
        return weight;
    }


    public double sizeOfProduct() {
        double sup = this.getHeight() * this.getLength() * this.getWidth();
        return sup;

    }

    //method for exception

    public static void nameProductValidation(String nameProduct) throws NameProductException {
        if (nameProduct.length() > 20) {
            throw new NameProductException();
        }
    }

    public static void sizeValidation(Product product) throws SizeLimitException {
        product.sizeOfProduct();
        if (product.sizeOfProduct() > 100000) {
            throw new SizeLimitException();
        }

    }

    public static void weightValidation(double weight) throws WeightLimitsException {
        if (weight > 20000000) {
            throw new WeightLimitsException();
        }
    }
}
