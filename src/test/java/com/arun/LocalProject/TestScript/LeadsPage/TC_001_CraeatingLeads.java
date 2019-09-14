/**
 * @author arun.dhanasekaran
 *
 * 
 */
package com.arun.LocalProject.TestScript.LeadsPage;

import org.apache.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.arun.LocalProject.ServiesHelper.LeadsPageServices;
import com.arun.LocalProject.TestBase.TestBase;
import com.arun.LocalProject.UiAction.HomePage;
import com.arun.LocalProject.UiAction.LoginPage;

public class TC_001_CraeatingLeads extends TestBase {
public static Logger log = getMyLogger(TC_001_CraeatingLeads.class);
	
	@BeforeTest
	public static void getUrl()
	{
		init();
	}
	
	@AfterTest
	public static void closingBrowser()
	{
		quitBrowser();
	}
	
	@Test
	public static void creatingNewLeads()
	{
		log("**********Starting-TC_001_CraeatingLeads**********");
		LoginPage.validLogin("admin","password");
		LeadsPageServices.creatingNewLeads("Mr.", "Arun", "Kumar", "admndl");
		log("***********Ending-TC_001_CraeatingLeads************");
	}
	
	
	public static void log(String data) {
		log.info(data);
		Reporter.log(data);
	}


}
