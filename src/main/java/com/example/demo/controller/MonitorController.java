package com.example.demo.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Monitor;
import com.example.demo.repositories.MonitorRepository;
import com.example.demo.services.MonitorService;


@RestController
public class MonitorController {
	@Autowired
	private MonitorRepository productRepository;
	@Autowired
	private MonitorService productService;

	@GetMapping("/monitor")
	public List<Monitor> getAllProducts() {
		// Returns hardcoded data, a real world application would return from the
		// database
		List<Monitor> productList = new ArrayList<Monitor>();

		for (Monitor product : productService.findAll()) {
			productList.add(new Monitor(product.getId(), product.getName(), product.getPrice(), product.isWireless(),
					product.isTouchscreen(), product.isInteroperable(), product.isConnectivitywithemr()));
			System.out.println();
		}
		return productList;
	}

	@GetMapping("/monitor/{monitorId}")
	public Monitor getProductWithId(@PathVariable Integer monitorId) {
		// Returns hardcoded data, a real world application would return from the
		// database
		Monitor product = productService.findById(monitorId);
		return new Monitor(product.getId(), product.getName(), product.getPrice(), product.isWireless(),
				product.isTouchscreen(), product.isInteroperable(), product.isConnectivitywithemr());
	}

	@PostMapping("/monitor/newmonitor")
	public Monitor addProduct(@RequestBody Monitor product) {
		// Just has a Systemout stmt, a real world application would save this record to
		// the database
		// product= productService.save(product);

		System.out.println("Saving monitor information");
		return productRepository.save(product);
	}

	@DeleteMapping("/monitor/delete/{id}")
	public Monitor deleteProductByID(@PathVariable("id") int id) {
		productRepository.deleteById(id);
		return null;
	}

	@GetMapping("/monitor/category")
	public List<String> categories() {
		// Returns hardcoded data, a real world application would return from the
		// database
		List<String> li = new ArrayList<>();
		String str = "TOUCHSCREEN/COLOURED";// small letter
		li.add(str);
		return li;
	}

	@GetMapping("/monitor/category/Touchscreen")
	public List<Monitor> categriesOffered() {
		// Returns hardcoded data, a real world application would return from the
		// database
		List<Monitor> productList = new ArrayList<Monitor>();
		for (Monitor product : productService.findAll()) {
			if (product.isTouchscreen()) {
				productList
						.add(new Monitor(product.getId(), product.getName(), product.getPrice(), product.isWireless(),
								product.isTouchscreen(), product.isInteroperable(), product.isConnectivitywithemr()));
			}
		}
		return productList;
	}

	@GetMapping("/monitor/category/touchscreen/interoperability/connectivity_EMR")
	public List<Monitor> touchscreenIsSelected() {
		// Returns hardcoded data, a real world application would return from the
		// database
		List<Monitor> productList = new ArrayList<Monitor>();
		for (Monitor product : productService.findAll()) {
			if (product.isInteroperable() && product.isTouchscreen() && product.isConnectivitywithemr()) {
				productList
						.add(new Monitor(product.getId(), product.getName(), product.getPrice(), product.isWireless(),
								product.isTouchscreen(), product.isInteroperable(), product.isConnectivitywithemr()));
			}
		}
		return productList;
	}

	@GetMapping("/monitor/category/touchscreen/interoperability")
	public List<Monitor> interoperabilityIsSelected() {
		// Returns hardcoded data, a real world application would return from the
		// database
		List<Monitor> productList = new ArrayList<Monitor>();
		for (Monitor product : productService.findAll()) {
			if (product.isInteroperable() && product.isTouchscreen()) {
				productList
						.add(new Monitor(product.getId(), product.getName(), product.getPrice(), product.isWireless(),
								product.isTouchscreen(), product.isInteroperable(), product.isConnectivitywithemr()));
			}
		}
		return productList;
	}

	@GetMapping("/monitor/category/touchscreen/nointeroperability")
	public List<Monitor> interoperabilityIsNotSelected() {
		// Returns hardcoded data, a real world application would return from the
		// database
		List<Monitor> productList = new ArrayList<Monitor>();
		for (Monitor product : productService.findAll()) {
			if (product.isTouchscreen() && !(product.isInteroperable())) {
				productList
						.add(new Monitor(product.getId(), product.getName(), product.getPrice(), product.isWireless(),
								product.isTouchscreen(), product.isInteroperable(), product.isConnectivitywithemr()));
			}
		}
		return productList;
	}

	@GetMapping("/monitor/category/touchscreen/interoperability/connectivity_EMR/selectFinalProduct{monitorID}")
	public Monitor selectedProduct(@PathVariable Integer monitorId) {
	
		Monitor product = productService.findById(monitorId);

		return new Monitor(product.getId(), product.getName(), product.getPrice(), product.isWireless(),
				product.isTouchscreen(), product.isInteroperable(), product.isConnectivitywithemr());
	}

}

