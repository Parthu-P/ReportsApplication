package com.parthu.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.parthu.Repo.CitizenRepo;
import com.parthu.entity.CitizenPlan;


@Component
public class ExcelGenerator {
	
	
	@Autowired
	private CitizenRepo repo;
	
	public void excelGenerate(HttpServletResponse response,List<CitizenPlan> records,File file) throws Exception  {
		
		Workbook workbook =new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("plans-data");
		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("ID");
		headerRow.createCell(1).setCellValue("CitizenName");
		headerRow.createCell(2).setCellValue("PlanName");
		headerRow.createCell(3).setCellValue("PlanStatus");
		headerRow.createCell(4).setCellValue("PlanStartDate");
		headerRow.createCell(5).setCellValue("PlanEndDate");
		headerRow.createCell(6).setCellValue("BeneficieryAmount");
		
		
		
		int dataRowIndex =1;
		
		
		for(CitizenPlan plan:records) {
			Row dataRow = sheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(plan.getCitizenId());
			dataRow.createCell(1).setCellValue(plan.getCitizenName());
			dataRow.createCell(2).setCellValue(plan.getCitizenPlan());
			dataRow.createCell(3).setCellValue(plan.getCitizenStatus());
			if(null != plan.getCitizenPlanStartDate()) {
				dataRow.createCell(4).setCellValue(plan.getCitizenPlanStartDate());
			}else {
				dataRow.createCell(4).setCellValue("N/A");
				
			}
			if(null != plan.getCitizenPlanEndDate()) {
				dataRow.createCell(5).setCellValue(plan.getCitizenPlanEndDate());
			}else {
				dataRow.createCell(5).setCellValue("N/A");
			}
			
			
			if(null != plan.getBeneficiaryAmount()) {
			dataRow.createCell(6).setCellValue(plan.getBeneficiaryAmount());
			}else {
				dataRow.createCell(6).setCellValue("N/A");
			}
			dataRowIndex++;
		}
		
		FileOutputStream fos=new FileOutputStream(new File("plans.xls"));
		workbook.write(fos);
		workbook.close();
		
	
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		
	}

}
