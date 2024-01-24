package com.yazdaan.spendchecker;

import java.util.Iterator;
import javax.swing.*; //how we will be creating a pop up

public class Spendchecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
//		for(int i = 0; i< 100; i++) {
//			System.out.println("sharujan is a bitch ass");
//		}

//		CSV_reader reader = new CSV_reader("C:\\Users\\yazda\\Downloads\\sample_data.csv");
//		reader.readCSV();
//	
		
	    SwingUtilities.invokeLater(new Runnable() {
	        @Override
	        public void run() {
	            CSV_uploadGUI frame = new CSV_uploadGUI();
	        }
	    });
		
		
	}

}
