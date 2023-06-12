package com.parthu.service;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.parthu.Repo.CitizenRepo;
import com.parthu.entity.CitizenPlan;
import com.parthu.search.SearchRequest;
import com.parthu.util.EmailUtils;
import com.parthu.util.ExcelGenerator;
import com.parthu.util.PdfGenerator;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private CitizenRepo repo;
	@Autowired
	private EmailUtils emailSender;

	@Autowired
	private ExcelGenerator excelGenerator;

	@Autowired
	private PdfGenerator pdfGenerator;

	@Override
	public List<String> getPlanName() {
		return repo.getPlanName();

	}

	@Override
	public List<String> getPlanStatus() {

		return repo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		CitizenPlan entity = new CitizenPlan();
		if (null != request.getPlanName() && !"".equals(request.getPlanName())) {
			entity.setCitizenPlan(request.getPlanName());
		}
		if (null != request.getPlanStatus() && !"".equals(request.getPlanStatus())) {
			entity.setCitizenStatus(request.getPlanStatus());
		}
		if (null != request.getGender() && !"".equals(request.getGender())) {
			entity.setCitizenGender(request.getGender());
		}
		if (null != request.getStartDate() && !"".equals(request.getStartDate())) {
			String startDate = request.getStartDate();

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.parse(startDate, formatter);
			entity.setCitizenPlanStartDate(localDate);
		}
		if (null != request.getEndDate() && !"".equals(request.getEndDate())) {
			String endDate = request.getEndDate();

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.parse(endDate, formatter);
			entity.setCitizenPlanEndDate(localDate);
		}

		return repo.findAll(Example.of(entity));
	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception {
		List<CitizenPlan> plans = repo.findAll();
		File f = new File("Plans.xls");

		excelGenerator.excelGenerate(response, plans,f);
		String subject = "Registration";
		String body = "<h1> Hi Welcome to Email.......</h1>";
		String to = "parthasaradhi.personal1506@gmail.com";

		emailSender.sendEmail(subject, body, to, f);

		f.delete();

		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {

		List<CitizenPlan> plans = repo.findAll();
		File f = new File("Plans.pdf");

		pdfGenerator.pdfGenerate(response, plans,f);
		String subject = "Registration";
		String body = "<h1> Hi Welcome to Email.......</h1>";
		String to = "parthasaradhi.personal1506@gmail.com";

		emailSender.sendEmail(subject, body, to, f);

		f.delete();

	

		return true;
	}

}
