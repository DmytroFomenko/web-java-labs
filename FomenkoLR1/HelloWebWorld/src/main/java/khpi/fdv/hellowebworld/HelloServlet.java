package khpi.fdv.hellowebworld;


import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Hello, WebWorld!!!</h1>");
        out.println("<h2>Fomenko D.V.</h2>");
        out.println("<h2>Ggroup: CS-720</h2>");
        out.println("<h2>Ggroup Number: 5</h2>");
        out.println("</body></html>");
    }
}