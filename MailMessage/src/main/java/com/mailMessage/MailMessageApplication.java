package com.mailMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class MailMessageApplication {

	@Autowired
	private SpringMailMessage springMailMessage;
	
	public static void main(String[] args) {
		SpringApplication.run(MailMessageApplication.class, args);
	}

	
	String[] toMail = {"bhaskarsain282000@gmail.com", "anilverma102001@gmail.com"};
	String subject = "Mail sent for testing purpose";
	String message = "Dear Chetan,\n I am trying to learn new skiils in spring boot and i will also with you how to 						work on spring boot.\nThank you.";
	
	@EventListener(ApplicationReadyEvent.class)
	public void mailMessage() {
		springMailMessage.springMailMessage(toMail, subject, message);
	}
	
}
