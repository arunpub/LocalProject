/**
 * @author arun.dhanasekaran
 *
 * 
 */
package com.arun.LocalProject.TestScript;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

import com.arun.LocalProject.ResourcePath.ResourcePath;
import com.arun.LocalProject.TestBase.TestBase;

public class TC_001ExcelReading extends TestBase{
	public static Logger log= getMyLogger(TC_001ExcelReading.class);
	@DataProvider(name="excel")
	public String[][] getSetData()
	{
		return getDataFromSheet(ResourcePath.TESTING_XLSX,"Sheet1");
		
	}
	
	@Test(dataProvider="excel")
	public void test(String s1,String s2,String s3,String s4,String s5,String s6)
	{
		log.info("just");
//		System.out.println(s1+" "+s2+" "+s3+" "+s4+" "+s5+" "+s6);
//		System.out.println(getCellData(ResourcePath.TESTING_XLSX, "Sheet1", "F1", 2));
		init();
	}
	@AfterTest
	public static void closingBrowser()
	{
		quitBrowser();
	}

}
