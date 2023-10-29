package khpi.fdv.fomenkolr4.servlets;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;


@WebServlet("/FormattingServlet")
public class FormattingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        Date dateTime = new Date();
        double h = 100.7;
        double d = 265;
        double eu = 306.5;

        request.setAttribute("dateTime", dateTime);
        request.setAttribute("uah", h);
        request.setAttribute("dollar", d);
        request.setAttribute("euro", eu);

        String path = "/formatting.jsp";
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
