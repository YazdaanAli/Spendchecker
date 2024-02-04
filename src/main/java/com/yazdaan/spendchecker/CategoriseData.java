package com.yazdaan.spendchecker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

public class CategoriseData {
	
	private List<List<String>> NewData;
	
	public List<String> ReadCompanyName(){
		List<String> lines = new ArrayList<>();
		String filePath = "data.txt";
		
		
		try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
			String line;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
				//System.out.println(line);
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return lines;
	}
	
	public void Compare() {
		List<String> companyNames = ReadCompanyName();
		
	    SwingUtilities.invokeLater(new Runnable() {
	        @Override
	        public void run() {
	            CSV_uploadGUI frame = new CSV_uploadGUI();
	            NewData = frame.getData();
	        }
	    });
		
	}
	
}
