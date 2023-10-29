package fdv.fomenkolr6.servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;



@WebServlet("/MailPostServlet")
public class MailPostServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Recipient's email ID needs to be mentioned.
        String to = "f.dv.register@gmail.com";

        // Sender's email ID needs to be mentioned
        String from = "f.dv.register@gmail.com";
        // Get system properties
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");

        String username = "f.dv.register@gmail.com";
        String password = "";

        // Get the default Session object.
        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("This is the Subject Line!");

            // Create the message part
            BodyPart messageBodyPart = new MimeBodyPart();

            // Fill the message
            messageBodyPart.setText("This is message body");

            // Create a multipar message
            Multipart multipart = new MimeMultipart();

            // Set text message part
            multipart.addBodyPart(messageBodyPart);

            // Part two is attachment
            messageBodyPart = new MimeBodyPart();
            String filename = "file.txt";
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);

            // Send the complete message parts
            message.setContent(multipart );

            // Send message
            Transport.send(message);
            String title = "Send Email";
            String res = "Sent message successfully....";
            String docType =
                    "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

            out.println(docType +
                                "<html>\n" +
                                "<head><title>" + title + "</title></head>\n" +
                                "<body bgcolor = \"#f0f0f0\">\n" +
                                "<h1 align = \"center\">" + title + "</h1>\n" +
                                "<p align = \"center\">" + res + "</p>\n" +
                                "</body> </html>"
         );
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

}
