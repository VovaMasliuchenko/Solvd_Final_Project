package com.solvd.DAO.JDBCMySQL;

import com.solvd.DAO.InterfacesDAO.ICarServicesDAO;
import com.solvd.DAO.InterfacesDAO.IConnectionPool;
import com.solvd.Entity.CarServices;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarServicesDAO implements ICarServicesDAO {

    private static final Logger LOGGER = LogManager.getLogger(CarServicesDAO.class);

    private IConnectionPool connectionPool;

    public CarServicesDAO(IConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public void addEntity(CarServices carServices) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO CAR_SERVICES (id,service_name) VALUES(?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, carServices.getId());
            preparedStatement.setString(2, carServices.getService_name());
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
    public CarServices getEntityById(int id) {
        return null;
    }

    @Override
    public List<CarServices> getAll() {
        List<CarServices> carServicesList = new ArrayList<>();
        String sql = "SELECT * FROM CAR_SERVICES";
        Statement statement = null;
        Connection connection = connectionPool.getConnection();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                CarServices carServices = new CarServices();
                carServices.setId(resultSet.getInt("id"));
                carServices.setService_name(resultSet.getString("service_name"));
                carServicesList.add(carServices);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
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
        return carServicesList;
    }

    @Override
    public void updateEntity(CarServices carServices) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE CAR_SERVICES SET service_name = ? WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, carServices.getService_name());
            preparedStatement.setInt(2, carServices.getId());
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
    public void deleteEntity(CarServices carServices) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM CAR_SERVICES WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, carServices.getId());
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
