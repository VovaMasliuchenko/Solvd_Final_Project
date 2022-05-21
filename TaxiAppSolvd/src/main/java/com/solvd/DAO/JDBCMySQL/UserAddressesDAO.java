package com.solvd.DAO.JDBCMySQL;

import com.solvd.DAO.InterfacesDAO.IConnectionPool;
import com.solvd.DAO.InterfacesDAO.IUserAddressesDAO;
import com.solvd.Entity.UserAddress;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserAddressesDAO implements IUserAddressesDAO {

    private static final Logger LOGGER = LogManager.getLogger(BonusesDAO.class);

    private IConnectionPool connectionPool;

    public UserAddressesDAO(IConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public void addEntity(UserAddress userAddress) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO USERS_ADDRESS (id, address) VALUES(?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userAddress.getId());
            preparedStatement.setString(2, userAddress.getAddress());
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
    public UserAddress getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        UserAddress userAddress = null;

        try {
            String sql = "SELECT * FROM USERS_ADDRESS WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            userAddress = new UserAddress(result.getInt("id"),
                                          result.getString("address"));
        } catch(SQLException ex) {
            LOGGER.error(ex.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return userAddress;
    }

    @Override
    public List<UserAddress> getAll() {
        List<UserAddress> userAddressList = new ArrayList<>();
        String sql = "SELECT * FROM USERS_ADDRESS";
        Statement statement = null;
        Connection connection = connectionPool.getConnection();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                UserAddress userAddress = new UserAddress();
                userAddress.setId(resultSet.getInt("id"));
                userAddress.setAddress(resultSet.getString("address"));
                userAddressList.add(userAddress);
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
        return userAddressList;
    }

    @Override
    public void updateEntity(UserAddress userAddress) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE USERS_ADDRESS SET address = ? WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userAddress.getAddress());
            preparedStatement.setInt(2, userAddress.getId());
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
    public void deleteEntity(UserAddress userAddress) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM USERS_ADDRESS WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userAddress.getId());
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
