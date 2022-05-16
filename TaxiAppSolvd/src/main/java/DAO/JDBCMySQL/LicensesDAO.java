package DAO.JDBCMySQL;

import DAO.InterfacesDAO.IConnectionPool;
import DAO.InterfacesDAO.ILicensesDAO;
import Entity.Licenses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class LicensesDAO implements ILicensesDAO {

    private static final Logger LOGGER = LogManager.getLogger(BonusesDAO.class);

    private IConnectionPool connectionPool;

    public LicensesDAO(IConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public void addEntity(Licenses licenses) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO LICENSES (id,license_number,expiration_date,Users_Id,Salary_Id,Ratings_Id) VALUES(?,?,?,?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, licenses.getId());
            preparedStatement.setString(2, licenses.getLicense_number());
            preparedStatement.setString(3, licenses.getExpiration_date());
            preparedStatement.setInt(4, licenses.getUsers_Id());
            preparedStatement.setInt(5, licenses.getSalary_Id());
            preparedStatement.setInt(6, licenses.getRatings_Id());
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
    public Licenses getEntityById(int id) {
        return null;
    }

    @Override
    public List<Licenses> getAll() {
        return null;
    }

    @Override
    public void updateEntity(Licenses licenses) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE LICENSES SET license_number = ?, expiration_date = ?, Users_Id = ?, Salary_Id = ?, Ratings_Id = ? WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, licenses.getLicense_number());
            preparedStatement.setString(2, licenses.getExpiration_date());
            preparedStatement.setInt(3, licenses.getUsers_Id());
            preparedStatement.setInt(4, licenses.getSalary_Id());
            preparedStatement.setInt(5, licenses.getRatings_Id());
            preparedStatement.setInt(6, licenses.getId());
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
    public void deleteEntity(Licenses licenses) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM LICENSES WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, licenses.getId());
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
