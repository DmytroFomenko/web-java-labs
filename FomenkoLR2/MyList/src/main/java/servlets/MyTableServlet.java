package servlets;


import model.Smartphone;
import model.SmartphoneSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashSet;

@WebServlet(name = "MyTableServlet", value = "/data")
public class MyTableServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Object usernameData = request.getAttribute("username");
        System.out.println(usernameData);
        SmartphoneSet s1 = new SmartphoneSet();

        out.println("<html><body>");
        out.println("<style> table, th, td {border:1px solid black;</style>");
        out.println("<body bgcolor=\"#f2feff\">");
        out.println("<br><br><br><br>");
        out.println("<table border-style=\"solid\" align=\"center\">\n" +
                            "<tr bgcolor=\"#e4e0ff\">\n" +
                            "<th> Name of smartphone </th>\n" +
                            "<th>Processor </th>\n" +
                            "<th> Performance, % </th>\n" +
                            "<th> Price, $ </th>" +
                            "</tr>");

        for (Smartphone s : s1) {
            out.println("<tr><td>" + s.name + "</td>" +
                                "<td>" + s.processor + "</td>" +
                                "<td align=\"center\">" + s.getPerformance() + "</td>" +
                                "<td align=\"center\">" + s.getPrice() + "</td></tr>");
        }
        out.println(" </table>");
        out.println("<br><br><form action=\"index.html\" align=\"center\"><input type=\"submit\" value=\"Back to login\"></form>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
