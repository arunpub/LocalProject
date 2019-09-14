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
import com.arun.LocalProject.UiAction.LeadsPage;

public class LeadsPageServices extends TestBase{
	public static Logger log = getMyLogger(LeadsPageServices.class);
	
	public static void creatingNewLeads(String firstNameTitle,String firstName,String lastName,String companyName )
	{
		HomePage.LeadsTab();
		LeadsPage.createNewLeadsButton();
		LeadsPage.selectFirstNameTitle(firstNameTitle);
		LeadsPage.enterFirstName(firstName);
		LeadsPage.enterLastName(lastName);
		LeadsPage.enterCompanyName(companyName);
		//LeadsPage.clickAssignedToUser();
		LeadsPage.buttomSaveButton();
		log("New Leads Created");
	}
	
	public static void log(String data) {
		log.info(data);
		Reporter.log(data);
	}

}
