package fdv.fomenkolr6.daosmartphones;


import fdv.fomenkolr6.logging.Log4j2;
import fdv.fomenkolr6.model.Smartphone;
import fdv.fomenkolr6.model.SmartphoneList;

import java.sql.*;

/**
 * @author Fomenko D.V.
 */
public class DAOSmartphones {
    // Data Access to objects of class of Smartphone

    private static final String TABLE_NAME = "priceofsmartphones";

    // Set of final String variables with SQL query text
    private static final String SELECT_SQL_TEXT =
            "SELECT * FROM " + TABLE_NAME;
    private static final String SELECT_ID_SQL_TEXT =
            "SELECT * FROM " + TABLE_NAME + " WHERE model=?";

    private static final String INSERT_SQL_TEXT =
            "INSERT INTO " + TABLE_NAME + " (company, model, performance, price) VALUES (?,?,?,?)";

    private static final String UPDATE_SQL_TEXT =
            "UPDATE " + TABLE_NAME + " SET company=?, model=?, performance=?, price=? WHERE (id = ?)";

    private static final String DELETE_ID_SQL_TEXT =
            "DELETE FROM " + TABLE_NAME + " WHERE (id = ?)";

    private static final String SELECT_COMPANY_SQL_TEXT =
            "SELECT * FROM " + TABLE_NAME + " WHERE company=?";


