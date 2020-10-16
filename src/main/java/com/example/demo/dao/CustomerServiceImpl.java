package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.domain.Monitor;
import com.example.demo.repositories.MonitorRepository;

public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private MonitorRepository productRepository;

	public Monitor categoriesOffered() {
		return (Monitor) productRepository.findAll();
	}

	public Iterable<Monitor> categories() {
		return productRepository.findAll();
	}

	public Iterable<Monitor> touchscreenIsSelected() {
		return productRepository.findAll();
	}

	public Iterable<Monitor> InteroperabilityIsSelected() {
		return productRepository.findAll();
	}

	public Iterable<Monitor> InteroperabilityIsNotSelected() {
		return productRepository.findAll();
	}

	@Override
	public Iterable<Monitor> interoperabilityIsSelected() {
		return null;
	}

	@Override
	public Iterable<Monitor> interoperabilityIsNotSelected() {
		return null;
	}

	@Override

	public Monitor selectedProduct(int id) {
		return productRepository.findById(id).get();
	}

}
