package fdv.fomenkolr6.servlets;


import fdv.fomenkolr6.daosmartphones.DAOSmartphones;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static fdv.fomenkolr6.dbconnect.DBConnect.con;

@WebServlet(name = "SmartphoneRemoveButtonServlet", value = "/SmartphoneRemoveButtonServlet")
public class SmartphoneDeleteButtonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("error", null);
        String path = "/smartphones";
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StringBuilder sbError = new StringBuilder();

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            if (id != -1) {

                if (request.getParameter("deleteConfirm") != null) {
                    if (DAOSmartphones.delete(con, id)) {
                        String path = request.getContextPath() + "/smartphones";
                        response.sendRedirect(path);
                    } else {
                        sbError.append("SQL query execute with mistake!!!");
                    }
                } else {
                    sbError.append("Deletion not confirmed (check box) !!!");
                }
            } else {
                sbError.append("Smartphone with this model not found!!!");
            }

            if (sbError.length() > 0) {
                request.setAttribute("error", sbError.toString());
                String path = "/smartphones";
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





