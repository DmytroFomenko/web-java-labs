package fdv.fomenkolr5.servlets;


import fdv.fomenkolr5.daosmartphones.DAOSmartphones;
import fdv.fomenkolr5.dbconnect.DBConnect;
import fdv.fomenkolr5.model.Smartphone;


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
import java.util.Objects;


@WebServlet("/SmartphoneEditButtonServlet")
public class SmartphoneUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        String company = request.getParameter("company");
        String model = request.getParameter("model");
        String performance = request.getParameter("performance");
        String price = request.getParameter("price");

        request.setAttribute("id", id);
        request.setAttribute("error", null);

        request.setAttribute("company", company);
        request.setAttribute("model", model);
        request.setAttribute("performance", performance);
        request.setAttribute("price", price);

        String path = "/smartphoneEdit.jsp";
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Update!!!");

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


        int id = Integer.parseInt(request.getParameter("id"));

        if (sbError.length() == 0) {
            Smartphone updateDataSmartphone = new Smartphone(-1, company, model, performance, price);
            try {
                if (DAOSmartphones.update(DBConnect.getConnectionMySQL(), id, updateDataSmartphone)) {
                    String path = request.getContextPath() + "/smartphones";
                    response.sendRedirect(path);
                } else {
                    sbError.append("Smartphone with the same MODEL exists in database!!!");
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
                request.setAttribute("id", id);
                request.setAttribute("company", company);
                request.setAttribute("model", model);
                request.setAttribute("performance", performance);
                request.setAttribute("price", price);

                String path = "/smartphoneEdit.jsp";
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






