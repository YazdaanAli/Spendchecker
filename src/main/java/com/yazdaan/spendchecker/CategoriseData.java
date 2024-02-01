package com.yazdaan.spendchecker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CategoriseData {
	
	public List<String> ReadCompanyName(){
		List<String> lines = new ArrayList<>();
		String filePath = "data.txt";
		
		
		try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
			String line;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
				System.out.println(line);
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return lines;
	}
	
	public void Compare() {
		List<String> companyNames = ReadCompanyName();
		
		
		
		
	}
	
}
