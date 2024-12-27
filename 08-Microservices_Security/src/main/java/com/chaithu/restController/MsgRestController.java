package com.chaithu.restController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgRestController {

	@GetMapping("/hi")
	public String sayHi() {
		return "hi how are u?";
	}

	@GetMapping("/loginCheck")
	public String login() {
		return "successfiull login without security";
	}

	@GetMapping("contact")
	public String contactUs() {
		return "9100881724";
	}

	@GetMapping("/hello")
	public String sayHello() {
		return "hello welcome?";
	}

}
