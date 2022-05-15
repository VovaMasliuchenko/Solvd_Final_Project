package DAO.JDBCMySQL;

import DAO.IConnectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool implements IConnectionPool {

    private static ConnectionPool connectionPool = null;
    private final List<Connection> availableConnections;
    private final List<Connection> usedConnections = new ArrayList<>();
    private static final int INITIAL_POOL_SIZE = 10;

    private ConnectionPool(List<Connection> availableConnections) {
        this.availableConnections = availableConnections;
    }

    public static ConnectionPool getInstance(String url, String user, String password) throws SQLException {
        if (connectionPool == null) {
            List<Connection> connections = new ArrayList<>(INITIAL_POOL_SIZE);
            for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
                connections.add(createConnection(url, user, password));
            }
            connectionPool = new ConnectionPool(connections);
        }

        return connectionPool;
    }

    private static Connection createConnection(String url, String user, String password) throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public Connection getConnection() {
        Connection connection = availableConnections
                .remove(availableConnections.size() - 1);
        usedConnections.add(connection);
        return connection;
    }

    @Override
    public boolean releaseConnection(Connection connection) {
        availableConnections.add(connection);
        return usedConnections.remove(connection);
    }

    public int getSize() {
        return availableConnections.size() + usedConnections.size();
    }
}
