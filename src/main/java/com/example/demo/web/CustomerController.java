package com.example.demo.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Monitor;
import com.example.demo.repositories.MonitorRepository;
import com.example.demo.services.MonitorService;
@RestController
public class CustomerController {

	@Autowired
	private MonitorRepository productRepository;
	@Autowired
	private MonitorService productService;

	@GetMapping("/monitor/category")
	public List<String> categories() {

		List<String> li = new ArrayList<>();
		String str = "TOUCHSCREEN/COLOURED";// small letter
		li.add(str);
		return li;
	}

	@GetMapping("/monitor/category/Touchscreen")
	public List<Monitor> categriesOffered() {

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
