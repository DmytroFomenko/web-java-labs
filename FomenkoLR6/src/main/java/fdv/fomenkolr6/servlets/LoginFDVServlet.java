package fdv.fomenkolr6.servlets;


import fdv.fomenkolr6.dbconnect.DBConnect;
import fdv.fomenkolr6.logging.Log4j2;

import static fdv.fomenkolr6.daosmartphones.DAOLoginData.*;
import static fdv.fomenkolr6.dbconnect.DBConnect.con;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;


@WebServlet("/loginFDV")
public class LoginFDVServlet extends HttpServlet {

    @Override
    public void init() {
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
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        init();
        //Get Parameters
        StringBuilder sbError = new StringBuilder();

        String username = request.getParameter("username");
        String password = request.getParameter("password");


        boolean logOK = checkPasswordByLogin(con, username, password);

        String path;
        if (logOK) {
            path = "/smartphones";
            Log4j2.webAppLogger.info("User {} connected to database", username);

            HttpSession session = request.getSession();

            //String nameInSession = (String) session.getAttribute("name");
            try {
                session.setAttribute("name", username);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            //response.sendRedirect(path);
        } else {
            sbError.append("Wrong username or password!!!");
            request.setAttribute("error", sbError.toString());
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            path = "/login.jsp";
        }
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }
}
