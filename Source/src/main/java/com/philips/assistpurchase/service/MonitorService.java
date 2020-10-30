package com.philips.assistpurchase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.assistpurchase.entity.Monitor;

@Service
public interface MonitorService {

	public List<Monitor> getAllMonitors();
	
	public Monitor addNewProduct(Monitor product);

	public boolean deleteById(int id);

	public Long getProductCount();

	public Monitor findById(int id);
	
	public List<Monitor> findMonitorBySpecs(Boolean touch, Boolean wire, Boolean intero, Boolean emr);
	
	public Monitor findMonitorByName(String MName);
}
