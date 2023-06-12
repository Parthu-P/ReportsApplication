package com.parthu.util;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.parthu.entity.CitizenPlan;

@Component
public class PdfGenerator {
	
	public void pdfGenerate(HttpServletResponse response,List<CitizenPlan> plans,File file) throws Exception {
		
		Document document=new Document(PageSize.A4);
		PdfWriter.getInstance(document,response.getOutputStream());
		document.open();
		
		Paragraph p=new Paragraph("Citizen Plans Info");
		document.add(p);
		PdfPTable table=new PdfPTable(6);
		
		table.addCell("Id");
		table.addCell("Citizen Name");
		table.addCell("Plan Name");
		table.addCell("Plan Status");
		table.addCell("State Date");
		table.addCell("End Date");
		
	
		
		for(CitizenPlan plan: plans) {
			table.addCell(String.valueOf(plan.getCitizenId()));
			table.addCell(plan.getCitizenName());
			table.addCell(plan.getCitizenPlan());
			table.addCell(plan.getCitizenStatus());
			table.addCell(plan.getCitizenPlanStartDate()+"");
			table.addCell(plan.getCitizenPlanEndDate()+"");
			
			
		}
		
		document.add(table);
		document.close();
		
		
		
		
		
		
		
	}

}
