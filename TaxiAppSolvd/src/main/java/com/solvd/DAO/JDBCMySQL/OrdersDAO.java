package com.solvd.DAO.JDBCMySQL;

import com.solvd.DAO.InterfacesDAO.IConnectionPool;
import com.solvd.DAO.InterfacesDAO.IOrdersDAO;
import com.solvd.Entity.Orders;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrdersDAO implements IOrdersDAO {

    private static final Logger LOGGER = LogManager.getLogger(BonusesDAO.class);

    private IConnectionPool connectionPool;

    public OrdersDAO(IConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public void addEntity(Orders orders) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO ORDERS (id,price,start_point,end_point,Licenses_Id,Users_Id) VALUES(?,?,?,?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, orders.getId());
            preparedStatement.setInt(2, orders.getPrice());
            preparedStatement.setString(3, orders.getStart_point());
            preparedStatement.setString(4, orders.getEnd_point());
            preparedStatement.setInt(5, orders.getLicenses_Id());
            preparedStatement.setInt(6, orders.getUsers_Id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e.getMessage());
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e.getMessage());
                }
            }
        }
    }

    @Override
    public Orders getEntityById(int id) {
        return null;
    }

    @Override
    public List<Orders> getAll() {
        return null;
    }

    @Override
    public void updateEntity(Orders orders) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE ORDERS SET price = ?, start_point = ?, end_point = ?,Licenses_Id = ?, Users_Id = ? WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, orders.getPrice());
            preparedStatement.setString(2, orders.getStart_point());
            preparedStatement.setString(3, orders.getEnd_point());
            preparedStatement.setInt(4, orders.getLicenses_Id());
            preparedStatement.setInt(5, orders.getUsers_Id());
            preparedStatement.setInt(6, orders.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e.getMessage());
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e.getMessage());
                }
            }
        }
    }

    @Override
    public void deleteEntity(Orders orders) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM ORDERS WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, orders.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e.getMessage());
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e.getMessage());
                }
            }
        }
    }
}
