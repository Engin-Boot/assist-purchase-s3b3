package com.philips.assistpurchase.controller;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.philips.assistpurchase.dto.MonitorSpecs;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.awt.PageAttributes.MediaType;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class MonitorControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	protected WebApplicationContext wac;
	
	@Autowired
	MonitorController monitorcontroller;
	
	
	@Test
	void GivenMonitorsWhenGetMonitorsThenStatus200() throws Exception{
		
		mockMvc.perform(get("/monitor").contentType("application/json"))
		.andExpect(status().isOk())
		.andExpect(content()
			      .contentTypeCompatibleWith("application/json"))
			      .andExpect(jsonPath("$.*.name", hasItem(is(" IntelliVue MX550"))));
	}
	
	@Test
	void GivenMonitorIDWhenGetMonitorByIDThenStatus200() throws Exception{
		
		mockMvc.perform(get("/monitor/7").contentType("application/text"))
		.andExpect(status().isOk())
		.andExpect(content()
			      .contentTypeCompatibleWith("application/json"));
//		      .andExpect(jsonPath("$.*.name", hasItem(is(" IntelliVue MX550"))));
	}
	
	
	@Test
	void GivenMonitorSpecsWhenGetMonitorsThenStatus200() throws Exception{
		

		String inputJson = "{\"isWireless\":\"true\",\"isTouchscreen\":\"true\",\"isInteroperable\":\"true\",\"connectivitywithemr\":\"true\"}";
		
		mockMvc.perform(post("http://localhost:8080/monitor/specs").contentType("application/json").content(inputJson))
		.andExpect(status().isOk())
		.andExpect(content()
			      .contentTypeCompatibleWith("application/json"))
			      .andExpect(jsonPath("$.*.name", hasItem(is(" IntelliVue MX500"))));
	}
	
	@Test
	void GivenMonitorNameWhenGetMonitorThenStatus200() throws Exception{
		
//IntelliVue MX400  IntelliVue MX500
		String inputJson = "IntelliVue MX400";
		
		mockMvc.perform(post("http://localhost:8080/monitor/name").contentType("application/text").content(inputJson))
		.andExpect(status().isOk())
		.andExpect(content()
			      .contentTypeCompatibleWith("application/json"));
//			      .andExpect(jsonPath("$.*.name", hasItem(is(" IntelliVue MX500"))));
	}
	

}
