package concurrency;

import homework2.classes.Company;
import homework3.RunnerClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;

public class Connection{

       private static Logger logger = LogManager.getLogger(Connection.class);


    public void infoConnection(String thread){
        logger.info(thread);
    }

    public void excecuteTask(String thread){
        logger.info(thread);
    }
    public void close(String thread){
        logger.info(thread);
    }



}
