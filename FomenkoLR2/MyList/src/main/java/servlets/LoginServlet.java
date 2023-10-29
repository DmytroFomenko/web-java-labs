package servlets;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        //Get Parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("User (LoginServlet#doPOST) - " + username + " " + password);
        request.setAttribute("username", username);

        PrintWriter out = response.getWriter();
        if ("admin".equals(username) && "111".equals(password)) {
            String tableContext = "/data";
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(tableContext);
            dispatcher.forward(request, response);
        } else {
            String path = request.getContextPath() + "/.";
            response.sendRedirect(path);
        }
    }

    public void destroy() {
    }
}