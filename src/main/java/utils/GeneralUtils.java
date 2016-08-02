package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class GeneralUtils {

	static Properties prop = new Properties();
	static OutputStream output = null;
	static InputStream input = null;
	
	
	/**
	 * Writes a property File.
	 * 
	 */
	public static void writePropertyFile(){
		
		try{
			
			output = new FileOutputStream("properties/config.properties");
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
	
	
	public static void readProperyFile(){
	try{	
		input = new FileInputStream("properties/config.properties");

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
}
