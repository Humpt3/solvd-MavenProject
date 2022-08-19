package homework2.exceptions;

public class KmLimitException extends Exception {

    public KmLimitException() {
        super("The distance is less than the minimum required");

    }


}
