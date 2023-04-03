package com.mailMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SpringMailMessage {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void springMailMessage(String[] toMail, String subject, String message) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		
		simpleMailMessage.setFrom("himanshugoyal311999@gmail.com");
		simpleMailMessage.setTo(toMail);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(message);
		
		javaMailSender.send(simpleMailMessage);
		
		System.out.println("Mail sent successfully");
	}

}
