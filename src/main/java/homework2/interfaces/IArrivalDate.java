package homework2.interfaces;

import homework2.classes.Destination;

@FunctionalInterface
public interface IArrivalDate {
    public double dateOfArrival(Destination destination);
}
