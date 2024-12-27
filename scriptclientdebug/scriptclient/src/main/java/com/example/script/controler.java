package com.example.script;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;





public class controler {
	public static void main1(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		clientscriptdto clientData = new clientscriptdto(null,"chandana");
		
		clientscriptdto clientDto =restTemplate.postForObject("http://localhost:8089/script/savescript", 
				   clientData,
				   clientscriptdto.class);
		
		System.out.println(clientDto);
	}
	public static void main2(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		clientscriptdto clientData = new 	clientscriptdto(null,"bhuvana");
		
		ResponseEntity<	clientscriptdto> re = restTemplate.postForEntity("http://localhost:8089/script/savescript",
				clientData, 	clientscriptdto.class);
		
		System.out.println(re.getStatusCode());
		System.out.println(re.getStatusCodeValue());
		System.out.println(re.getHeaders());
		System.out.println(re.getBody());
		
		clientscriptdto response = re.getBody();
		System.out.println(response);
		
	}
	
	public static void main3(String[] args) {
		
		RestTemplate restTemplate = new RestTemplate();
		clientscriptdto dto =restTemplate.getForObject("http://localhost:8089/script/{id}", 	clientscriptdto.class,91);
		System.out.println(dto);
		
	}
	public static void main4(String[] args) {
		RestTemplate restTempalte  = new RestTemplate();
		ResponseEntity<	clientscriptdto>  re = restTempalte.getForEntity("http://localhost:8089/script/{id}", 	clientscriptdto.class,1);
		System.out.println(re.getStatusCodeValue());
		System.out.println(re.getHeaders());
		System.out.println(re.getStatusCode());
		System.out.println(re.getBody());
	}
	
	public static void main5(String[] args) {
		RestTemplate restTempalte  = new RestTemplate();
		clientscriptdto[] arr = restTempalte.getForObject("http://localhost:8089/script/getAll", 	clientscriptdto[].class);
	    for (	clientscriptdto clientPatientDTO : arr) {
			System.out.println(clientPatientDTO);
		}
	}
	
	public static void main(String[] args) {
		RestTemplate restTempalte  = new RestTemplate();
		ResponseEntity<	clientscriptdto[]>  re = restTempalte.getForEntity("http://localhost:8089/script/getAll", 	clientscriptdto[].class);
	   System.out.println(re.getStatusCodeValue());
	   System.out.println(re.getStatusCode());
	   System.out.println(re.getHeaders());
		clientscriptdto[] arr = re.getBody();
		for (	clientscriptdto clientPatientDTO : arr) {
			System.out.println(clientPatientDTO);
		}
	}
	

}
