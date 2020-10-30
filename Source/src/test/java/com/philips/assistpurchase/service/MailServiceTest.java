package com.philips.assistpurchase.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.philips.assistpurchase.dto.CustomerEnquiry;

@RunWith(SpringRunner.class)
@SpringBootTest
class MailServiceTest {

	@Autowired
	private MailService mailservice;
	
	@Test
	void testSendMail() {
		
		CustomerEnquiry userenquiry = new CustomerEnquiry("Sanjeev","sanjeev99@gmail.com","9865133445","sample monitor","sample message");
		boolean actual = mailservice.sendEmail(userenquiry);
		assertTrue(actual);
	}

}
