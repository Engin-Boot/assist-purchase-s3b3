package com.philips.assistpurchase.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.philips.assistpurchase.dto.MonitorSpecs;
import com.philips.assistpurchase.entity.Monitor;
import com.philips.assistpurchase.repository.MonitorRepository;
import com.philips.assistpurchase.service.MonitorService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MonitorController {
	private static final Logger log = LoggerFactory.getLogger(MonitorController.class);

	@Autowired
	private MonitorRepository productRepository;
	@Autowired
	private MonitorService productService;

	@CrossOrigin(origins = "http://localhost:4200")
	
	@PostMapping("/monitor")
	public Monitor addProduct(@RequestBody Monitor monitor) {
		log.info("Saving monitor information");
		productRepository.save(monitor);
		return monitor;
	}

	@GetMapping("/monitor")
	public List<Monitor> getAllProducts() {
	
		return productService.getAllMonitors();
	}

	@GetMapping("/monitor/count")
	public Long getAProductCount() {

		return productService.getProductCount();
	}

	@GetMapping("/monitor/{monitorId}")
	public Monitor getProductWithId(@PathVariable Integer monitorId) {

		return productService.findById(monitorId);
	}

	@DeleteMapping("/monitor/delete/{id}")
	public Monitor deleteProductByID(@PathVariable("id") int id) {
		productRepository.deleteById(id);
		return null;
	}
	
	@PostMapping("monitor/specs")
	public List<Monitor> searchForMonitor(@RequestBody MonitorSpecs monitorSpec)
	{
		List<Monitor> monitors = productService.findMonitorBySpecs(monitorSpec.isTouchscreen(), monitorSpec.isWireless(), 
				monitorSpec.isInteroperable(), monitorSpec.isConnectivitywithemr());
		return monitors;
	}
	
	@PostMapping("monitor/name")
	public Monitor searchForMonitorByName(@RequestBody String monitorName)
	{
		Monitor monitor = productService.findMonitorByName(monitorName);
		return monitor;
	}

}
