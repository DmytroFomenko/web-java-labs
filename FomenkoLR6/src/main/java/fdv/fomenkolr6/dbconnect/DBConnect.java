package fdv.fomenkolr6.dbconnect;


import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnect {

    public static Connection con = null;

    public static Connection getConnectionMySQL() throws SQLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        String url = "jdbc:mysql://localhost";
        String databaseName = "fdv_smartphones";
        String options = "";//"?serverTimezone=Europe/Kiev&useSSL=false";
        String username = "root";
        String password = "root";
        String connectLink = url + "/" + databaseName + options;

        con = DriverManager.getConnection(connectLink, username, password);
        return con;
    }
}


