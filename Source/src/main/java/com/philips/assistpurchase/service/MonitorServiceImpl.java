package com.philips.assistpurchase.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.assistpurchase.entity.Monitor;
import com.philips.assistpurchase.repository.MonitorRepository;

@Service
public class MonitorServiceImpl implements MonitorService {
	@Autowired
	private MonitorRepository productRepository;

	@Override
	public Monitor addNewProduct(Monitor product) {

		return productRepository.save(product);
	}

	@Override
	public boolean deleteById(int id) {

		 if(productRepository.existsById(id))
		 {
			 productRepository.deleteById(id);
			 return true;
		 }
		 else {
			 return false;
		 }
		 
	}

	@Override
	public Monitor findById(int id) {

		try {
			
			return productRepository.findById(id).get();
		}catch (NoSuchElementException e) {
			System.out.println("Monitor with given ID not present!");
			return null;
		}
		
	}

	@Override
	public Long getProductCount() {
		
		return productRepository.count();
	}
	
	@Override
	public List<Monitor> findMonitorBySpecs(Boolean touch, Boolean wire, Boolean intero, Boolean emr) {
		
		try {
		return (List<Monitor>) productRepository.findMonitorBySpecs(touch, wire, intero, emr);
		}catch (NoSuchElementException e) {
			System.out.println("No Monitors present for such specs!");
			return null;
	    }
    }
	
	@Override
	public Monitor findMonitorByName(String MName) {
		
		try {
		Monitor monitor = productRepository.findMonitorByName(MName);
		return monitor;
	}catch (NoSuchElementException e) {
		System.out.println("No such Monitor present!");
		return null;
    }
	}

	@Override
	public List<Monitor> getAllMonitors() {
		
		return (List<Monitor>) productRepository.findAll();
	}


}
