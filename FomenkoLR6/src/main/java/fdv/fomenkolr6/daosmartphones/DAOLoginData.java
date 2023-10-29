package fdv.fomenkolr6.daosmartphones;


import fdv.fomenkolr6.model.LoginData;
import fdv.fomenkolr6.model.LoginDataList;
import fdv.fomenkolr6.model.Smartphone;

import java.sql.*;


public class DAOLoginData {
    // Data Access to objects of class of LoginData

    private static final String TABLE_NAME = "logindata";


    private static final String GET_PASSWORD_BY_LOGIN_SQL =
            "SELECT userpassword FROM " + TABLE_NAME + " WHERE userlogin=?";


    public static boolean checkPasswordByLogin(Connection con, String login, String enteredPassword) {
        try (PreparedStatement prst = con.prepareStatement(GET_PASSWORD_BY_LOGIN_SQL)) {
            prst.setString(1, login);

            ResultSet rs = prst.executeQuery();
            rs.next();

            String rightPassword = rs.getString("userpassword");

            if (enteredPassword.equals(rightPassword)) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            return false;
        }
    }
}
