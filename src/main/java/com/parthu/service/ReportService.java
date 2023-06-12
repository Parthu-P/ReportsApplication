package com.parthu.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.parthu.entity.CitizenPlan;
import com.parthu.search.SearchRequest;

public interface ReportService {
	
	public List<String> getPlanName();
	
	public List<String> getPlanStatus();
	
	public List<CitizenPlan> search(SearchRequest request);
	
	public boolean exportExcel(HttpServletResponse response) throws Exception;
	
	public boolean exportPdf(HttpServletResponse response) throws Exception;

}
