package com.philips.assistpurchase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.philips.assistpurchase.dto.CustomerEnquiry;
import com.philips.assistpurchase.service.MailService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MailController {

	@Autowired
	private MailService mailService;

	@PostMapping("/sendmail")
	public String send(@RequestBody CustomerEnquiry userenquiry) {

		try {
			mailService.sendEmail(userenquiry);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}

		return "Mail has been sent successfully!";
	}

}
