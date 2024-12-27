package com.chaithu.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtils {

	@Autowired
	private JavaMailSender javaMailSender;

	public boolean sendMail(String to, String subject, String body) {
		Boolean isMailSent = false;
		MimeMessage createMimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(createMimeMessage);

		try {
			mimeMessageHelper.setTo(to);
			mimeMessageHelper.setSubject(subject);
			mimeMessageHelper.setText(body, true);

			javaMailSender.send(createMimeMessage);
			isMailSent = true;
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		return isMailSent;

	}

}
