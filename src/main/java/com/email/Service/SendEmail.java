package com.email.Service;

import com.email.constant.Constant;
import org.springframework.stereotype.Service;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
@Service
public class SendEmail {

    public  void sendEmail(){

        Constant constant=new Constant();
        String message= constant.getMessage();
        String subject = constant.getSubject();
        String to=constant.getTo();
        String from=constant.getFrom();


        //Variable for gmail
        String host="smtp.gmail.com";

        //get the system properties
        Properties properties=System.getProperties();
        System.out.println("Properties" + properties);

        //setting important information to properties object

        //host set
        properties.put("mail.smtp.host",host);
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");

        //Step 1: to get the session object......

        Session session= Session.getInstance(properties,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(constant.getFrom(),constant.getPass());
                    }
        });

        session.setDebug(true);

    //Step 2 : compose the message [text,multimedia]

        MimeMessage message1= new MimeMessage(session);


        try{
            //from email id
            message1.setFrom(from);

            //recipient
            message1.addRecipient(Message.RecipientType.TO,new InternetAddress(to));

            // adding subject to message

            message1.setSubject(subject);

            // adding text to message

            message1.setText(message);

            //Step3
            //Send message using transport class

            Transport.send(message1);

            System.out.println("Mail sent Successfully ............");
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
}
