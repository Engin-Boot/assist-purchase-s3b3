package com.example.demo.web;

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

		Monitor product = productService.findById(monitorId);
		return new Monitor(product.getId(), product.getName(), product.getPrice(), product.isWireless(),
				product.isTouchscreen(), product.isInteroperable(), product.isConnectivitywithemr());
	}

	@PostMapping("/monitor/newmonitor")
	public Monitor addProduct(@RequestBody Monitor product) {

		System.out.println("Saving monitor information");
		return productRepository.save(product);
	}

	@DeleteMapping("/monitor/delete/{id}")
	public Monitor deleteProductByID(@PathVariable("id") int id) {
		productRepository.deleteById(id);
		return null;
	}

}
