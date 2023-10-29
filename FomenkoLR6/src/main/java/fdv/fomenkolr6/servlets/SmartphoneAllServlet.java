package fdv.fomenkolr6.servlets;


import fdv.fomenkolr6.daosmartphones.DAOSmartphones;
import fdv.fomenkolr6.dbconnect.DBConnect;
import fdv.fomenkolr6.model.SmartphoneList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;


@WebServlet("/smartphones")
public class SmartphoneAllServlet extends HttpServlet {

    Connection con = null;

    @Override
    public void init() throws ServletException {
        try {
            con = DBConnect.getConnectionMySQL();
        } catch (SQLException |
                 ClassNotFoundException |
                 NoSuchMethodException |
                 InvocationTargetException |
                 InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SmartphoneList smartphoneList = DAOSmartphones.getSmartphoneList(con);
        request.setAttribute("smartphones", smartphoneList);

        String path = "/smartphones.jsp";
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public void destroy() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
