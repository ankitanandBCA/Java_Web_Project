package com.emailsender.example.service;

import com.emailsender.example.entity.Student;
import com.emailsender.example.repositry.StudentRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private JavaMailSender mailSender;

    public Student registerStudent(Student student) {
        Student saved = studentRepository.save(student);

        try {
            // student ka email aur name bhejna hai
            sendRegistrationEmail(saved.getEmail(), saved.getName());
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return saved;
    }

    public void sendRegistrationEmail(String toEmail, String name) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(toEmail);
        helper.setSubject("Registration Successful");

        String content = "<h1>Welcome, " + name + " 🎉</h1>"
                + "<p>Your registration was successful.</p>"
                + "<p>Sending Email by <b>MyLMS</b></p>"
                + "<br>"
                + "<img src='' "
                + " width='200'/>";

        helper.setText(content, true); // true = HTML enabled

        mailSender.send(message);
    }
}
