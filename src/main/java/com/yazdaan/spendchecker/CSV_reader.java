package com.yazdaan.spendchecker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class CSV_reader {
	
	private String filePath;
	
	public CSV_reader(String filePath) {
		this.filePath = filePath;
	}
	
	public void readCSV() {
		String line = "";
		
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			while ((line = br.readLine()) != null) {
              String[] values = line.split(",");
              processLine(values);
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void processLine(String[] values) {
		for (String value : values) {
			System.out.println(value + "");
		}
		System.out.println();
	}
}
