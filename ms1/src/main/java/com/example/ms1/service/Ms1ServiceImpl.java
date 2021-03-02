package com.example.ms1.service;
import java.util.List;
import java.util.Optional;
import com.example.ms1.model.Ms1;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ms1.repository.Ms1Repository;

@Service
@Transactional
public  class Ms1ServiceImpl implements Ms1Service {
	
	@Autowired
	private Ms1Repository ms1repository;

	@Override
	public Ms1 updateConversionfactor(Ms1 ms1) {
		Optional <Ms1> ms1db = this.ms1repository.findById(ms1.getId());
			Ms1 ms1update = ms1db.get();
			ms1update.setId(ms1.getId());
			ms1update.setConversion_factor(ms1.getConversion_factor());
			ms1update.setCountryCode(ms1.getCountryCode());
			ms1repository.save(ms1);
			return ms1update;
		}


	

}
