package ntukhpi.semit.fdv.aboutauthor.aboutauthorservlets;


import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/index-servlet")
public class IndexServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //response.setContentType("text/html");

        RequestDispatcher view = request.getRequestDispatcher("index.html");
        view.forward(request, response);
    }

    public void destroy() {
    }
}
