package com.chaithu.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chaithu.feigncleint.feigncleint;

@RestController
public class welcomRestController {
	@Autowired
	private feigncleint feigncleint;

	@GetMapping("welcome")
	public String getWelcomeMsg() {
		String msg = feigncleint.invokeGreetMsg();
		return msg + "Wlcome Rest 2";
	}

}
