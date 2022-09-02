package homework2.enums;

public enum ProductCategory {
    ELECTRONIC(4),
    TOOLS(20),
    JEWELERY(5),
    BOOKS(100),
    CLOTHES(100),
    ACCESORIES(100),
    OFFICE(5),
    INSTRUMENTS(5);

    private final int amountOfEachProductAllowed;

    ProductCategory(int amountOfEachProductAllowed){
        this.amountOfEachProductAllowed=amountOfEachProductAllowed;
    }

    public int getAmountOfEachProductAllowed() {
        return amountOfEachProductAllowed;
    }
}
