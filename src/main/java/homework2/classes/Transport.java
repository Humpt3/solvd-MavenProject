package homework2.classes;

public abstract class Transport {
    private int model;
    private String license;


    public Transport(int model, String license) {
        this.model = model;
        this.license = license;

    }


    public void setLicense(String license) {
        license = license;
    }

    public void setModel(int model) {
        this.model = model;
    }


    public String getLicense() {
        return license;
    }

    public int getModel() {
        return model;
    }


    public abstract void printData();
}
