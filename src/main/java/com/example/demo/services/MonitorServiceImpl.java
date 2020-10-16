package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Monitor;
import com.example.demo.repositories.MonitorRepository;

@Service
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

	

}
