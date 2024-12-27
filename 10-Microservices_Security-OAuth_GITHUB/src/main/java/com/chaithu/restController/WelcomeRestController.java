package com.chaithu.restController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {
	

	@GetMapping("/dashBoard")
	public String welcome() {
		return "Welcome to OAuth -github succesfull ";
	}


}
