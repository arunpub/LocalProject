/**
 * @author arun.dhanasekaran
 *
 * 
 */
package com.arun.LocalProject.TestScript.LoginPage;

import org.apache.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.arun.LocalProject.TestBase.TestBase;
import com.arun.LocalProject.UiAction.HomePage;
import com.arun.LocalProject.UiAction.LoginPage;

public class TC_002LoginAndLogOff extends TestBase {
public static Logger log = getMyLogger(TC_002LoginAndLogOff.class);
	
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
	public static void CheckingValidLogin()
	{
		log("**********Starting-TC_002LoginAndLogOff**********");
		LoginPage.validLogin("admin","password");
		HomePage.logOff();
		log("***********Ending-TC_002LoginAndLogOff************");
	}
	
	
	public static void log(String data) {
		log.info(data);
		Reporter.log(data);
	}
	

}
