package com.chaithu.feigncleint;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="GREET-1")
public interface feigncleint {
	
	@GetMapping("/greet")
	public String invokeGreetMsg();

}
