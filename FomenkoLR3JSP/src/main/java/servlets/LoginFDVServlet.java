package servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginFDV")
public class LoginFDVServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        //Get Parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("User (LoginServlet#doPOST) - " + username + " " + password);
        request.setAttribute("username", username);

        if ("user".equals(username) && "1".equals(password)) {
            String path = request.getContextPath() + "/main.jsp";
            response.sendRedirect(path);
        } else {
            String path = request.getContextPath() + "/.";
            response.sendRedirect(path);
        }
    }
}
