/**
 * @author arun.dhanasekaran
 *
 * 
 */
package com.arun.LocalProject.ServiesHelper;

import org.apache.log4j.Logger;
import org.testng.Reporter;
import com.arun.LocalProject.TestBase.TestBase;
import com.arun.LocalProject.UiAction.HomePage;
import com.arun.LocalProject.UiAction.OrganizationPage;

public class OrganizationPageServies extends TestBase{
	public static Logger log = getMyLogger(LeadsPageServices.class);
	
	public static void quickCraeteOrganization(String optionsName,String organizationName,String phone,String website  )
	{
		HomePage.clickHomePageTab();
		HomePage.selectQuickCreateOptions(optionsName);
		OrganizationPage.enterOrganizationName(organizationName);
		OrganizationPage.enterPhone(phone);
		OrganizationPage.enterWebsite(website);
		OrganizationPage.clickSaveButton();
	}
	
	public static void log(String data) {
		log.info(data);
		Reporter.log(data);
	}

}
