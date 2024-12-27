package com.example.script.time;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.script.location.clientlocationdto;

public class timecontroller {
	
	
	public static void main1(String[] args) {
	RestTemplate restTemplate = new RestTemplate();
	clienttimedto clientData = new  clienttimedto(null,"hello");
	
	clienttimedto clientDto =restTemplate.postForObject("http://localhost:8089/Time/savetimedata", 
			   clientData,
			   clienttimedto.class);
	
	System.out.println(clientDto);
}
public static void main2(String[] args) {
	RestTemplate restTemplate = new RestTemplate();
	clienttimedto clientData = new  clienttimedto(null,"hi");
	
	ResponseEntity<	 clienttimedto> re = restTemplate.postForEntity("http://localhost:8089/Time/savetimedata",
			clientData, 	 clienttimedto.class);
	
	System.out.println(re.getStatusCode());
	System.out.println(re.getStatusCodeValue());
	System.out.println(re.getHeaders());
	System.out.println(re.getBody());
	
	clienttimedto response = re.getBody();
	System.out.println(response);
	
}

public static void main3(String[] args) {
	
	RestTemplate restTemplate = new RestTemplate();
	 clientlocationdto dto =restTemplate.getForObject("http://localhost:8089/Time/{id}", 	 clientlocationdto.class,96);
	System.out.println(dto);
	
}
public static void main4(String[] args) {
	RestTemplate restTempalte  = new RestTemplate();
	ResponseEntity<	clienttimedto>  re = restTempalte.getForEntity("http://localhost:8089/Time/{id}", 	
			clienttimedto.class,96);
	System.out.println(re.getStatusCodeValue());
	System.out.println(re.getHeaders());
	System.out.println(re.getStatusCode());
	System.out.println(re.getBody());
}

public static void main5(String[] args) {
	RestTemplate restTempalte  = new RestTemplate();
	clienttimedto[] arr = restTempalte.getForObject("http://localhost:8089/Time/getall", 	clienttimedto[].class);
   for (	clienttimedto clienttimedto : arr) {
		System.out.println(clienttimedto);
	}
}

public static void main6(String[] args) {
	RestTemplate restTempalte  = new RestTemplate();
	ResponseEntity<	clienttimedto[]>  re = restTempalte.getForEntity("http://localhost:8089/Time/getall", 	clienttimedto[].class);
  System.out.println(re.getStatusCodeValue());
  System.out.println(re.getStatusCode());
  System.out.println(re.getHeaders());
  clienttimedto[] arr = re.getBody();
	for (	clienttimedto clienttimedto : arr) {
		System.out.println(clienttimedto);
	}
}
public static void main55(String[] args) {
RestTemplate restTempalte  = new RestTemplate();
  restTempalte.delete("http://localhost:8089/Time/deleteby/{id}", 	
			clienttimedto.class,96);
//	System.out.println(re.getStatusCodeValue());
//	System.out.println(re.getHeaders());
//	System.out.println(re.getStatusCode());
//	System.out.println(re.getBody());
}
public static void main(String[] args) {
	
	
	RestTemplate restTemplate = new RestTemplate();
      restTemplate. delete("http://localhost:8089/Time/deleteby/{id}", 	
			clienttimedto.class,96);
	System.out.println(restTemplate);
	
	
	
	}
}








