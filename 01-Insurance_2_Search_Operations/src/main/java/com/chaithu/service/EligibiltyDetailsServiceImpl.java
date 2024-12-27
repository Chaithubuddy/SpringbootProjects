package com.chaithu.service;

import java.awt.Color;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.chaithu.dao.EligibiltyDetailsRepo;
import com.chaithu.entity.EligibiltyDetails;
import com.chaithu.request.SerachReqest;
import com.chaithu.response.SearchResponse;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class EligibiltyDetailsServiceImpl implements EligibiltyDetailsService {

	@Autowired
	private EligibiltyDetailsRepo eligibleRepo;

	@Override
	public List<String> getUniqueNames() {
		return eligibleRepo.findPlanNames();
	}

	@Override
	public List<String> getUniquePlanStatus() {

		return eligibleRepo.findPlanStatus();
	}

	@Override
	public List<SearchResponse> search(SerachReqest reqest) {

		List<SearchResponse> list = new ArrayList<>();

		EligibiltyDetails queryBuilder = new EligibiltyDetails();

		String planName = reqest.getPlanName();
		if (planName != null && !planName.equals("")) {
			queryBuilder.setPlanName(planName);
		}

		String planStatus = reqest.getPlanStatus();
		if (planStatus != null && !planStatus.equals("")) {
			queryBuilder.setPlanStatus(planStatus);
		}

		LocalDate planStartDate = reqest.getPlanStartDate();

		if (planStartDate != null) {
			queryBuilder.setPlanStartDate(planStartDate);
		}

		LocalDate planEndDate = reqest.getPlanEndDate();

		if (planEndDate != null) {
			queryBuilder.setPlanEndDate(planEndDate);
		}

		Example<EligibiltyDetails> example = Example.of(queryBuilder);

		List<EligibiltyDetails> entities = eligibleRepo.findAll(example);
		for (EligibiltyDetails entity : entities) {
			SearchResponse sr = new SearchResponse();
			BeanUtils.copyProperties(entity, sr); // predefined for copy to one to another
			list.add(sr);
		}

		return list;

	}

	@Override
	public void genarateExcel(HttpServletResponse response) throws Exception {
		List<EligibiltyDetails> entities = eligibleRepo.findAll();

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		HSSFRow headerRow = sheet.createRow(0);

		headerRow.createCell(0).setCellValue("Name");
		headerRow.createCell(1).setCellValue("Email");
		headerRow.createCell(2).setCellValue("Mobile");
		headerRow.createCell(3).setCellValue("Gender");
		headerRow.createCell(4).setCellValue("SSN");
		// for every enity one row created;

		int i = 1;
		for (EligibiltyDetails enity : entities) {
			HSSFRow dataRow = sheet.createRow(i);
			dataRow.createCell(0).setCellValue(enity.getName());
			dataRow.createCell(1).setCellValue(enity.getEmail());
			dataRow.createCell(2).setCellValue(enity.getMobile());
			dataRow.createCell(3).setCellValue(String.valueOf(enity.getGender()));
			dataRow.createCell(4).setCellValue(enity.getSsn());
			i++;

		}
		

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();

	}

	@Override
	public void genaratepdfF(HttpServletResponse response) throws Exception {
		List<EligibiltyDetails> entities = eligibleRepo.findAll();
    
		//https:/ /www.codejava.net/frameworks/spring-boot/pdf-export-example
		
		
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLUE);

		Paragraph p = new Paragraph("Search Report", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 1.5f, 3.5f, 3.0f, 3.0f, 1.5f });
		table.setSpacingBefore(10); 
		
		 font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);

		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(5);

		cell.setPhrase(new Phrase("Name", font));

		table.addCell(cell);

		cell.setPhrase(new Phrase("E-mail", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Phn_Number", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Gender", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("SSN", font));
		table.addCell(cell);

		for (EligibiltyDetails entity : entities) {
			table.addCell(String.valueOf(entity.getName()));
			table.addCell(entity.getEmail());
			table.addCell(String.valueOf(entity.getMobile()));
			table.addCell(String.valueOf(entity.getGender()));
			table.addCell(String.valueOf(entity.getSsn()));
		}
		document.add(table);
		document.close();

	}

}
