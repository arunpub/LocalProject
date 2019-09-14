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
import com.arun.LocalProject.UiAction.LoginPage;

public class TC_001CheckingValidLogin extends TestBase {
	public static Logger log = getMyLogger(TC_001CheckingValidLogin.class);
	
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
		log("**********Starting-TC_001CheckingValidLogin**********");
		LoginPage.validLogin("admin","password");
		log("***********Ending-TC_001CheckingValidLogin************");
	}
	
	
	public static void log(String data) {
		log.info(data);
		Reporter.log(data);
	}

}
