package user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegUser
 */
@WebServlet("/RegUser")
public class RegUser extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    String email;
    String name;
    String passwor;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
       
            name=request.getParameter("fullname");
            email=request.getParameter("email");;
           String number=request.getParameter("phone");;
            passwor=request.getParameter("password");;
           String confirm_password=request.getParameter("confirm-password");
           
           try {
        	   Class.forName("com.mysql.cj.jdbc.Driver");
        	   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_Project_full_stack", "root", "W7301@jqir#");
        	   String sql="INSERT INTO userRegister(name,email,phone_number,password,confirm_password)values(?,?,?,?,?)";
        	   PreparedStatement pst=con.prepareStatement(sql);
        	   pst.setString(1, name);
        	   pst.setString(2, email);
        	   pst.setString(3, number);
        	   pst.setString(4, passwor);
        	   pst.setString(5, confirm_password);
        	   
        	   int rs=pst.executeUpdate();
        	   if(rs>0)
        	   {
        		   System.out.println("User Register Successfully....");
        		   sendEmail(email);
        		   response.sendRedirect("booking.html");
        	   }
        	   else {
        		   System.out.println("User Register not Successfully....");
        	   }
        	   
        	   
           }catch(Exception e)
           {
        	   e.printStackTrace();
           }
           
           
        // Process user registration logic (e.g., store in database)
       // response.getWriter().write("User Registered Successfully: " );
    }
    
    private void sendEmail(String recipientEmail) {
        String host = "smtp.gmail.com";  // Use your email provider's SMTP server
        final String user = "aman2000anand2000@gmail.com"; // Your email
        final String password = "dbgn vmnd akgh trca"; // Your email password

        String to = recipientEmail;  // The email of the student

        // Set properties for the mail session
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the session object
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        try {
            // Create a default MimeMessage object
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Hotel Royal Places");
            message.setText("Dear "+name+", your registration was successful!\n"+"Login Details :\n"+"Email :"+email+"Password :"+passwor+"\n"+"Don't Send Message");
            // Send the message
            Transport.send(message);
            System.out.println("Email sent successfully");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }    
}
