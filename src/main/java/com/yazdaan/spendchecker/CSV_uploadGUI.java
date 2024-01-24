package com.yazdaan.spendchecker;

import javax.swing.*; //how we will be creating a pop up
import java.awt.event.ActionEvent; // when button is clicked this activates the event(ACtion).
import java.awt.event.ActionListener; //Listens for the button is clicked. without actino listener action event can not be started
import java.io.File;

public class CSV_uploadGUI extends JFrame {
	
	public CSV_uploadGUI() {
		setTitle("Upload your CSV file");
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton uploadButton = new JButton("UPLOAD CSV");
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
                  System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                  CSV_reader reader = new CSV_reader(selectedFilePath);
                  reader.readCSV();
                  
              }
          }
      });
      
      setVisible(true);
			
	}
	
	
}