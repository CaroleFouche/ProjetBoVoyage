package fr.adaming.utilities;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.security.auth.Subject;

import java.util.Properties;


import org.springframework.stereotype.Component;

@Component
public class MailConfig {

	public boolean sendMail(String sendTo, String content, String subject) {

		final String username = "leskiwis2019@gmail.com";
		final String password = "Kiwi2019";

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); // TLS
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(sendTo));
			message.setSubject(subject);
			message.setText(content);

			Transport.send(message);
			System.out.println("Mail sent");
			return true;
			

		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return false;
	}
}
