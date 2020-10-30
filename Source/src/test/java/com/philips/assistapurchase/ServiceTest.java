package com.philips.assistapurchase;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.philips.assistpurchase.entity.Monitor;
import com.philips.assistpurchase.repository.MonitorRepository;
import com.philips.assistpurchase.service.MonitorService;

class ServiceTest {


	@Autowired
	private MonitorService service;
	
//	@MockBean
//	private MonitorRepository repository;
	
		@Test
		public void findAllTest() {
		 	service = mock(MonitorService.class);
			when(service.getAllMonitors()).thenReturn(Stream
					.of(new Monitor(21,"intel", 11.5,false,true,true,false, "path","Description"),new Monitor(22,"moni", 14.5,false,true,true,true, "path","Description")).collect(Collectors.toList()));
			Assertions.assertEquals(2, service.getAllMonitors().size());
		}
		
		@Test
		public void addNewMonitorTest() {
			service = mock(MonitorService.class);
			Monitor monitor = new Monitor(1,"Mondel1123",5.7,true,true,false,true, "path","Description");			
			when(service.addNewProduct(monitor)).thenReturn(monitor);
			Assertions.assertEquals(1, monitor.getId());
		}
		
		@Test
		public void findByIdWhenMonitorIsNotPresentTest() {
			service = mock(MonitorService.class);
			Monitor monitor = new Monitor(1,"Mondel1123",5.7,true,true,false,true, "path","Description");
			when(service.findById(2)).thenReturn(null);
			Assert.assertNull(service.findById(2));
		}
		
		@Test
		public void findByIdWhenMonitorISPresentTest() {
			service = mock(MonitorService.class);
			Monitor monitor = new Monitor(1,"Mondel1123",5.7,true,true,false,true, "path","Description");
			when(service.findById(1)).thenReturn(monitor);
			Assert.assertNotNull(service.findById(1));
		}
		
		@Test
		public void deleteByIdTest() {
			service = mock(MonitorService.class);
			Monitor monitor = new Monitor(1,"Mondel1123",5.7,true,true,false,true, "path","Description");
			service.deleteById(1);
			Assert.assertNull(service.findById(1));
		}


}
