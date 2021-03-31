package com.local.component.mailService.configuration;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailConfig {
	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
		//Añadimos los datos del servidor de correos desde el que se va a enviar los mensajes. Algunos ejemplos:
		//Correos salientes
		//gmail: Host(smtp.gmail.com), port(587) seria TLS y protocol SMTP
		//Correos entrantes:
		//gmail: Host(imap.gmail.com), port(993) seria SSL y protocol IMAP
		//gmail: Host(pop.gmail.com), port(995) seria SSL y protocol POP3
		mailSenderImpl.setHost("smtp.gmail.com");
		mailSenderImpl.setPort(587);
		
		//Añadimos los datos del usuario desde el que se va a enviar el correo
		mailSenderImpl.setUsername("");
		mailSenderImpl.setPassword("");
		
		Properties properties = mailSenderImpl.getJavaMailProperties();
		//SMTP (Simple Mail Transfer Protocol en inglés) es un protocolo de comunicación que permite el envío de correos electrónicos (saliente).
		//IMAP (Internet Message Access Protocol en inglés) es un protocolo de comunicación que se encarga de la recepción de correos electrónicos (entrante).
		//POP3 (Post Office Protocol en inglés) es un protocolo de comunicación que, al igual que IMAP, permite la recepción de correos electrónicos (entrante).
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.starttls.required", "true");
		properties.put("mail.debug", "true");
		
		return mailSenderImpl;
	}
}
