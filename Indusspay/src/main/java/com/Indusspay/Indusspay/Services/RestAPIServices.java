package com.Indusspay.Indusspay.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Indusspay.Indusspay.Entity.RestAPIEntity;
import com.Indusspay.Indusspay.Repository.RestAPIRepository;

@Service
public class RestAPIServices {

	@Autowired
	private RestAPIRepository repo;
	
	public void addValueTxn(RestAPIEntity txn) {
		repo.save(txn);
	}
	
	public List<RestAPIEntity> getTxnsByAmountRange(Float initialRange, Float finalRange) {
        return repo.findByAmountBetween(initialRange, finalRange);
    }
	
	public List<RestAPIEntity> getAllData() {
        return repo.findAll();
    }
	
	public RestAPIEntity findByTxnId(Long id) {
        return repo.findById(id).orElse(null);
    }
	
	
}
