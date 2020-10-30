package com.philips.assistpurchase.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.philips.assistpurchase.entity.Monitor;

@RunWith(SpringRunner.class)
@SpringBootTest
class MonitorServiceImplTest {

	@Autowired
	private MonitorService productService;

	
	@Test
	public void testFindAll() {
		List<Monitor> monitors= productService.getAllMonitors();
		assertNotNull(monitors,"Should not be Null");
	}
	
	@Test
	public void testAddNewProduct() {

		Monitor monitor = productService.addNewProduct(new Monitor(500,"test monitor",1000,true,true,false,false,"test image","test description"));
		assertNotNull(monitor,"Should not be Null");
	}

	@Test
	public void testDeleteWhenMonitorPresent() {
		
		Monitor monitor = productService.addNewProduct(new Monitor(200,"test monitor",1000,true,true,false,false,"test image","test description"));
		boolean actual = productService.deleteById(monitor.getId());
		assertTrue(actual,"Should be true");
	}
	
	@Test
	public void testDeleteWhenMonitorAbsent() {
		
		boolean actual = productService.deleteById(555);
		assertFalse(actual,"Should be false");
	}
	
	@Test
	public void testFindByIdWhenMonitorPresent() {
		Monitor expected = productService.addNewProduct(new Monitor(900,"test monitor1",1000,true,true,false,false,"test image","test description"));
		Monitor actual = productService.findById(expected.getId());
		assertEquals(expected.getId(),actual.getId());
		
	}
	
	@Test
	public void testFindByIdWhenMonitorAbsent() {
		
		Monitor actual = productService.findById(777);
		assertNull(actual);
	}
	
	@Test
	public void testProductCount() {
		List<Monitor> monitors= productService.getAllMonitors();
		Long count = productService.getProductCount();
		assertEquals(String.valueOf(count),String.valueOf(monitors.size()));
	}
	
	@Test
	public void testFindMonitorBySpecsWhenPresent() {
		List<Monitor> monitors= productService.findMonitorBySpecs(true, true, true, true);
		assertNotNull(monitors);	
	}
	
	@Test
	public void testFindMonitorBySpecsWhenAbsent() {
		List<Monitor> monitors= productService.findMonitorBySpecs(false, false, false, true);
		assertEquals(monitors.size(),0);	
	}
	
	@Test
	public void testFindMonitorByNameWhenPresent() {
		Monitor actual= productService.findMonitorByName(" IntelliVue MX550");
		assertEquals(actual.getName()," IntelliVue MX550");
	}
	
	@Test
	public void testFindMonitorByNameWhenAbsent() {
	
		Monitor actual= productService.findMonitorByName("random monitor name");
		assertNull(actual);	
	}
	
}
