package com.example.ms1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ms1.model.Ms1;

public interface Ms1Repository extends JpaRepository<Ms1, Long> {

	//Object findBycountry_code(String country_code);
	
	Ms1 findByCountryCode(String countryCode);
	//@Query(value ="Select * from ms1 t where t.country_code= ?0",nativeQuery=true)
	//public Optional<Ms1> findBycountry_code(String country_code);

}
