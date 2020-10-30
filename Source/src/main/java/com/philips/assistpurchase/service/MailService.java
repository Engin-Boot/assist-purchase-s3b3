package com.philips.assistpurchase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.philips.assistpurchase.dto.CustomerEnquiry;

//import com.example.demo.domain.User;

@Service
public class MailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public boolean sendEmail(CustomerEnquiry userenquiry) throws MailException {
		
		try {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("anaghesh.m@philips.com","sanjeevnnn@gmail.com");
		mail.setSubject("Customer Interest lead");
		
		String text="\nName: "+userenquiry.getName()+"\nMail: "+userenquiry.getEmail()+
		"\nContact Number: "+userenquiry.getMobile()+"\nInterested Device: "+userenquiry.getMonitorDevice()+
		"\nMessage: "+userenquiry.getMessage();
		
		mail.setText(text);
		javaMailSender.send(mail);
		return true;
		}catch (MailException e) {
			return false;
		}
			
	}
}
