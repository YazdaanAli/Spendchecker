package com.yazdaan.spendchecker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class CSV_reader {
	
	private String filePath;
	
	public CSV_reader(String filePath) {
		this.filePath = filePath;
	}
	
	public List<List<String>> readCSV() {
		List<List<String>> allData = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
              String[] values = line.split(",");
              allData.addAll(DataInList(values));
//              processLine(values);
//              DataInList(values);
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		return allData;
	}
	
//	private void processLine(String[] values) {
//		for (String value : values) {
//			System.out.println(value + "");
//		}
//		System.out.println();
//	}
	
	public List<List<String>> DataInList(String[] values){
	    List<List<String>> data = new ArrayList<>();

	    for (String value : values) {
	        List<String> innerList = new ArrayList<>();
	        innerList.add(value);
	        data.add(innerList);
	    }

	    return data;
	}
}
