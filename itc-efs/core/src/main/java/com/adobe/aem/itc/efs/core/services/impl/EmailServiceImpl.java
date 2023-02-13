package com.adobe.aem.itc.efs.core.services.impl;
import com.adobe.aem.itc.efs.core.services.EmailService;
import com.adobe.aem.itc.efs.core.services.EmailConf;
	import java.util.Properties;
	import java.util.Properties;
	import javax.mail.Message;
	import javax.mail.MessagingException;
	import javax.mail.PasswordAuthentication;
	import javax.mail.Session;
	import javax.mail.Transport;
	import javax.mail.internet.InternetAddress;
	import javax.mail.internet.MimeMessage;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Component(service=EmailService.class, immediate=true)
@Designate(ocd=EmailConf.class)
	public class EmailServiceImpl implements EmailService{
		private static final Logger LOG=LoggerFactory.getLogger(EmailServiceImpl.class);
		String temail;
		String femail;
		String pword;
		@Activate
		public void activate(EmailConf econf) {
			 temail=econf.toEmail();
			 femail=econf.fromEmail();
			 pword=econf.password();
			  }
		public void sendEmail(String messag){
				// Recipient's email ID needs to be mentioned.
		        String to = temail;
		        // Sender's email ID needs to be mentioned
		        //String from = "dsanthu.rs@gmail.com";
		        String from = femail;
		        // Assuming you are sending email from through gmails smtp
		        String host = "smtp.gmail.com";
		        // Get system properties
		        Properties properties = System.getProperties();
		        // Setup mail server
		        properties.put("mail.smtp.host", host);
		        properties.put("mail.smtp.port", "465");
		        properties.put("mail.smtp.ssl.enable", "true");
		        properties.put("mail.smtp.auth", "true");
		        // Get the Session object.// and pass username and password
		        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
		            protected PasswordAuthentication getPasswordAuthentication() {
		                return new PasswordAuthentication(from, pword);
		            }
		        });
		        // Used to debug SMTP issues
		        session.setDebug(true);
		        try {
		            // Create a default MimeMessage object.
		            MimeMessage message = new MimeMessage(session);
		            // Set From: header field of the header.
		            message.setFrom(new InternetAddress(from));
		            // Set To: header field of the header.
		            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		            // Set Subject: header field 
		            message.setSubject("This is the Subject Line!");
		            // Now set the actual message
		            message.setText(messag);

		            LOG.info("sending");
		            // Send message
		            Transport.send(message);
		            LOG.info("sent");
		        } catch (Exception e) {
		        	LOG.error("error while sending mail", e);
 		        }
		        
		    }
		}


