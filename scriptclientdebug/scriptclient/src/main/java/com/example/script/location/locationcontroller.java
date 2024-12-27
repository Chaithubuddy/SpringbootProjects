package com.example.script.location;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.script.clientscriptdto;

public class locationcontroller {
	public static void main1(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		 clientlocationdto clientData = new  clientlocationdto(null,"exterior");
		
		 clientlocationdto clientDto =restTemplate.postForObject("http://localhost:8089/locationtype/savelocationtype", 
				   clientData,
				   clientlocationdto.class);
		
		System.out.println(clientDto);
	}
	public static void main2(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		 clientlocationdto clientData = new  clientlocationdto(null,"pattern");
		
		ResponseEntity<	 clientlocationdto> re = restTemplate.postForEntity("http://localhost:8089/locationtype/savelocationtype",
				clientData, 	 clientlocationdto.class);
		
		System.out.println(re.getStatusCode());
		System.out.println(re.getStatusCodeValue());
		System.out.println(re.getHeaders());
		System.out.println(re.getBody());
		
		 clientlocationdto response = re.getBody();
		System.out.println(response);
		
	}
	
	public static void main3(String[] args) {
		
		RestTemplate restTemplate = new RestTemplate();
		 clientlocationdto dto =restTemplate.getForObject("http://localhost:8089/locationtype/{id}", 	 clientlocationdto.class,94);
		System.out.println(dto);
		
	}
	public static void main4(String[] args) {
		RestTemplate restTempalte  = new RestTemplate();
		ResponseEntity<	clientlocationdto>  re = restTempalte.getForEntity("http://localhost:8089/locationtype/{id}", 	
				clientlocationdto.class,94);
		System.out.println(re.getStatusCodeValue());
		System.out.println(re.getHeaders());
		System.out.println(re.getStatusCode());
		System.out.println(re.getBody());
	}
	
	public static void main5(String[] args) {
		RestTemplate restTempalte  = new RestTemplate();
		clientlocationdto[] arr = restTempalte.getForObject("http://localhost:8089/locationtype/getalllocation", 	clientlocationdto[].class);
	    for (	clientlocationdto clientlocationdto : arr) {
			System.out.println(clientlocationdto);
		}
	}
	
	public static void main6(String[] args) {
		RestTemplate restTempalte  = new RestTemplate();
		ResponseEntity<	clientlocationdto[]>  re = restTempalte.getForEntity("http://localhost:8089/locationtype/getalllocation", 	clientlocationdto[].class);
	   System.out.println(re.getStatusCodeValue());
	   System.out.println(re.getStatusCode());
	   System.out.println(re.getHeaders());
	   clientlocationdto[] arr = re.getBody();
		for (	clientlocationdto clientlocationdto : arr) {
			System.out.println(clientlocationdto);
		}
	}
	public static void main7(String[] args) {
		RestTemplate restTempalte  = new RestTemplate();
		ResponseEntity<	clientlocationdto>  re = restTempalte.getForEntity("http://localhost:8089/locationtype/deletebyid/{id}", 	
				clientlocationdto.class,94);
		System.out.println(re.getStatusCodeValue());
		System.out.println(re.getHeaders());
		System.out.println(re.getStatusCode());
		System.out.println(re.getBody());
	}
public static void main(String[] args) {
		
		RestTemplate restTemplate = new RestTemplate();
		 clientlocationdto dto =restTemplate.getForObject("http://localhost:8089/locationtype/deletebyid/{id}", 	
				 clientlocationdto.class,94);
		System.out.println(dto);
		
	}
	
	


}
