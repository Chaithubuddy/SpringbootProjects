package com.chaithu.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.chaithu.service.UserService;

@RestController
public class UserRestController {
	
	@Autowired
	private UserService service;
	
	
	

}
