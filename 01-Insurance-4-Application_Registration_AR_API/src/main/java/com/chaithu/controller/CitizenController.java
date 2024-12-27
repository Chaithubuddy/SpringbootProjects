package com.chaithu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chaithu.bindings.CitizenApp;
import com.chaithu.service.ArService;

@RestController
@RequestMapping
public class CitizenController {

	@Autowired
	private ArService arService;

	@PostMapping("/app")
	public ResponseEntity<String> createCitizenApp(@RequestBody CitizenApp app) {
		Integer appId = arService.createApplication(app);
		if (appId > 0) {
			return new ResponseEntity<>("App created with app id" + appId, HttpStatus.OK);

		} else {

			return new ResponseEntity<>("Invalid SSN" , HttpStatus.BAD_REQUEST);

		}
	}

}
