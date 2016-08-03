package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Properties;

public class GeneralUtils {

	static Properties prop = new Properties();
	static OutputStream output = null;
	static InputStream input = null;
	static String strOutputFilePath = "properties/config.properties";
	
	
	/**
	 * Writes a property File.
	 * 
	 */
	public static void writePropertyFile(){
		
		try{
			
			output = new FileOutputStream(strOutputFilePath);
			// set the properties value
		    prop.setProperty("product", "MerCI");
		    prop.setProperty("airline", "SQ");
		    prop.setProperty("flow", "OWD");

			// save properties to project root folder
			prop.store(output, null);
		} catch(IOException io){
			
			io.printStackTrace();
		}		
	}
	
	/**
	 * reads a property file * 
	 * 
	 */
	public static void readProperyFile(){
	try{	
		input = new FileInputStream(strOutputFilePath);

		// load a properties file
		prop.load(input);

		// get the property value and print it out
		System.out.println(prop.getProperty("product"));
		System.out.println(prop.getProperty("airline"));
		System.out.println(prop.getProperty("flow"));
		
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	

	/**
	 * 
	 * deletes older file if already exists.
	 * 
	 */
	public static void deleteFileIfExists(){
		
		File f = new File(strOutputFilePath);
		 if(f.exists()){
			 f.delete();
			 System.out.println("Old file found and deleted.");
		 }
	}
	
	
	/**
	 * 
	 * Write into property file ,as key and value.
	 * @param strKey
	 * @param strValue
	 * @throws IOException
	 */
	
	  public static void addValue(String strKey, String strValue) throws IOException {

		    FileWriter fstream = new FileWriter(strOutputFilePath, true);
		    BufferedWriter out = new BufferedWriter(fstream);
		    out.write(strKey + " = " + strValue);
		    out.newLine();
		    out.close();
		    // System.out.println("Added value for " + strKey + " : " + strValue);
		  }
	
	/**
	 * Set get Value as defined by Key
	 * 
	 * 
	 * @param strKey
	 * @return
	 */
	  public static String getValue(String strKey){
		    
		  try{
		  File file = new File(strOutputFilePath);
		    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		    String iLine;
		    while ((iLine = br.readLine()) != null) {
		      if (iLine.substring(0, iLine.indexOf('=')).trim().equalsIgnoreCase(strKey.trim())) {
		        break;
		      }
		    }
		    if (iLine != null) {
		      // String[] strOutputValue = iLine.split("\\=");
		      String strOutputValue = "";
		      if (iLine.contains("=")) {
		        strOutputValue = iLine.substring(iLine.indexOf('=') + 1);
		      }
		      br.close();
		      // return strOutputValue[1].trim();
		      return strOutputValue.trim();
		    }
		    else {
		      br.close();
		      return "";
		    }
		  }catch(Exception e){
			  
			  e.printStackTrace();
			  System.out.println("");
			  return "";
		  }
	}
}
