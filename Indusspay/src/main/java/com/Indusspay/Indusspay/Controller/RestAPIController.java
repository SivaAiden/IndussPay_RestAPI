package com.Indusspay.Indusspay.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Indusspay.Indusspay.Entity.RestAPIEntity;
import com.Indusspay.Indusspay.Services.RestAPIServices;

@RestController
@RequestMapping("/txn")
public class RestAPIController {

	@Autowired
	private RestAPIServices service;
	
	@PostMapping("/add")
	public ResponseEntity<String> addTxn(@RequestBody RestAPIEntity txn) {
		
		/*RestAPIEntity existingTxn = service.findByTxnId(txn.getTxnId());
	    if (existingTxn != null) {
	        String errorMessage = "Transaction with ID " + txn.getTxnId() + " already exists";
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
	    }*/
	    
	    
	    if (txn.getAmount() < 0) {
	    	 String errorMessage = "Amount cannot be less than 0";
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
	    }
	    service.addValueTxn(txn);
	    return ResponseEntity.ok().body("Response Code : 200");
	}

	
	
	  @GetMapping("/amount/{initialRange}/{finalRange}")
	    public ResponseEntity<List<RestAPIEntity>> getTxnsByAmountRange(@PathVariable("initialRange") Float initialRange,
	                                                          @PathVariable("finalRange") Float finalRange) {
	        List<RestAPIEntity> txns = service.getTxnsByAmountRange(initialRange, finalRange);
	        if (txns.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	        }
	        return ResponseEntity.ok(txns);
	    }
	
}
