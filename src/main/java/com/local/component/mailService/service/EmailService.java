package com.local.component.mailService.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.local.component.mailService.model.Email;

@Service
public class EmailService {
	private JavaMailSender javaMailSender;
	
	@Autowired
	public EmailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public void sendEmail(Email userModel) throws MailException, MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setTo(userModel.getEmail());
		helper.setFrom(userModel.getSender());
		helper.setSubject(userModel.getSubject());
		helper.setText(userModel.getMessage(), true);
		
		javaMailSender.send(message);
	}
}
