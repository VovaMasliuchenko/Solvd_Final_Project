package Entity;

import DAO.*;
import DAO.JDBCMySQL.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import java.io.File;
import java.io.FileInputStream;

import java.sql.SQLException;
import java.util.List;
import java.util.Properties;


public class MainProgram {

    private static final Logger LOGGER = LogManager.getLogger(MainProgram.class);

    public static void main(String[] args) throws Exception {

        FileInputStream fileInputStream = new FileInputStream("D:\\University\\QA\\Solvd_Final_Project\\TaxiAppSolvd\\src\\main\\resources\\db.properties");
        Properties connectionInfo = new Properties();
        connectionInfo.load(fileInputStream);

        String DB_URL = connectionInfo.getProperty("db.url");
        String DB_USER = connectionInfo.getProperty("db.username");
        String DB_PASSWORD = connectionInfo.getProperty("db.password");

        try {
            IConnectionPool connectionPool = ConnectionPool.getInstance(DB_URL, DB_USER, DB_PASSWORD);

            IBonusesDAO bonusesDAO = new BonusesDAO(connectionPool);
            ICarClassesDAO carClassesDAO = new CarClassesDAO(connectionPool);
            ICarServicesDAO carServicesDAO = new CarServicesDAO(connectionPool);
            ISalariesDAO salariesDAO = new SalariesDAO(connectionPool);
            IUserGenderDAO userGenderDAO = new UserGenderDAO(connectionPool);
            IUserAddressesDAO userAddressesDAO = new UserAddressesDAO(connectionPool);
            IUsersDAO usersDAO = new UsersDAO(connectionPool);

            CarClasses carClasses = new CarClasses();
            Bonuses bonuses = new Bonuses();
            CarServices carServices = new CarServices();
            Salaries salaries = new Salaries();
            UserGender userGender = new UserGender();
            UserAddress userAddress = new UserAddress();
            Users users = new Users();

            LOGGER.info("-------------Requests-------------");

            LOGGER.info(carClassesDAO.getEntityById(1).toString());
            LOGGER.info(salariesDAO.getEntityById(1).toString());
            LOGGER.info(userAddressesDAO.getEntityById(1).toString());
            LOGGER.info(userGenderDAO.getEntityById(1).toString());
            LOGGER.info(bonusesDAO.getEntityById(2).toString());

            LOGGER.info("-------------Bonuses-------------");
            List<Bonuses> bonusesList = bonusesDAO.getAll();
            for(Bonuses b : bonusesList) {
                LOGGER.info(b);
            }

            LOGGER.info("-------------Car Classes-------------");
            List<CarClasses> carClassesList = carClassesDAO.getAll();
            for (CarClasses cc : carClassesList) {
                LOGGER.info(cc);
            }

            LOGGER.info("-------------Car Services-------------");
            List<CarServices> carServicesList = carServicesDAO.getAll();
            for (CarServices cs : carServicesList) {
                LOGGER.info(cs);
            }

            LOGGER.info("-------------Salaries-------------");
            List<Salaries> salariesList = salariesDAO.getAll();
            for (Salaries s : salariesList) {
                LOGGER.info(s);
            }

            LOGGER.info("-------------Gender List-------------");
            List<UserGender> userGenderList = userGenderDAO.getAll();
            for (UserGender ug : userGenderList) {
                LOGGER.info(ug);
            }

            LOGGER.info("-------------Address List-------------");
            List<UserAddress> userAddressList = userAddressesDAO.getAll();
            for (UserAddress ua : userAddressList) {
                LOGGER.info(ua);
            }

        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }

        IConnectionPool connectionPool = null;

        try {
            JAXBContext context = JAXBContext.newInstance(Bonuses.class);

            Marshaller marshaller = context.createMarshaller();

            marshaller.marshal(new Bonuses(1,"Summer bonus"), new File("src\\main\\resources\\bonuses.xml"));

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        } catch (JAXBException e) {
            System.out.println(e.getMessage());
        }


    }
}