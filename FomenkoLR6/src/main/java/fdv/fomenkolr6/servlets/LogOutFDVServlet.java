package fdv.fomenkolr6.servlets;


import fdv.fomenkolr6.logging.Log4j2;

import static fdv.fomenkolr6.dbconnect.DBConnect.con;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/logOutFDV")
public class LogOutFDVServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        con = null;

        HttpSession session = request.getSession();
        String nameInSession = (String) session.getAttribute("name");
        Log4j2.webAppLogger.info("User {} disconnected from database", nameInSession);

        session.invalidate();

        String path = request.getContextPath() + "/login.jsp";
        response.sendRedirect(path);
    }
}
