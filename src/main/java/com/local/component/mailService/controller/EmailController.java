package com.local.component.mailService.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.local.component.mailService.model.Email;
import com.local.component.mailService.service.EmailService;

@RestController
@RequestMapping("/api/v1/email")
public class EmailController {
	@Autowired
	private EmailService emailService;
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Email> enviarEmail(@RequestBody Email email){
		try {
			try {
				emailService.sendEmail(email);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			return new ResponseEntity<>(email, HttpStatus.OK);
		} catch (MailException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
