package fdv.fomenkolr6.filters;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.LogRecord;


//@WebFilter("/AuthorisationFilter")
public class AuthorisationFilter implements Filter {
    private ServletContext context;

    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        this.context.log("AuthenticationFilter initialized");
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession(false);

        HttpServletResponse res = (HttpServletResponse) response;
        String uri = req.getRequestURI();
        this.context.log("Requested Resource: " + uri);
        this.context.log("Path: " + req.getContextPath());


        if (!(uri.endsWith(req.getContextPath() + "/login.jsp")
                || uri.endsWith(req.getContextPath() + "/login.jsp")
                || uri.endsWith("loginFDV"))
                && ((session == null)
                || (session.getAttribute("name") == null))) {
            //session.setAttribute("error", "Not allowed do anything without login!!!");
            this.context.log("Not allowed without login (denied uri)!!!");
            res.sendRedirect(req.getContextPath() + "/login.jsp");
        } else {
            chain.doFilter(request, response);
        }
    }


    public void destroy() {
    }
}
