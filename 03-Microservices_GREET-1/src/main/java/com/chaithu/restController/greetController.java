package com.chaithu.restController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class greetController {
	
	@GetMapping("/greet")
	public String getGreetMsg() {
		return "Hi  Greet ";
		
	}

}
