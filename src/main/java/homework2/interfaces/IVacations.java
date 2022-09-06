package homework2.interfaces;

import homework2.classes.Employee;

@FunctionalInterface
public interface IVacations {

     public int vacationsBasedOnYearsOfWork(Employee employee);
}
