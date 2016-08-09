/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch06.javamail;

import java.util.Properties;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Administrator
 */
@ManagedBean(name = "mailSender")
public class MailSender {

    private String toAddress;
    private String message;
    private final String userName = "username@gmail.com";
    private final String userPassword = "user_password";

    public void sendMesage(ActionEvent evt) {
        try {           
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            Session session = Session.getInstance(props, null);

            Message msg = new MimeMessage(session);           
            InternetAddress[] internetAddresses = new InternetAddress[1];
            internetAddresses[0] = new InternetAddress(toAddress);
            msg.setRecipients(Message.RecipientType.TO, internetAddresses);
            msg.setSubject("Pre-inscription results");
            msg.setText(message);

            Transport.send(msg,userName,userPassword);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