    /**
     * Method returned list of Smartphone get from DB table Smartphone
     *
     * @param con - instance of connecting to database
     * @return SmartphoneList (ArrayList<Smartphone>)
     */
    public static SmartphoneList getSmartphoneList(Connection con) {
        SmartphoneList smartList = new SmartphoneList();

        try (Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SELECT_SQL_TEXT)) {
            while (rs.next()) {
                Smartphone sm = new Smartphone();
                sm.setId(rs.getInt("ID"));
                sm.setCompany(rs.getString("COMPANY"));
                sm.setModel(rs.getString("MODEL"));
                sm.setPerformance(rs.getInt("PERFORMANCE"));
                sm.setPrice(rs.getDouble("PRICE"));

                smartList.add(sm);
            }
        } catch (SQLException e) {
            smartList = null;
        }
        return smartList;
    }

    public static SmartphoneList getFilteredSmartphoneList(Connection con, String companyFilter) {
        SmartphoneList smartList = new SmartphoneList();

        try (PreparedStatement prst = con.prepareStatement(SELECT_COMPANY_SQL_TEXT)) {
            prst.setString(1, companyFilter);

            ResultSet rs = prst.executeQuery();

            while (rs.next()) {
                Smartphone sm = new Smartphone();
                sm.setId(rs.getInt("ID"));
                sm.setCompany(rs.getString("COMPANY"));
                sm.setModel(rs.getString("MODEL"));
                sm.setPerformance(rs.getInt("PERFORMANCE"));
                sm.setPrice(rs.getDouble("PRICE"));

                smartList.add(sm);
            }
            rs.close();
        } catch (SQLException ex) {
            smartList = null;
        }
        return smartList;
    }

    /**
     * Method to find record id by name
     *
     * @param con            - instance of connecting to database
     * @param seekSmartphone - object with key field, specified value for looking in table
     * @return int value - id of found record or -1, record with specified name not it DB
     * or -102 if executing throw Exception
     */
    public static int getIdByModel(Connection con, Smartphone seekSmartphone) {
        int findId = -1;
        if (seekSmartphone != null) {
            try (PreparedStatement prst = con.prepareStatement(SELECT_ID_SQL_TEXT)) {
                prst.setString(1, seekSmartphone.getModel());

                ResultSet rs = prst.executeQuery();
                rs.next();

                if (rs.getRow() != 0) {
                    findId = rs.getInt("ID");
                } else {
                    findId = -1;
                }
                rs.close();
            } catch (SQLException ex) {
                findId = -102;
            }
        }
        return findId;
    }

    /**
     * Method to find smartphone data by model
     * @param con   - instance of connecting to database
     * @param seekSmartphone - object with key field, specified value for looking in table
     * @return Returns the string of data of smartphone
     */
    public static String getSmartphoneDataByModel(Connection con, Smartphone seekSmartphone) {

        int findId = -1;
        String findCompany = "";
        String findModel = "";
        int findPerformance = 0;
        double findPrice = 0;

        if (seekSmartphone != null) {
            try (PreparedStatement prst = con.prepareStatement(SELECT_ID_SQL_TEXT)) {
                prst.setString(1, seekSmartphone.getModel());

                ResultSet rs = prst.executeQuery();
                rs.next();

                if (rs.getRow() != 0) {
                    findId = rs.getInt("ID");
                    findCompany = rs.getString("company");
                    findModel = rs.getString("model");
                    findPerformance = rs.getInt("performance");
                    findPrice = rs.getDouble("price");
                } else {
                    findId = -1;
                }
                rs.close();
            } catch (SQLException ex) {
                findId = -102;
            }
        }
        return "[Smartphone " + findId + "] ---"
                + " Company: " + findCompany
                + " | Model: " + findModel
                + " | Performance: " + findPerformance + "% of the max"
                + " | Prise: " + findPrice + "$";
    }

    public static Smartphone getSmartphoneByModel(Connection con, String seekModel) {

        int findId = -1;
        String findCompany = "";
        String findModel = "";
        int findPerformance = 0;
        double findPrice = 0;

        Smartphone seekSmartphone = null;

        if (seekModel != null) {
            try (PreparedStatement prst = con.prepareStatement(SELECT_ID_SQL_TEXT)) {
                prst.setString(1, seekModel);

                ResultSet rs = prst.executeQuery();
                rs.next();

                if (rs.getRow() != 0) {
                    findId = rs.getInt("ID");
                    findCompany = rs.getString("company");
                    findModel = rs.getString("model");
                    findPerformance = rs.getInt("performance");
                    findPrice = rs.getDouble("price");
                    seekSmartphone = new Smartphone(findId, findCompany, findModel, findPerformance, findPrice);
                }
                rs.close();
            } catch (SQLException ex) {
                findId = -102;
            }
        }
        return seekSmartphone;
    }


    /**
     * Method to insert new record of Smartphone
     *
     * @param con           - instance of connecting to database
     * @param newSmartphone - instance of Employee for storing in table
     * @return boolean - true if record has been added, false - in other case
     */
    public static boolean insert(Connection con, Smartphone newSmartphone) {
        boolean insertOk = false;
        try (PreparedStatement prst = con.prepareStatement(INSERT_SQL_TEXT)) {
            prst.setString(1, newSmartphone.getCompany());
            prst.setString(2, newSmartphone.getModel());
            prst.setInt(3, newSmartphone.getPerformance());
            prst.setDouble(4, newSmartphone.getPrice());

            prst.execute();
            insertOk = true;
            Log4j2.webAppLogger.info("New Smartphone has been INSERTED into the table PriceOfSmartphones (key = model)");
        } catch (SQLException ex) {
            Log4j2.webAppLogger.error("ERROR: New Smartphone has NOT been INSERTED into the table PriceOfSmartphones (key = model)");
        }
        return insertOk;
    }

    /**
     * Method to update record of Smartphone with specified id
     *
     * @param con           - instance of connecting to database
     * @param id            - specified id
     * @param newSmartphone - instance of Employee for storing in table
     * @return boolean - true if record has been updated, false - in other case
     */
    public static boolean update(Connection con, int id, Smartphone newSmartphone) {
        boolean updateOk = false;
        if (id != -1) {
            try (PreparedStatement prst = con.prepareStatement(UPDATE_SQL_TEXT)) {
                prst.setString(1, newSmartphone.getCompany());
                prst.setString(2, newSmartphone.getModel());
                prst.setInt(3, newSmartphone.getPerformance());
                prst.setDouble(4, newSmartphone.getPrice());
                prst.setInt(5, id);

                prst.execute();
                updateOk = true;
                Log4j2.webAppLogger.info("Smartphone has been UPDATED from the table PriceOfSmartphones (key = model)");
            } catch (SQLException ex) {
                Log4j2.webAppLogger.error("ERROR: Smartphone has NOT been UPDATED from the table PriceOfSmartphones (key = model)");
            }
        }
        return updateOk;
    }

    /**
     * Method to delete record with specified id
     *
     * @param con - instance of connecting to database
     * @param id  - specified id
     * @return boolean - true if record has been updated, false - in other case
     */
    public static boolean delete(Connection con, int id) {
        boolean deleteOk = false;
        if (id != -1) {
            try (PreparedStatement prst = con.prepareStatement(DELETE_ID_SQL_TEXT)) {
                prst.setInt(1, id);

                prst.execute();
                deleteOk = true;
                Log4j2.webAppLogger.info("Smartphone has been DELETED from the table PriceOfSmartphones (key = model)");
            } catch (SQLException ex) {
                Log4j2.webAppLogger.error("ERROR: Smartphone has NOT been DELETED from the table PriceOfSmartphones (key = model)");
            }
        }
        return deleteOk;
    }
}
