package com.example.demo.dao;

import java.util.List;

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

	public List<Monitor> touchscreenIsSelected() {
		return (List<Monitor>) productRepository.findAll();
	}

	public List<Monitor> InteroperabilityIsSelected() {
		return (List<Monitor>) productRepository.findAll();
	}

	public List<Monitor> InteroperabilityIsNotSelected() {
		return (List<Monitor>) productRepository.findAll();
	}

	@Override
	public List<Monitor> interoperabilityIsSelected() {
		return null;
	}

	@Override
	public List<Monitor> interoperabilityIsNotSelected() {
		return null;
	}

	@Override

	public Monitor selectedProduct(int id) {
		return productRepository.findById(id).get();
	}

}
