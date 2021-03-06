package com.hotproperties.web.inquiry.service;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.hotproperties.web.entity.Inquiry;

@Service
public class EmailServiceImpl implements EmailService
{

    private static final String BR = "<br/>";
	// Replace sender@example.com with your "From" address.
    // This address must be verified.
    static final String FROM = "philippinehotproperties@gmail.com";
    static final String FROMNAME = "hotproperties";
    
    // Replace recipient@example.com with a "To" address. If your account 
    // is still in the sandbox, this address must be verified.
    static final String TO = "philippinehotproperties@gmail.com";
    
//    SMTP Username:
//        AKIAJRR3KQIW3PKFFKLA
//        SMTP Password:
//        AvhW6/Jln62q+LGIiDobqCi2ycYRMJA3Q48Uk7vmIiKk
    
    // Replace smtp_username with your Amazon SES SMTP user name.
    static final String SMTP_USERNAME = "AKIAJRR3KQIW3PKFFKLA";
    
    // Replace smtp_password with your Amazon SES SMTP password.
    static final String SMTP_PASSWORD = "AvhW6/Jln62q+LGIiDobqCi2ycYRMJA3Q48Uk7vmIiKk";
    
    // The name of the Configuration Set to use for this message.
    // If you comment out or remove this variable, you will also need to
    // comment out or remove the header below.
    static final String CONFIGSET = "ConfigSet";
    
    // Amazon SES SMTP host name. This example uses the US West (Oregon) region.
    // See http://docs.aws.amazon.com/ses/latest/DeveloperGuide/regions.html#region-endpoints
    // for more information.
    static final String HOST = "email-smtp.us-east-1.amazonaws.com";
    
    // The port you will connect to on the Amazon SES SMTP endpoint. 
    static final int PORT = 587;
    
    static final String SUBJECT = "HotProperties Inquiry";
    
    public void sendEmail(Inquiry inquiry) throws Exception{
    	// Create a Properties object to contain connection configuration information.
        Properties props = System.getProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.port", PORT); 
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");

        // Create a Session object to represent a mail session with the specified properties. 
        Session session = Session.getDefaultInstance(props);

        // Create a message with the specified information. 
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(FROM,FROMNAME));
        msg.setRecipients(Message.RecipientType.TO, new Address[]{new InternetAddress(TO),
        		new InternetAddress("jdayojr@gmail.com")});
        msg.setSubject(SUBJECT);
        StringBuilder sb = new StringBuilder();
        if(StringUtils.isEmpty(inquiry.getPropertyName())) {
        	sb.append("Inquiry on Property");
        }else {
        	sb.append("Inquiry on Property - "+ inquiry.getPropertyName());
        }
        sb.append(BR);
        sb.append("<b>Details</b>");
        sb.append(BR);
        sb.append("Name:"+inquiry.getName());
        sb.append(BR);
        sb.append("Email:"+inquiry.getEmail());
        sb.append(BR);
        sb.append("Phone:"+inquiry.getPhone());
        sb.append(BR);
        sb.append("Message:");
        sb.append(BR);
        sb.append(inquiry.getMessage());
        
        msg.setContent(sb.toString(),"text/html");
        
        // Add a configuration set header. Comment or delete the 
        // next line if you are not using a configuration set
//        msg.setHeader("X-SES-CONFIGURATION-SET", CONFIGSET);
            
        // Create a transport.
        Transport transport = session.getTransport();
                    
        // Send the message.
        try
        {
            System.out.println("Sending...");
            
            // Connect to Amazon SES using the SMTP username and password you specified above.
            transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);
            
            // Send the email.
            transport.sendMessage(msg, msg.getAllRecipients());
            System.out.println("Email sent!");
        }
        catch (Exception ex) {
            System.out.println("The email was not sent.");
            System.out.println("Error message: " + ex.getMessage());
        }
        finally
        {
            // Close and terminate the connection.
            transport.close();
        }
    }
    
    public void sendErrorEmail(String message) throws UnsupportedEncodingException, MessagingException {
    	// Create a Properties object to contain connection configuration information.
        Properties props = System.getProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.port", PORT); 
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");

        // Create a Session object to represent a mail session with the specified properties. 
        Session session = Session.getDefaultInstance(props);

        // Create a message with the specified information. 
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(FROM,FROMNAME));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
        msg.setSubject(SUBJECT);
        msg.setContent(message,"text/html");
        
        // Add a configuration set header. Comment or delete the 
        // next line if you are not using a configuration set
//        msg.setHeader("X-SES-CONFIGURATION-SET", CONFIGSET);
            
        // Create a transport.
        Transport transport = session.getTransport();
                    
        // Send the message.
        try
        {
            System.out.println("Sending...");
            
            // Connect to Amazon SES using the SMTP username and password you specified above.
            transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);
            
            // Send the email.
            transport.sendMessage(msg, msg.getAllRecipients());
            System.out.println("Email sent!");
        }
        catch (Exception ex) {
            System.out.println("The email was not sent.");
            System.out.println("Error message: " + ex.getMessage());
        }
        finally
        {
            // Close and terminate the connection.
            transport.close();
        }
    }

    
}
