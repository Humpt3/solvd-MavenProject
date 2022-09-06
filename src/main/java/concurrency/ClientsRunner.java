package concurrency;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class ClientsRunner {
    private static final int FREE_POOL_TIMEOUT = 500;
    private static final int EXECUTE_TASK_TIMEOUT = 250;
    private static Logger logger = LogManager.getLogger(ClientsRunner.class);
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    public static void main(String[] args) {
        Runnable r = () -> {
            Thread currentThread = Thread.currentThread();
            String currentThreadName = currentThread.getName();

            try {
                Thread.sleep(1000);
                while (!CONNECTION_POOL.hasFreeConnections()) {
                    logger.info(currentThreadName + "in queue");
                    Thread.sleep(FREE_POOL_TIMEOUT);
                }
                createConnectionWithThreadName(currentThreadName);
            } catch (InterruptedException e) {
                logger.info(e.getMessage());
            }
        };
        run(r);
    }

    public static void createConnectionWithThreadName(String threadName) throws InterruptedException {
        Connection connection = CONNECTION_POOL.connection();
        connection.infoConnection(threadName);
        connection.excecuteTask(threadName);
        connection.close(threadName);

        Thread.sleep(EXECUTE_TASK_TIMEOUT);

        CONNECTION_POOL.disconnect(connection);
    }

    public static void run(Runnable r) {
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            threads.add(new Thread(r, "thread " + i));
            try {
                threads.get(i).sleep(2000);

            } catch (InterruptedException e) {
                logger.info(e.getMessage());
            }
            threads.get(i).start();
        }
    }

}
