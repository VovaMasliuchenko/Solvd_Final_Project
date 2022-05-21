package com.solvd;

import com.solvd.DAO.InterfacesDAO.*;
import com.solvd.DAO.JDBCMySQL.*;
import com.solvd.Entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import java.io.*;

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
            ICreditCardsDAO creditCardsDAO = new CreditCardsDAO(connectionPool);
            IPhoneNumbersDAO phoneNumbersDAO = new PhoneNumbersDAO(connectionPool);
            IHomeNumbersDAO homeNumbersDAO = new HomeNumbersDAO(connectionPool);
            IPaymentMethodsDAO paymentMethodsDAO = new PaymentMethodsDAO(connectionPool);
            ICarsDAO carsDAO = new CarsDAO(connectionPool);
            ICarOrdersDAO carOrdersDAO = new CarOrdersDAO(connectionPool);
            ILicensesDAO licensesDAO = new LicensesDAO(connectionPool);
            IOrdersDAO ordersDAO = new OrdersDAO(connectionPool);
            IRatingsDAO ratingsDAO = new RatingsDAO(connectionPool);

            CarClasses carClasses = new CarClasses();
            Bonuses bonuses = new Bonuses();
            CarServices carServices = new CarServices();
            Salaries salaries = new Salaries();
            UserGender userGender = new UserGender();
            UserAddress userAddress = new UserAddress();
            Users users = new Users();
            CreditCards creditCards = new CreditCards();
            PhoneNumbers phoneNumbers = new PhoneNumbers();
            HomeNumbers homeNumbers = new HomeNumbers();
            PaymentMethods paymentMethods = new PaymentMethods();
            Cars cars = new Cars();
            CarOrders carOrders = new CarOrders();
            Ratings ratings = new Ratings();
            Licenses licenses = new Licenses();
            Orders orders = new Orders();


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

            Object o = new Bonuses(1,"Winter bonus");
            OutputStream os = new FileOutputStream( "bonuses.xml" );

            marshaller.marshal(o, os);

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        } catch (JAXBException e) {
            System.out.println(e.getMessage());
        }

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Bonuses.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            InputStream xmlFileStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("bonuses.xml");

            Bonuses bonuses = (Bonuses) jaxbUnmarshaller.unmarshal(xmlFileStream);
            LOGGER.info('\n' + bonuses.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }
}
