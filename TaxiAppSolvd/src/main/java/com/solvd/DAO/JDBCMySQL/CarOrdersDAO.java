package com.solvd.DAO.JDBCMySQL;

import com.solvd.DAO.InterfacesDAO.ICarOrdersDAO;
import com.solvd.DAO.InterfacesDAO.IConnectionPool;
import com.solvd.Entity.CarOrders;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CarOrdersDAO implements ICarOrdersDAO {

    private static final Logger LOGGER = LogManager.getLogger(BonusesDAO.class);

    private IConnectionPool connectionPool;

    public CarOrdersDAO(IConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public void addEntity(CarOrders carOrders) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO CAR_ORDERS (id,price,Cars_Id,Car_Services_Id) VALUES(?,?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, carOrders.getId());
            preparedStatement.setInt(2, carOrders.getPrice());
            preparedStatement.setInt(3, carOrders.getCars_Id());
            preparedStatement.setInt(4, carOrders.getCar_Services_Id());
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
    public CarOrders getEntityById(int id) {
        return null;
    }

    @Override
    public List<CarOrders> getAll() {
        return null;
    }

    @Override
    public void updateEntity(CarOrders carOrders) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE CAR_ORDERS SET price = ?, Cars_Id = ?, Car_Services_Id = ? WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, carOrders.getPrice());
            preparedStatement.setInt(2, carOrders.getCars_Id());
            preparedStatement.setInt(3, carOrders.getCar_Services_Id());
            preparedStatement.setInt(4, carOrders.getId());
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
    public void deleteEntity(CarOrders carOrders) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM CAR_ORDERS WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, carOrders.getId());
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
