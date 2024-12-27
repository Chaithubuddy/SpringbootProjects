package com.chaithu;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

@RestController
class SsnStateController {

    private final Map<String, String> ssnToStateMap;

    public SsnStateController() {
        ssnToStateMap = new HashMap<>();
        ssnToStateMap.put("5534535", "Rhode Island");
        ssnToStateMap.put("433534535", "Ohio");
        ssnToStateMap.put("643434", "New Jersey");
    }

    @GetMapping("/ssn/{ssn}")
    public String getStateBySsn(@PathVariable String ssn) {
        return ssnToStateMap.getOrDefault(ssn, "State not found for SSN: " + ssn);
    }
}
//testing the for web client
//http://localhost:8080/ssn/5534535 → Returns Rhode Island
//http://localhost:8080/ssn/433534535 → Returns Ohio
//http://localhost:8080/ssn/643434 → Returns New Jersey

