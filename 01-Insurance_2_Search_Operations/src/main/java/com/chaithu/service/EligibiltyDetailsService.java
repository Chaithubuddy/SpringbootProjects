package com.chaithu.service;

import java.util.List;

import com.chaithu.request.SerachReqest;
import com.chaithu.response.SearchResponse;

import jakarta.servlet.http.HttpServletResponse;

public interface EligibiltyDetailsService {

	public List<String> getUniqueNames();

	public List<String> getUniquePlanStatus();

	public List<SearchResponse> search(SerachReqest reqest);

	public void genarateExcel(HttpServletResponse response) throws Exception;

	public void genaratepdfF(HttpServletResponse response) throws Exception;

}
