package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.domain.Monitor;
import com.example.demo.repositories.MonitorRepository;

public class CustomerServiceImpl implements CustomerService
{

	@Autowired
	private MonitorRepository productRepository;
	public Monitor categoriesOffered() {
		// TODO Auto-generated method stub
		return (Monitor) productRepository.findAll();
	}

	public Iterable<Monitor> categories() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	public Iterable<Monitor> touchscreenIsSelected() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	public Iterable<Monitor> InteroperabilityIsSelected() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	public Iterable<Monitor> InteroperabilityIsNotSelected() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Iterable<Monitor> interoperabilityIsSelected() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Monitor> interoperabilityIsNotSelected() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	
	public Monitor selectedProduct(int id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id).get();
	}
	

}
