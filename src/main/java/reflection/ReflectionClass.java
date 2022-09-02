package reflection;

import homework2.classes.Employee;
import homework2.classes.Main;
import homework2.enums.TypeOfLicenses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


public class ReflectionClass {
    private static Logger logger = LogManager.getLogger(ReflectionClass.class);

    public static void main(String[] args) throws Exception{
        Employee hernesto = new Employee(TypeOfLicenses.B1, 20, "Hernesto Abrahan", true);

        // GETTING THE FIELDS NAME OF THE CLASS

        Field[] employeeFields = hernesto.getClass().getDeclaredFields();
        for (Field field : employeeFields) {
            logger.info("field of the class: " + field.getName());
        }


        // REPLACING THE NAME FIELD VALUE, FOR A NEW ONE
        for (Field field : employeeFields){
            if(field.getName().equals("name")){
                field.setAccessible(true);
                field.set(hernesto, "Lalo Salamanca");
            }
        }
        logger.info(hernesto.getName());


        // GETTING THE METHODS OF THE CLASS
        Method[] employeeMethods = hernesto.getClass().getDeclaredMethods();

        // CALLING AND REPLACING THE VALUE OF THE METHOD SETAVALIABLE
        for(Method method : employeeMethods){
            logger.info("Method Name: "+ method.getName());
            if(method.getName().equals("setAvaliable")) {
                method.invoke(hernesto, false);
            }
        }
        logger.info(hernesto.isAvaliable());


    }

    }
