package DAO.JDBCMySQL;

import DAO.ICarClassesDAO;
import DAO.IConnectionPool;
import Entity.Bonuses;
import Entity.CarClasses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarClassesDAO implements ICarClassesDAO {

    private static final Logger LOGGER = LogManager.getLogger(CarClassesDAO.class);

    private IConnectionPool connectionPool;

    public CarClassesDAO(IConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public void addEntity(CarClasses carClasses) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO CAR_CLASS (id,car_class) VALUES(?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, carClasses.getId());
            preparedStatement.setString(2, carClasses.getCar_class());
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
    public CarClasses getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        CarClasses carClasses = null;

        try {
            String sql = "SELECT * FROM CAR_CLASS WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            carClasses = new CarClasses(result.getInt("id"),
                                        result.getString("car_class"));
        } catch(SQLException ex) {
            LOGGER.error(ex.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return carClasses;
    }

    @Override
    public List<CarClasses> getAll() {
        List<CarClasses> carClassesList = new ArrayList<>();
        String sql = "SELECT * FROM CAR_CLASS";
        Statement statement = null;
        Connection connection = connectionPool.getConnection();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                CarClasses carClasses = new CarClasses();
                carClasses.setId(resultSet.getInt("id"));
                carClasses.setCar_class(resultSet.getString("car_class"));
                carClassesList.add(carClasses);
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
        return carClassesList;
    }

    @Override
    public void updateEntity(CarClasses carClasses) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE CAR_CLASS SET car_class = ? WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, carClasses.getCar_class());
            preparedStatement.setInt(2, carClasses.getId());
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
    public void deleteEntity(CarClasses carClasses) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM CAR_CLASS WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, carClasses.getId());
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
