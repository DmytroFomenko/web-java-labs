package ntukhpi.semit.fdv.aboutauthor.aboutauthorservlets;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "redirectServlet", value = "/about-servlet")
public class AboutServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //response.setContentType("text/html");

        RequestDispatcher view = request.getRequestDispatcher("resume.html");
        view.forward(request, response);//.forward(, response);
    }

    public void destroy() {
    }
}
