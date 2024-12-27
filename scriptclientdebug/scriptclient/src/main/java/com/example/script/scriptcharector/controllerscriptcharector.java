package com.example.script.scriptcharector;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.script.location.clientlocationdto;

public class controllerscriptcharector {
	
		public static void main1(String[] args) {
			RestTemplate restTemplate = new RestTemplate();
			clientscriptcharectordto clientData = new  clientscriptcharectordto(null,"hello",(long) 1);
			
			clientscriptcharectordto clientDto =restTemplate.postForObject("http://localhost:8089/charector", 
					   clientData,
					   clientscriptcharectordto.class);
			
			System.out.println(clientDto);
		}
		public static void main2(String[] args) {
			RestTemplate restTemplate = new RestTemplate();
			clientscriptcharectordto clientData = new  clientscriptcharectordto(null,"hi",(long) 2);
			
			ResponseEntity<	clientscriptcharectordto> re = restTemplate.postForEntity("http://localhost:8089/charector",
					clientData, 	 clientscriptcharectordto.class);
			
			System.out.println(re.getStatusCode());
			System.out.println(re.getStatusCodeValue());
			System.out.println(re.getHeaders());
			System.out.println(re.getBody());
			
			clientscriptcharectordto response = re.getBody();
			System.out.println(response);
			
		}
		
		public static void main3(String[] args) {
			
			RestTemplate restTemplate = new RestTemplate();
			clientscriptcharectordto dto =restTemplate.getForObject("http://localhost:8089/charector/getbyid/{sci}", 	 clientscriptcharectordto.class,13);
			System.out.println(dto);
			
		}
		public static void main4(String[] args) {
			RestTemplate restTempalte  = new RestTemplate();
			ResponseEntity<clientscriptcharectordto>  re = restTempalte.getForEntity("http://localhost:8089/charector/getbyid/{sci}", 	
					clientscriptcharectordto.class,13);
			System.out.println(re.getStatusCodeValue());
			System.out.println(re.getHeaders());
			System.out.println(re.getStatusCode());
			System.out.println(re.getBody());
		}
		
		public static void main5(String[] args) {
			RestTemplate restTempalte  = new RestTemplate();
			clientscriptcharectordto[] arr = restTempalte.getForObject("http://localhost:8089/charector/getall", 	
					clientscriptcharectordto[].class);
		    for (	clientscriptcharectordto clientscriptcharectordto : arr) {
				System.out.println(clientscriptcharectordto);
			}
		}
		
		public static void main6(String[] args) {
			RestTemplate restTempalte  = new RestTemplate();
			ResponseEntity<	clientscriptcharectordto[]>  re = restTempalte.getForEntity("http://localhost:8089/charector/getall", 	clientscriptcharectordto[].class);
		   System.out.println(re.getStatusCodeValue());
		   System.out.println(re.getStatusCode());
		   System.out.println(re.getHeaders());
		   clientscriptcharectordto[] arr = re.getBody();
			for (	clientscriptcharectordto clientscriptcharectordto : arr) {
				System.out.println(clientscriptcharectordto);
			}
		}
		public static void main7(String[] args) {
			RestTemplate restTempalte  = new RestTemplate();
			ResponseEntity<	clientscriptcharectordto>  re = restTempalte.getForEntity("http://localhost:8089/charector/delete/{sci}", 	
					clientscriptcharectordto.class,2);
			System.out.println(re.getStatusCodeValue());
			System.out.println(re.getHeaders());
			System.out.println(re.getStatusCode());
			System.out.println(re.getBody());
		}
	public static void main8(String[] args) {
			
			RestTemplate restTemplate = new RestTemplate();
			clientscriptcharectordto dto =restTemplate.getForObject("http://localhost:8089/charector/delete/{sci}", 	
					clientscriptcharectordto.class,1);
			System.out.println(dto);
			
		}
		
		


}
