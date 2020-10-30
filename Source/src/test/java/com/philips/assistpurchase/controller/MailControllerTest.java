package com.philips.assistpurchase.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class MailControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	protected WebApplicationContext wac;
	
	@Autowired
	MailController mailcontroller;
	
	@Test
	void testSendMail() throws Exception {
		
		String uri = "/sendmail";
		String inputJson = "{\"name\":\"sanjeev\",\"email\":\"sanjeev99@gmail.com\",\"mobile\":\"9865144330\",\"monitorDevice\":\"sample\",\"message\":\"abcde\"}";
		mockMvc.perform(post(uri).contentType("application/json").content(inputJson))
		.andExpect(status().isOk());
	}

}
