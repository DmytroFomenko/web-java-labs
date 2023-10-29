package fdv.fomenkolr5.servlets;


import fdv.fomenkolr5.daosmartphones.DAOSmartphones;
import fdv.fomenkolr5.dbconnect.DBConnect;
import fdv.fomenkolr5.model.SmartphoneList;

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


@WebServlet("/SmartphoneFilterServlet")
public class SmartphoneFilterServlet extends HttpServlet {

    Connection con = null;

    @Override
    public void init() throws ServletException {
        try {
            con = DBConnect.getConnectionMySQL();
        } catch (SQLException |
                 IllegalAccessException |
                 InstantiationException |
                 InvocationTargetException |
                 NoSuchMethodException |
                 ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder sbError = new StringBuilder();
        String companyFilter = request.getParameter("companyFilter");


        String company = "";
        company = companyFilter;
        if (!company.matches("[a-zA-Zа-яА-Я0-9]+(([ ][a-zA-Zа-яА-Я0-9]+)?)+")) {
            sbError.append("The company name cannot contain spaces at the beginning, at the end and more than one between words!!!");
        }

        try {
            if (sbError.length() == 0) {

                SmartphoneList smartphoneList = DAOSmartphones.getFilteredSmartphoneList(con, companyFilter);
                if (!smartphoneList.isEmpty()) {
                    request.setAttribute("smartphones", smartphoneList);
                    request.setAttribute("companyFilter", companyFilter);
                    String path = "/smartphones.jsp";
                    ServletContext servletContext = getServletContext();
                    RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
                    requestDispatcher.forward(request, response);
                } else {
                    sbError.append("No smartphone from company " + companyFilter + " !!!");
                }
            }
            if (sbError.length() > 0) {
                request.setAttribute("error", sbError.toString());
                request.setAttribute("companyFilter", companyFilter);
                String path = "/smartphones.jsp";
                ServletContext servletContext = getServletContext();
                RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
                requestDispatcher.forward(request, response);
            }
        } catch (IOException |
                 ServletException e) {
            throw new RuntimeException(e);
        }
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
