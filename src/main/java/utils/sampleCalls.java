package utils;

public class sampleCalls {

	
	public static void main(String args[]) throws InterruptedException{
		
		GeneralUtils.writePropertyFile();
		Thread.sleep(2000);
		GeneralUtils.readProperyFile();
	}
}
