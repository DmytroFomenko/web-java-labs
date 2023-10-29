package fdv.fomenkolr6.servlets;


import fdv.fomenkolr6.daosmartphones.DAOSmartphones;
import fdv.fomenkolr6.model.Smartphone;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static fdv.fomenkolr6.dbconnect.DBConnect.con;

@WebServlet(name = "SmartphoneRemoveServlet", value = "/SmartphoneRemoveServlet")
public class SmartphoneDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("error", null);
        String path = "/smartphoneModel.jsp";
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StringBuilder sbError = new StringBuilder();
        String modelStr = request.getParameter("model");

        String model = "";
        model = modelStr;
        if (!model.matches("[a-zA-Zа-яА-Я0-9]+(([ ][a-zA-Zа-яА-Я0-9]+)?)+")) {
            sbError.append("The model name cannot contain spaces at the beginning, at the end and more than one between words!!!");
        }

        try {
            if (sbError.length() == 0) {

                Smartphone smartForSeek = new Smartphone(-1, "emptyCompany", model, 0, 0.0);

                int id = DAOSmartphones.getIdByModel(con, smartForSeek);
                if (id != -1) {
                    if (DAOSmartphones.delete(con, id)) {
                        String path = request.getContextPath() + "/smartphones";
                        response.sendRedirect(path);
                    } else {
                        sbError.append("SQL query execute with mistake!!!");
                    }
                } else {
                    sbError.append("Smartphone with this model not found!!!");
                }
            }

            if (sbError.length() > 0) {
                request.setAttribute("error", sbError.toString());
                request.setAttribute("model", model);
                String path = "/smartphoneModel.jsp";
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





