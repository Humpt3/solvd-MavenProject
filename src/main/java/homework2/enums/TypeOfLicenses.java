package homework2.enums;

public enum TypeOfLicenses {
    B1("cars"),
    B2("cars"),
    C1("truck"),
    C2("truck"),
    G4("ship");

    private final String vehicule;

    TypeOfLicenses(String vehicule){
        this.vehicule = vehicule;
    }

    public String getVehicule() {
        return vehicule;
    }
}
