package com.example.ms2.ms1.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.JsonNode;
@FeignClient(url = "http://localhost:8080", name = "ms1")
public interface Ms1Client {

	@RequestMapping(value = "/ms1", produces = { "*/*" }, method = RequestMethod.GET)
	public ResponseEntity<JsonNode> getAll();


	
}
