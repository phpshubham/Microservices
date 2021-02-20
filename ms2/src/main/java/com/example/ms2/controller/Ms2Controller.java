package com.example.ms2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ms2.ms1.client.Ms1Client;
import com.fasterxml.jackson.databind.JsonNode;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ms2")
public class Ms2Controller {
	
	private final Ms1Client client;
	
	@GetMapping("/conversion")
	public ResponseEntity<JsonNode> conversion() {
		return client.getAll();
	}
	
	


}
