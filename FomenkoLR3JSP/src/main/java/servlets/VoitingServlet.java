package servlets;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


@WebServlet("/voiting")
public class VoitingServlet extends HttpServlet {
    Map<String, Integer> res;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        res = new java.util.TreeMap<String, Integer>();
        res.put("Java", 12);
        res.put("Mobile", 10);
        res.put("Python", 2);
        request.setAttribute("results", res);

        String path = "/voiting_free.jsp";
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        for (Map.Entry<String, Integer> e : res.entrySet()) {
            int value = e.getValue();
            String nameLang = e.getKey();

            if (request.getParameter(nameLang) != null) {
                res.put(nameLang, ++value);
            }
        }
        request.setAttribute("results", res);
        String path = "/results.jsp";
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }
}
