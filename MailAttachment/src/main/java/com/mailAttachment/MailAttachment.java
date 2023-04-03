package com.mailAttachment;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailAttachment {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void mailAttachment(String[] toMail, String subject, String message, String attachment) throws MessagingException {
		
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
		
		mimeMessageHelper.setFrom("himanshugoyal311999@gmail.com");
		mimeMessageHelper.setTo(toMail);
		mimeMessageHelper.setSubject(subject);
		mimeMessageHelper.setText(message);
		
		FileSystemResource fileSystemResource = new FileSystemResource(new File(attachment));
		mimeMessageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
		
		javaMailSender.send(mimeMessage);
		
		System.out.print("Mail sent Succuessfully");
		
	}

}
