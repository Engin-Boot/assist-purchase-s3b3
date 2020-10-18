package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Monitor;
@Service("s2")
public interface CustomerService {
	public <Iterable> Monitor categoriesOffered();
	public Iterable<Monitor> categories();
	public List<Monitor> touchscreenIsSelected();
	public List<Monitor> interoperabilityIsSelected();
	public List<Monitor> interoperabilityIsNotSelected();
	
	public Monitor selectedProduct(int id);
}
