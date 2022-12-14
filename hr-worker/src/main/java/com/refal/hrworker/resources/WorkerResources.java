package com.refal.hrworker.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.refal.hrworker.entities.Worker;
import com.refal.hrworker.services.WorkerService;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResources {
	
	@Autowired
	private WorkerService service;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		
		List<Worker> list = service.findAll();
		
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {
		
		Worker obj = service.findById(id);
		
		return ResponseEntity.ok(obj);
	}

}
