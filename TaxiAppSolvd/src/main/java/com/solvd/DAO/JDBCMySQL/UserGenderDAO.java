package com.solvd.DAO.JDBCMySQL;

import com.solvd.DAO.InterfacesDAO.IConnectionPool;
import com.solvd.DAO.InterfacesDAO.IUserGenderDAO;
import com.solvd.Entity.UserGender;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserGenderDAO implements IUserGenderDAO {

    private static final Logger LOGGER = LogManager.getLogger(UserGenderDAO.class);

    private IConnectionPool connectionPool;

    public UserGenderDAO(IConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public void addEntity(UserGender userGender) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO USERS_GENDER (id,gender) VALUES(?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userGender.getId());
            preparedStatement.setString(2, userGender.getGender());
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
    public UserGender getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        UserGender userGender = null;

        try {
            String sql = "SELECT * FROM USERS_GENDER WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            userGender = new UserGender(result.getInt("id"),
                                        result.getString("gender"));
        } catch(SQLException ex) {
            LOGGER.error(ex.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return userGender;
    }

    @Override
    public List<UserGender> getAll() {
        List<UserGender> userGenderList = new ArrayList<>();
        String sql = "SELECT * FROM USERs_GENDER";
        Statement statement = null;
        Connection connection = connectionPool.getConnection();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                UserGender userGender = new UserGender();
                userGender.setId(resultSet.getInt("id"));
                userGender.setGender(resultSet.getString("gender"));
                userGenderList.add(userGender);
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
        return userGenderList;
    }

    @Override
    public void updateEntity(UserGender userGender) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE USERS_GENDER SET gender = ? WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userGender.getGender());
            preparedStatement.setInt(2, userGender.getId());
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
    public void deleteEntity(UserGender userGender) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM USERS_GENDER WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userGender.getId());
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
