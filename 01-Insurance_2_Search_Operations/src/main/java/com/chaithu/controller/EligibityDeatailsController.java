package com.chaithu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chaithu.request.SerachReqest;
import com.chaithu.response.SearchResponse;
import com.chaithu.service.EligibiltyDetailsService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class EligibityDeatailsController {
	
	
	@Autowired
	private EligibiltyDetailsService detailsService;
	
	@GetMapping("/names")
	public ResponseEntity<List<String>>getUniquePlanNames(){
		List<String> uniqueNames = detailsService.getUniqueNames();
		return new ResponseEntity<>(uniqueNames,HttpStatus.OK);
		
	}
	
	@GetMapping("/status")
	public ResponseEntity<List<String>>getUniquePlanStatus(){
		List<String> uniquePlanStatus= detailsService.getUniquePlanStatus();
		return new ResponseEntity<>(uniquePlanStatus,HttpStatus.OK);
		
	}
	
	@PostMapping("search")
	public ResponseEntity<List<SearchResponse>>search(@RequestBody SerachReqest reqest ){
		List<SearchResponse> search = detailsService.search(reqest);
		return new ResponseEntity<>(search,HttpStatus.OK);
		
	}
	
	@GetMapping("/excel")
	public void excelReport(HttpServletResponse response) throws Exception {
		response.setContentType("application/vnd.ms-excel");
		String headerKey="Content-Disposition";
		String headerValue="attachment;fileName=data.xls";
		
		response.setHeader(headerKey, headerValue);
		detailsService.genarateExcel(response);
		
	}
	
	@GetMapping("/pdf")
	public void pdfReport(HttpServletResponse response) throws Exception {
		response.setContentType("Application/pdf");
		String headerKey="Content-Disposition";
		String headerValue="attachment;fileName=data.pdf";
		
		response.setHeader(headerKey, headerValue);
		detailsService.genaratepdfF(response);
		
	}
	

}
