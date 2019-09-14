/**
 * @author arun.dhanasekaran
 *
 * 
 */
package com.arun.LocalProject.TestScript.QuickCreatePage;

import org.apache.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.arun.LocalProject.ServiesHelper.OrganizationPageServies;
import com.arun.LocalProject.TestBase.TestBase;
import com.arun.LocalProject.TestScript.LoginPage.TC_001CheckingValidLogin;
import com.arun.LocalProject.UiAction.LoginPage;
import com.arun.LocalProject.UiAction.OrganizationPage;

public class TC_001_QuickCreateQrganization extends TestBase{
public static Logger log = getMyLogger(TC_001_QuickCreateQrganization.class);
	
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
	public static void quickCreateQrganization()
	{
		log("**********Starting-TC_001_QuickCreateQrganization**********");
		LoginPage.validLogin("admin","password");
		OrganizationPageServies.quickCraeteOrganization("Accounts", "ABC", "9999", "www.naresh.com");
		log("***********Ending-TC_001_QuickCreateQrganization************");
	}
	
	
	public static void log(String data) {
		log.info(data);
		Reporter.log(data);
	}
	
}
