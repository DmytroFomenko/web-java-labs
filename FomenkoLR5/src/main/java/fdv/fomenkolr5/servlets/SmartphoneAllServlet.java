package fdv.fomenkolr5.servlets;


import fdv.fomenkolr5.daosmartphones.DAOSmartphones;
import fdv.fomenkolr5.dbconnect.DBConnect;
import fdv.fomenkolr5.model.SmartphoneList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
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
