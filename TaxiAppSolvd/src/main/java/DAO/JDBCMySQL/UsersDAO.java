package DAO.JDBCMySQL;

import DAO.InterfacesDAO.IConnectionPool;
import DAO.InterfacesDAO.IUsersDAO;
import Entity.Users;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.List;

public class UsersDAO implements IUsersDAO {

    private static final Logger LOGGER = LogManager.getLogger(BonusesDAO.class);

    private IConnectionPool connectionPool;

    public UsersDAO(IConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public void addEntity(Users users) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO USERS (id,name,lastname,email,age,Users_Gender_id,Users_Address_id,Bonuses_id) VALUES(?,?,?,?,?,?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, users.getId());
            preparedStatement.setString(2, users.getName());
            preparedStatement.setString(3, users.getLastname());
            preparedStatement.setString(4, users.getEmail());
            preparedStatement.setInt(5, users.getAge());
            preparedStatement.setInt(6, users.getUser_Gender_Id());
            preparedStatement.setInt(7, users.getUser_Address_Id());
            preparedStatement.setInt(8, users.getBonuses_Id());
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
    public Users getEntityById(int id) {
        return null;
    }

    @Override
    public List<Users> getAll() {
        return null;
    }

    @Override
    public void updateEntity(Users users) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE USERS SET name = ?, lastname = ?, email = ?, age = ?, Users_Gender_id = ?, Users_Address_id = ?, Bonuses_id = ? WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, users.getName());
            preparedStatement.setString(2, users.getLastname());
            preparedStatement.setString(3, users.getEmail());
            preparedStatement.setInt(4, users.getAge());
            preparedStatement.setInt(5, users.getUser_Gender_Id());
            preparedStatement.setInt(6, users.getUser_Address_Id());
            preparedStatement.setInt(7, users.getBonuses_Id());
            preparedStatement.setInt(8, users.getId());
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
    public void deleteEntity(Users users) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM USERS WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, users.getId());
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

