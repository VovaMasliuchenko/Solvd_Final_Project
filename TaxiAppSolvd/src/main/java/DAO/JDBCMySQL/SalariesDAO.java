package DAO.JDBCMySQL;

import DAO.IConnectionPool;
import DAO.ISalariesDAO;
import Entity.CarClasses;
import Entity.Salaries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalariesDAO implements ISalariesDAO {

    private static final Logger LOGGER = LogManager.getLogger(SalariesDAO.class);

    private IConnectionPool connectionPool;

    public SalariesDAO(IConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public void addEntity(Salaries salaries) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO SALARIES (id,salary) VALUES(?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, salaries.getId());
            preparedStatement.setInt(2, salaries.getSalary());
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
    public Salaries getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        Salaries salaries = null;

        try {
            String sql = "SELECT * FROM SALARIES WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            salaries = new Salaries(result.getInt("id"),
                                    result.getInt("salary"));
        } catch(SQLException ex) {
            LOGGER.error(ex.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return salaries;
    }

    @Override
    public List<Salaries> getAll() {
        List<Salaries> salariesList = new ArrayList<>();
        String sql = "SELECT * FROM SALARIES";
        Statement statement = null;
        Connection connection = connectionPool.getConnection();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Salaries salaries = new Salaries();
                salaries.setId(resultSet.getInt("id"));
                salaries.setSalary(resultSet.getInt("salary"));
                salariesList.add(salaries);
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
        return salariesList;
    }

    @Override
    public void updateEntity(Salaries salaries) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE SALARIES SET salary = ? WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, salaries.getSalary());
            preparedStatement.setInt(2, salaries.getId());
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
    public void deleteEntity(Salaries salaries) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM SALARIES WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, salaries.getId());
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
