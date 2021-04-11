/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Session;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author Sujon
 */
public class sendOTP {

    public static void sendMail(String recepient) throws MessagingException {
            System.out.println("Preparing the mail...");
            Properties properties = new Properties();
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host","smtp.gmail.com");
            properties.put("mail.smtp.port", "587");
            
            String myEmailAccount = "xxxxxx@gmail.com";
            String password = "xxxxxxxx";
            
           Session session = Session.getInstance(properties, new Authenticator() {
               @Override
               protected PasswordAuthentication getPasswordAuthentication(){
                   return new PasswordAuthentication(myEmailAccount, password);
               };
           });
           
           Message message = prepareMessage(session, myEmailAccount, recepient);
           
         Transport.send(message);
        
        System.out.println("Mail is sent successfully");
    }

    /*
    mail.smtp.auth
    mail.smtp.starttls.enable
    mail.smtp.host - smtp.gmail.com
    mail.smtp.port - 587
     */

    private static Message prepareMessage(Session session, String myEmailAccount, String recepient) {
       
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myEmailAccount));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("WMS OTP");
            message.setText("Your OTP is 665544 to RESET your password. This mail is valid for only 2 minutes.");
            return message;
        } catch (MessagingException ex) {
            Logger.getLogger(sendOTP.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
