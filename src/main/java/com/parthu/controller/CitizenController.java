package com.parthu.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.parthu.entity.CitizenPlan;
import com.parthu.search.SearchRequest;
import com.parthu.service.ReportService;

@Controller
public class CitizenController {

	@GetMapping("/pdf")
	public void pdfExport(HttpServletResponse response) throws Exception {
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "attachment;filename=Plans.pdf");

		service.exportPdf(response);
	}

	@GetMapping("/excel")
	public void excelExport(HttpServletResponse response) throws Exception {
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition", "attachment;filename=plans.xls");

		service.exportExcel(response);
	}

	@Autowired
	private ReportService service;

	@GetMapping("/")
	public String loadData(Model model) {
		model.addAttribute("searchObj", new SearchRequest());

		init(model);
		return "index";
	}

	private void init(Model model) {
		model.addAttribute("names", service.getPlanName());
		model.addAttribute("status", service.getPlanStatus());
	}

	@PostMapping("/search")
	public String getData(@ModelAttribute("searchObj") SearchRequest search, Model model) {
		List<CitizenPlan> plan = service.search(search);

		model.addAttribute("Plans", plan);

		init(model);

		return "index";

	}

}
