package fileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JTable;

import customers.UserClass;

public class FileOperations {

	String dir = "FlexBox/CardGrade";
	
	/**
	 * Method to write details (objectList)
	 * to file
	 * 	
	 * @param objectList
	 * @param dir
	 * @param path
	 */
	public void writeToFile(List<Object> objectList, String dir, String path){

		File myDir = new File(dir);
		
		if(myDir.exists() != true){
			myDir.mkdirs();
		}
		
		File myFile = new File(path);
		
		//Checking if file exists
		if(myFile.exists() != true){
			try {
				
				myFile.createNewFile();
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			
			FileWriter fw = new FileWriter(myFile);
			PrintWriter pw = new PrintWriter(fw);
			
			for(int i=0; i < objectList.size(); i++){
				
				fw.write(String.valueOf(objectList.get(i)));			
			}
			
			fw.flush();
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is a variation of the write to
	 * file but it is used only for the user class
	 * 
	 * @param objectList
	 * @param headerList
	 */
	public void writeObjListUserToFile(List<Object> objectList, String dir, String path){

		File myDir = new File(dir);
		
		if(myDir.exists() != true){
			myDir.mkdirs();
		}
		
		File myFile = new File(path);
		
		//Checking if file exists
		if(myFile.exists() != true){
			try {
				
				myFile.createNewFile();
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			
			FileWriter fw = new FileWriter(myFile);
			
			for(int i=0; i < objectList.size(); i++){
				if(!objectList.get(i).equals("\r\n")){
				fw.write(String.valueOf(objectList.get(i) + ","));
			}
			}
			
			fw.flush();
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Writing a user/s to file
	 * 
	 * @param objectList
	 * @param dir
	 * @param path
	 */
	public void writeUserToFile(ArrayList<UserClass> objectList, String dir, String path){

		File myDir = new File(dir);
		
		if(myDir.exists() != true){
			myDir.mkdirs();
		}
		
		File myFile = new File(path);
		
		//Checking if file exists
		if(myFile.exists() != true){
			try {
				
				myFile.createNewFile();
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			
			PrintStream fw = new PrintStream(myFile);
			
			for(int i=0; i < objectList.size(); i++){
				
				if(objectList.size() >1){
				fw.println(objectList.get(i).getFirstName()+"," + objectList.get(i).getLastName() 
						+"," + objectList.get(i).getAddress() + "," + objectList.get(i).getContactNumber()+ "," + objectList.get(i).getUsername() + "," 
						+ objectList.get(i).getPassword() + "," + objectList.get(i).isAdmin() + "," + objectList.get(i).isActive()+",");
				}else{
					fw.println(objectList.get(i).getFirstName()+"," + objectList.get(i).getLastName() 
							+"," + objectList.get(i).getAddress() + "," + objectList.get(i).getContactNumber()+ "," + objectList.get(i).getUsername() + "," 
							+ objectList.get(i).getPassword() + "," + objectList.get(i).isAdmin() + "," + objectList.get(i).isActive()+",");
				}
			}
			
			fw.flush();
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to read from
	 * a file
	 * 
	 * @param path
	 * @return ArrayList<Object>
	 */
	public ArrayList<Object> readFromFile(String dir, String path){
		ArrayList<Object> objectList = new ArrayList<Object>();
		int i=0;
		
		File myDir = new File(dir);		
			
		if(myDir.exists() != true){
			myDir.mkdirs();
		}
		
		File myFile = new File(path);
		
		//Checking if file exists
		if(myFile.exists() != true){
			return null;			
		}
		
		//Get scanner instance
        Scanner scanner;
		try {
			scanner = new Scanner(myFile);
			
			scanner.useDelimiter(",");
			 
			while (scanner.hasNext()) {
				
				objectList.add(i, scanner.next());
				
				i++;
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return objectList;	
	}
	
	/**
	 * Method to read from
	 * a file
	 * 
	 * @param path
	 * @return ArrayList<Object>
	 */
	public ArrayList<Object> readFromUserFile(String dir, String path){
		ArrayList<Object> objectList = new ArrayList<Object>();
		int i=0;
		
		File myDir = new File(dir);		
			
		if(myDir.exists() != true){
			myDir.mkdirs();
		}
		
		File myFile = new File(path);
		
		//Checking if file exists
		if(myFile.exists() != true){
			return null;			
		}
		
		//Get scanner instance
        Scanner scanner;
		try {
			
			scanner = new Scanner(myFile);
			
			scanner.useDelimiter(",");
			 
			while (scanner.hasNext()) {
				
				objectList.add(i, scanner.next());
				
				i++;
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return objectList;	
	}
	
	/**
	 * This method may be used to write
	 * an invoice to file
	 * 
	 * @param table
	 * @param date
	 * @param fullName
	 * @param address
	 * @param userName
	 * @param total
	 */
	public void exportInvoiceToFIle(JTable table, String date, String fullName, 
			String address, String userName, String total){
		
		String dir = "FlexBox/Invoices/" + userName;
		File myDir = new File(dir);
		String path = "FlexBox/Invoices/" + userName + "/" + userName +  
				System.currentTimeMillis() + ".csv";
		
		StringBuilder userDetails = new StringBuilder();
		
		userDetails.append(date + ", " + fullName + ", " + address);
		
		if(myDir.exists() != true){
			try{
				myDir.mkdirs();
			}catch (SecurityException e){
				e.printStackTrace();
			}
		}
		try{
	        FileWriter fileWriter = new FileWriter(path);

	        fileWriter.write(userDetails + "\n");
	        
	        for(int i = 0; i < table.getColumnCount(); i++){    
	        	fileWriter.write(table.getColumnName(i) + "\t");
	        }
	        
	        fileWriter.write("\n");

	        for(int row = 0; row < table.getRowCount(); row++) {
	        	for(int col = 0; col < table.getColumnCount(); col++) {
	        		if(table.getValueAt(row,col) != null){	
	        			fileWriter.write(table.getValueAt(row,col) +"\t");
	        		}
	        	} 
	        	fileWriter.write("\n");
	        }
	        fileWriter.write(total);
	        fileWriter.close();
	    }catch(IOException e){ 
	    	e.printStackTrace();
	    }	
	}
	
}
