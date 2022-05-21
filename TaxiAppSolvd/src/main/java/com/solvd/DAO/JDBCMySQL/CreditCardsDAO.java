package com.solvd.DAO.JDBCMySQL;

import com.solvd.DAO.InterfacesDAO.IConnectionPool;
import com.solvd.DAO.InterfacesDAO.ICreditCardsDAO;
import com.solvd.Entity.CreditCards;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CreditCardsDAO implements ICreditCardsDAO {

    private static final Logger LOGGER = LogManager.getLogger(BonusesDAO.class);

    private IConnectionPool connectionPool;

    public CreditCardsDAO(IConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public void addEntity(CreditCards creditCards) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO CREDIT_CARDS (id,card_number,created_day,code_CVV,Users_Id) VALUES(?,?,?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, creditCards.getId());
            preparedStatement.setString(2, creditCards.getCard_number());
            preparedStatement.setString(3, creditCards.getCreated_day());
            preparedStatement.setInt(4, creditCards.getCode_CVV());
            preparedStatement.setInt(5, creditCards.getUsers_Id());
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
    public CreditCards getEntityById(int id) {
        return null;
    }

    @Override
    public List<CreditCards> getAll() {
        return null;
    }

    @Override
    public void updateEntity(CreditCards creditCards) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE CREDIT_CARDS SET card_number = ?, created_day = ?, code_CVV = ?, Users_Id = ? WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, creditCards.getCard_number());
            preparedStatement.setString(2, creditCards.getCreated_day());
            preparedStatement.setInt(3, creditCards.getCode_CVV());
            preparedStatement.setInt(4, creditCards.getUsers_Id());
            preparedStatement.setInt(5, creditCards.getId());
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
    public void deleteEntity(CreditCards creditCards) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM CREDIT_CARDS WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, creditCards.getId());
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
