package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Monitor;

@Service
public interface MonitorService {
	
public Iterable<Monitor> findAll();
public Monitor addNewProduct(Monitor product);
public void deleteById(int id ); 

public Monitor findById(int id); 
public <Iterable> Monitor categoriesOffered();
public Iterable<Monitor> categories();
public Iterable<Monitor> touchscreenIsSelected();
public Iterable<Monitor> interoperabilityIsSelected();
public Iterable<Monitor> interoperabilityIsNotSelected();

Monitor selectedProduct(int id);
}





