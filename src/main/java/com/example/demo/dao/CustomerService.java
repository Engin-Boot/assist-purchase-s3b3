package com.example.demo.dao;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Monitor;
@Service("s2")
public interface CustomerService {
	public <Iterable> Monitor categoriesOffered();
	public Iterable<Monitor> categories();
	public Iterable<Monitor> touchscreenIsSelected();
	public Iterable<Monitor> interoperabilityIsSelected();
	public Iterable<Monitor> interoperabilityIsNotSelected();
	
	public Monitor selectedProduct(int id);
}
