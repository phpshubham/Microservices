package com.example.ms2.ms1.client;
import com.example.ms2.controller.Ms1;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.JsonNode;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
//@FeignClient(url = "http://localhost:8081", name = "ms1")
@FeignClient(name = "ms1")
public interface Ms1Client {
	public static final String MS1_SERVICE = "ms1Service";
	@CircuitBreaker(name=MS1_SERVICE, fallbackMethod = "ms1Fallback")

	@RequestMapping(value = "/ms1", produces = { "*/*" }, method = RequestMethod.GET)
	public ResponseEntity<JsonNode> getAll();
	@RequestMapping(value ="/ms1/countryCode/{countryCode}",method = RequestMethod.GET)
	public Ms1 getAllByCountryCode(@RequestParam(value="countryCode") String countryCode);
    public static ResponseEntity<String> ms1Fallback(Exception e){
        return new ResponseEntity<String>("MS1 service is down", HttpStatus.OK);

    }
	
}
