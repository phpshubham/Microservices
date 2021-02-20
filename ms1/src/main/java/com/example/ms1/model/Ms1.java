package com.example.ms1.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Ms1 {

	@Id
	private long id;
	private double conversion_factor;
	private String countryCode;

}
