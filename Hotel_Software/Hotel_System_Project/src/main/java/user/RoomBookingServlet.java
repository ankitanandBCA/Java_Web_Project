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

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RoomBookingServlet
 */
@WebServlet("/RoomBookingServlet")
public class RoomBookingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RoomBookingServlet() {
        // Default constructor
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    String name;
    String email;
    String roomType;
    String checkInDate;
    String OwnerEmail="ankit65anand56raj@gmail.com";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //doGet(request, response);
    	
    	    name = request.getParameter("name");
            email = request.getParameter("email");
           String number = request.getParameter("phone");
            roomType = request.getParameter("roomType");
           String pricePerNight=request.getParameter("ppn");
            checkInDate = request.getParameter("checkInDate");
           String checkOutDate = request.getParameter("checkOutDate");
           String totalNight=request.getParameter("total_nights");
           String guests = request.getParameter("total_guests");
           String totalPrice=request.getParameter("total_price");
           
           
           try {
        	   Class.forName("com.mysql.cj.jdbc.Driver");
        	   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_Project_full_stack", "root", "W7301@jqir#");
        	   String sql="insert into RoomBooking(name,email,number,roomtype,price_per_night,checkindate,chekoutdate,total_night,guest,total_price)values(?,?,?,?,?,?,?,?,?,?)";
        	   PreparedStatement pst=con.prepareStatement(sql);
        	   pst.setString(1, name);
        	   pst.setString(2, email);
        	   pst.setString(3, number);
        	   pst.setString(4, roomType);
        	   pst.setString(5, pricePerNight);
        	   pst.setString(6, checkInDate);
        	   pst.setString(7, checkOutDate);
        	   pst.setString(8, totalNight);
        	   pst.setString(9, guests);
        	   pst.setString(10, totalPrice);
        	   
        	   int rs=pst.executeUpdate();
        	   if(rs>0)
        	   {
        		   System.out.println("Room Booking Successfully...");
        		   sendEmail(email);
        		   SendOwnerData(OwnerEmail,name,email,roomType,checkInDate);
        		   response.sendRedirect("roomBook.html");
        	   }
        	   else
        	   {
        		   System.out.println("Room Booking not Successfully...");
        	   }
           }catch(Exception e)
           {
        	   e.printStackTrace();
           }
           
           
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
            message.setText("Dear"+name+"Your Booking Was Successfully\n"+"Thanku For Visiting,Wish You All the Best");
            // Send the message
            Transport.send(message);
            System.out.println("Email sent successfully");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    } 
    
    
    
    
    
    
    private void SendOwnerData( String OwnerEmail,String name,String email,String roomType , String checkInDate) {
        String host = "smtp.gmail.com";  // Use your email provider's SMTP server
        final String user = "aman2000anand2000@gmail.com"; // Your email
        final String password = "dbgn vmnd akgh trca"; // Your email password

        String to = OwnerEmail;  // The email of the student

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
            message.setSubject("User Booking Details");
            message.setText("Name : "+name+"\n"+"Email :"+email+"\n"+"Room Type no :"+roomType+"\n"+"Chek_In_Date :"+checkInDate);
         //   message.setText("email : "+email);

            // Send the message
            Transport.send(message);
            System.out.println("Owner email sent successfully");
        } catch (MessagingException e) {
            e.printStackTrace();
        }	
    }
    
    
    
    
}
