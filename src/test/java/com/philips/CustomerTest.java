package com.philips;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.dao.CustomerService;
import com.example.demo.dao.CustomerServiceImpl;
import com.example.demo.domain.Monitor;
import com.example.demo.repositories.MonitorRepository;
import com.example.demo.web.CustomerController;

class CustomerTest {

	@Autowired
	private CustomerService service;
	
	@MockBean
	private MonitorRepository repository;
	
	@Test
	public void touchscreenIsSelectedTest() {
		service = mock(CustomerService.class);
		List<Monitor> monitor = List.of(new Monitor(1,"Mondel11",5.7,true,true,false,true),new Monitor(1,"Mondel22",5.7,true,true,false,true));		
		when(service.touchscreenIsSelected()).thenReturn(monitor);
		Assert.assertEquals(2,service.touchscreenIsSelected().size());
	}
	
	@Test
	public void interoperabilityIsSelectedTest() {
		service = mock(CustomerService.class);
		List<Monitor> monitor = List.of(new Monitor(1,"Mondel21",5.7,true,true,true,true),new Monitor(1,"Mondel22",5.7,false,true,true,true));		
		when(service.interoperabilityIsSelected()).thenReturn(monitor);
		Assert.assertEquals(2,service.interoperabilityIsSelected().size());
	}
	
	@Test
	public void interoperabilityIsNotSelectedTest() {
		service = mock(CustomerService.class);
		List<Monitor> monitor = List.of(new Monitor(1,"Mondel21",5.7,true,true,false,true));		
		when(service.interoperabilityIsNotSelected()).thenReturn(monitor);
		Assert.assertEquals(1,service.interoperabilityIsNotSelected().size());
	}


}
