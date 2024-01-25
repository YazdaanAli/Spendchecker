package com.yazdaan.spendchecker;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class EXCEL_reader {
	
	public List<List<String>> readExcelFile(String filePath) {
		List<List<String>> data = new ArrayList<>();
		
		try (FileInputStream fis = new FileInputStream(new File(filePath));
	         Workbook workbook = new XSSFWorkbook(fis)) {
			
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				List<String> rowData = new ArrayList<>();
				Iterator<Cell> cellIterator = row.cellIterator();
				
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					rowData.add(cell.toString());
				}
				
				data.add(rowData);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
				
		return data;
	}
}