package com.philips.assistpurchase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.philips.assistpurchase.entity.Monitor;

@Repository("monitorRepository")
public interface MonitorRepository extends CrudRepository<Monitor,Integer> {
	

	@Query("SELECT m from Monitor m WHERE m.isTouchscreen = ?1 and m.isWireless = ?2"
			+ " and m.isInteroperable = ?3 and m.connectivitywithemr =?4")
    List<Monitor> findMonitorBySpecs(Boolean touch, Boolean wire, Boolean intero, Boolean emr);
	
	@Query("SELECT m from Monitor m WHERE m.name = ?1")
	Monitor findMonitorByName(String MName);


}
