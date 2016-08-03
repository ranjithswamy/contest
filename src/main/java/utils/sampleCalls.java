package utils;

import java.io.IOException;

public class sampleCalls {

	
	public static void main(String args[]) throws InterruptedException, IOException{
		
//		GeneralUtils.writePropertyFile();
//		Thread.sleep(2000);
//		GeneralUtils.readProperyFile();
		
		GeneralUtils.deleteFileIfExists();
		GeneralUtils.addValue("Company", "Amadeus");
		GeneralUtils.addValue("Department", "MCC");
		GeneralUtils.addValue("Team", "MerCI");
		Thread.sleep(2000);
		
		System.out.println(GeneralUtils.getValue("Company"));
		System.out.println(GeneralUtils.getValue("Department"));
		System.out.println(GeneralUtils.getValue("Team"));
	}
}
