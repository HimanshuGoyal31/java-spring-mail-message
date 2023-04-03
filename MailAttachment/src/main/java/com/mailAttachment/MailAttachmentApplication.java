package com.mailAttachment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import jakarta.mail.MessagingException;

@SpringBootApplication
public class MailAttachmentApplication {

	@Autowired
	private MailAttachment mailAttachment;
	
	public static void main(String[] args) {
		SpringApplication.run(MailAttachmentApplication.class, args);
	}

	String[] toMail = {"chetandhamani031999@gmail.com", "anilverma102001@gmail.com"};
	String subject = "Testing purpose mail";
	String message = "Dear Diya,\nThis is a system generated mail. Please Do not reply.\n\nPlease find the attachment of your resume.\nThank you.";
	String attachment = "C:\\Users\\home\\Desktop\\diya resume.pdf";
	
	@EventListener(ApplicationReadyEvent.class)
	public void mailMessage() throws MessagingException {
		mailAttachment.mailAttachment(toMail, subject, message, attachment);
	}
}
