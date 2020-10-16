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

}





