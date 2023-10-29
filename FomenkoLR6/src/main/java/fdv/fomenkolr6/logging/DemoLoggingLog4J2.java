package fdv.fomenkolr6.logging;



import fdv.fomenkolr6.daosmartphones.DAOSmartphones;
import fdv.fomenkolr6.dbconnect.DBConnect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;

public class DemoLoggingLog4J2 {

    private static final Logger LOGGER = LogManager.getLogger(); //DemoLoggingLog4J2.class.getName()

    public static void main(String[] args) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        LOGGER.info("Hello, World!");
        LOGGER.debug("This Will Be Printed On Debug");
        LOGGER.info("This Will Be Printed On Info");
        LOGGER.warn("This Will Be Printed On Warn");
        LOGGER.error("This Will Be Printed On Error");
        LOGGER.fatal("This Will Be Printed On Fatal");

        LOGGER.info("Appending string: {}.", "Hello, World");
        System.out.println("Start logging...");
        Connection con = DBConnect.getConnectionMySQL();
        LOGGER.info("Connect to database ... OK");
        System.out.println("Connect to database ... OK!!!");
        System.out.println(DAOSmartphones.getSmartphoneList(con));
        LOGGER.info("SELECT ALL RECORDS");

    }

}
