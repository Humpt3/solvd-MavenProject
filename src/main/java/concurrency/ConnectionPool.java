package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ForkJoinWorkerThread;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {

    private static final int THREADS_LIMIT = 5;

    private static ConnectionPool instance;

    private List<Connection> connectionPool;

    private List<Connection> usedConnections = new ArrayList<>(THREADS_LIMIT);

    public ConnectionPool(){
        connectionPool = new ArrayList<>(THREADS_LIMIT);

        for (int i = 0; i < THREADS_LIMIT; i++) {
            connectionPool.add(new Connection());

        }

    }

    public static ConnectionPool getInstance(){
        if(instance == null){
            instance = new ConnectionPool();
        }
        return instance;
    }

    public boolean hasFreeConnections(){
        return !connectionPool.isEmpty();
    }
    public synchronized Connection connection(){
        if(connectionPool.isEmpty() || usedConnections.size() > THREADS_LIMIT){
            throw new RuntimeException("No avaliable connections! ");
        }

        Connection connection = connectionPool.remove(connectionPool.size() - 1);
        usedConnections.add(connection);
        return connection;
    }

    public synchronized boolean disconnect(Connection connection){
        connectionPool.add(connection);
        return usedConnections.remove(connection);
    }
 }
