package com.example.ms1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ms1.model.Ms1;
import com.example.ms1.repository.Ms1Repository;
import com.example.ms1.service.Ms1Service;
@RestController
@RequestMapping("/ms1")
public class Ms1Controller {

	//private static final Object Ms1Service = null;
	@Autowired
	private  Ms1Repository repository;
	
	@Autowired
	private Ms1Service ms1service;

	/*
	 * public void init() { Ms1 ms1 = new Ms1(); ms1.setConversion_factor(70);
	 * ms1.setCountry_code("IN"); ms1.setId(0); repository.save(ms1); }
	 */
	@GetMapping
	public ResponseEntity<List<Ms1>> getConversionFactorAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Ms1> getConversionFactor(@PathVariable Long id) {
		return ResponseEntity.ok(repository.findById(id).orElse(new Ms1()));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Ms1> updateConversionFactor(@PathVariable Long id,@RequestBody Ms1 ms1) {
		ms1.setId(id);
		return ResponseEntity.ok(this.ms1service.updateConversionfactor(ms1));
	}
	
	@RequestMapping(value = {"countryCode/{countryCode}"},method = RequestMethod.GET)
	public ResponseEntity<Ms1> findByCountryCode(@RequestParam(value="countryCode") String countryCode) {
return ResponseEntity.ok(repository.findByCountryCode(countryCode));

	}
	
	@PostMapping
	public ResponseEntity<Ms1> addConversionFactor(@RequestBody Ms1 ms1) {
		return ResponseEntity.ok(repository.save(ms1));
	}

}
