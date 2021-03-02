package com.example.ms2.controller;

import java.util.List;
import com.example.ms2.controller.Ms1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ms2.ms1.client.Ms1Client;
import com.fasterxml.jackson.databind.JsonNode;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.var;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ms2")
public class Ms2Controller {
	private final Ms1Client client;
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(Ms2Controller.class);

	@GetMapping("/conversion")
	public ResponseEntity<JsonNode> conversion() {
		return client.getAll();
	}
	@RequestMapping(value = {"countryCode/{countryCode}{amount}"},method = RequestMethod.GET)
	public double  conversionByCountryCode(@RequestParam(value="countryCode") String countryCode,@RequestParam(value="amount") Long amount) {
		
		
		Ms1 ms1=client.getAllByCountryCode(countryCode);
		logger.info(ms1.getConversion_factor()*amount);
		return ms1.getConversion_factor()*amount;
		//List<Ms1> ms1=client.getAllByCountryCode(countryCode);
		//ms1.ge
		//return ResponseEntity.ok(client.getAllByCountryCode(countryCode));
	}


}
