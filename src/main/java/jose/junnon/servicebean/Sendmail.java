/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jose.junnon.servicebean;

import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.mail.AuthenticationFailedException;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import jose.junnon.dao.UsermainDao;
import jose.junnon.model.Usermain;

/**
 *
 * @author SONY
 */
public class Sendmail {

/**
 *
 * @author alpeshkyada
 */


   
    public void sendMailtoadmin() {

//        final Properties propertiesfile = new Properties();
        Properties properties = new Properties();
        

        // Setup mail server
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", 25);
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.put("mail.smtp.auth", "true");
       
     Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {

                        return new PasswordAuthentication("manankhh@gmail.com", "krumasta");
                    }
                });
   

       
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);
            // Set From: header field of the header.
            message.setFrom(new InternetAddress("manankhh@gmail.com"));
            // Set To: header field of the header.

            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse("manankhh@gmail.com"));
            // Set Subject: header field
            message.setSubject("testing");

            // Create the message part 
            BodyPart messageBodyPart = new MimeBodyPart();

            // Fill the message
            messageBodyPart.setContent(retriveUser(), "text/html");
            // Create a multipar message
            Multipart multipart = new MimeMultipart();

            // Set text message part
            multipart.addBodyPart(messageBodyPart);

            // Send the complete message parts
            message.setContent(multipart);

//            // Send message
            Transport.send(message);

        } catch (AuthenticationFailedException ae) {
            System.out.println("authentication failed");
        } catch (MessagingException mex) {
            System.out.println(mex);
        }
    }
    public String retriveUser(){
        String s1=null;
               String s2=null;
        UsermainDao dao=new UsermainDao();
        List<Usermain> result=dao.retriveAll();
        for(Usermain  u:result){
            s1=u.getUsername();
            s2=u.getPassword1();
        }
        return "UserName is :<b style="+"color:#ff7200"+">"+s1+"</b><br/>"+"Password is :<b style="+"color:#ff7200"+">"+s2+"</b>";
    }


//    public static void main(String[] args) {
//        Sendmail sendMail = new Sendmail();
//        sendMail.sendMail();
//    }

}