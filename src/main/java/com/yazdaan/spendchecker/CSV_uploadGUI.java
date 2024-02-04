package com.yazdaan.spendchecker;

import javax.swing.*; //how we will be creating a pop up
import java.awt.event.ActionEvent; // when button is clicked this activates the event(ACtion).
import java.awt.event.ActionListener; //Listens for the button is clicked. without actino listener action event can not be started
import java.io.File;
import java.util.*;

public class CSV_uploadGUI extends JFrame {
	
	private List<List<String>> Data;
	
	public CSV_uploadGUI() {
		setTitle("Upload your Bank file");
		setSize(400, 300); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton uploadButton = new JButton("UPLOAD Bank File");
		getContentPane().add(uploadButton);
		
      // Adding Action Listener to Button
      uploadButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              JFileChooser fileChooser = new JFileChooser();
              fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // sets it to only files not directories
              fileChooser.setAcceptAllFileFilterUsed(false);
              if (fileChooser.showOpenDialog(CSV_uploadGUI.this) == JFileChooser.APPROVE_OPTION) {
                  File selectedFile = fileChooser.getSelectedFile();
                  String selectedFilePath = selectedFile.getAbsolutePath();
                  // Process the selected file
                  if (selectedFilePath.contains(".csv") == true) {
                	  CSV_reader reader = new CSV_reader(selectedFilePath);
                      Data = reader.readCSV();
                      for (List<String> innerList: Data) {
                    	  for(String value : innerList) {
                    		  System.out.println("1" + value + " " );
                    	  }
                    	  //Add a iunt that goes up by 1. 
                    	  System.out.println();
                      }
                  }else if (selectedFilePath.contains(".xlsx") == true){
                	  EXCEL_reader reader = new EXCEL_reader();
                	  Data = reader.readExcelFile(selectedFilePath);
                	  //List<List<String>> data = reader.readExcelFile(selectedFilePath);
//                	  
//                	    // Printing data to console
//                	   for (List<String> row : data) {
//                		   for (String cell : row) {
//                	            System.out.print(cell + "\t"); // Tab-separated cells
//                	        }
//                	        System.out.println(); // New line at the end of each row
//                	    }
                	  
                  }else {
                	  System.out.println("This file time is not supported");
                  }
//                  System.out.println(selectedFilePath);
//                  System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                  
                  
              }
          }
      });
      
      setVisible(true);
			
	}
	
	public List<List<String>> getData(){
		return Data;
	}
	
}

