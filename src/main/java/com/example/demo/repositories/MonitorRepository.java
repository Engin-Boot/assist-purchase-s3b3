package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Monitor;

@Repository("monitorRepository")
public interface MonitorRepository extends CrudRepository<Monitor,Integer> {

}
