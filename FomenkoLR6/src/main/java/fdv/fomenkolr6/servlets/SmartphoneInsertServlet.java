package fdv.fomenkolr6.servlets;


import fdv.fomenkolr6.daosmartphones.DAOSmartphones;
import fdv.fomenkolr6.dbconnect.DBConnect;
import fdv.fomenkolr6.model.Smartphone;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;


@WebServlet("/addSmartphone")
public class SmartphoneInsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("error", null);
        String path = "/smartphone.jsp";
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StringBuilder sbError = new StringBuilder();
        String companyStr = request.getParameter("company");
        String modelStr = request.getParameter("model");
        String performanceStr = request.getParameter("performance");
        String priceStr = request.getParameter("price");

        String company = "";
        company = companyStr;
        if (!company.matches("[a-zA-Zа-яА-Я0-9]+(([ ][a-zA-Zа-яА-Я0-9]+)?)+")) {
            sbError.append("The company name cannot contain spaces at the beginning, at the end and more than one between words!!!");
        }

        String model = "";
        model = modelStr;
        if (!model.matches("[a-zA-Zа-яА-Я0-9]+(([ ][a-zA-Zа-яА-Я0-9]+)?)+")) {
            sbError.append("The model name cannot contain spaces at the beginning, at the end and more than one between words!!!");
        }


        int performance = -1;
        try {
            performance = Integer.parseInt(performanceStr);
            if (performance < 0 || performance > 100) {
                sbError.append("The performance must be between 0 and 100 (% of the maximum existing)!!!");
            }
        } catch (NumberFormatException ex) {
            sbError.append("The performance must be an integer number!!!");
        }

        double price = -1.0;
        try {
            price = Double.parseDouble(priceStr);
            if (price < 0) {
                sbError.append("The price cannot be negative!!!");
            }
        } catch (NumberFormatException ex) {
            sbError.append("The price must be a double number!!!");
        }

        if (sbError.length() == 0) {
            Smartphone newSmart = new Smartphone(-1, company, model, performance, price);
            try {
                if (DAOSmartphones.insert(DBConnect.getConnectionMySQL(), newSmart)) {
                    String path = request.getContextPath() + "/smartphones";
                    response.sendRedirect(path);
                } else {
                    sbError.append("Smartphone with the same MODEL consists in database!!!");
                }
            } catch (SQLException |
                     IllegalAccessException |
                     InstantiationException |
                     InvocationTargetException |
                     NoSuchMethodException |
                     ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        try {

            if (sbError.length() > 0) {
                request.setAttribute("error", sbError.toString());
                request.setAttribute("company", company);
                request.setAttribute("model", model);
                request.setAttribute("performance", performance);
                request.setAttribute("price", price);

                String path = "/smartphone.jsp";
                ServletContext servletContext = getServletContext();
                RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
                requestDispatcher.forward(request, response);
            }
        } catch (IOException |
                 ServletException e) {
            throw new RuntimeException(e);
        }
    }
}
