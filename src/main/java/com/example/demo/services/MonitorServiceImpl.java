package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Monitor;
import com.example.demo.repositories.MonitorRepository;

@Service("monitorService")
public class MonitorServiceImpl implements MonitorService {
	@Autowired
	private MonitorRepository productRepository;

	@Override
	public Iterable<Monitor> findAll() {

		return productRepository.findAll();
	}

	@Override
	public Monitor addNewProduct(Monitor product) {

		return productRepository.save(product);
	}

	@Override
	public void deleteById(int id) {

		productRepository.deleteById(id);
	}

	@Override
	public Monitor findById(int id) {

		return productRepository.findById(id).get();
	}
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
