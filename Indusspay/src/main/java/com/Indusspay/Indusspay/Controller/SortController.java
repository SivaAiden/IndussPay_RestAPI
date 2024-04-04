package com.Indusspay.Indusspay.Controller;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Indusspay.Indusspay.Entity.RestAPIEntity;
import com.Indusspay.Indusspay.Services.RestAPIServices;

@RestController
@RequestMapping("/sort")
public class SortController {
	@Autowired
	private RestAPIServices service;
	
	@GetMapping("/amount")
	public ResponseEntity<List<RestAPIEntity>> sortAmount() {
        List<RestAPIEntity> list = service.getAllData();
        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        list.sort(Comparator.comparing(RestAPIEntity::getAmount));
        return ResponseEntity.ok().body(list);
    }
}
