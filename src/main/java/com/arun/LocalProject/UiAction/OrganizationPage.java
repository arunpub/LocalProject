/**
 * @author arun.dhanasekaran
 *
 * 
 */
package com.arun.LocalProject.UiAction;

import org.apache.log4j.Logger;
import org.testng.Reporter;

import com.arun.LocalProject.ResourcePath.ResourcePath;
import com.arun.LocalProject.TestBase.TestBase;

public class OrganizationPage extends TestBase {
	public static Logger log = getMyLogger(OrganizationPage.class);
	
	public static void enterOrganizationName(String organizationName)
	{
		getWebElement(ResourcePath.ORGANIZATION_PAGE, "ORAGANIZATION_PAGE_ORGANIZATIN_NAME_TEXT").sendKeys(organizationName);
		log("Enter the Organization name="+organizationName);
	}
	
	public static void enterPhone(String phone)
	{
		getWebElement(ResourcePath.ORGANIZATION_PAGE, "ORAGANIZATION_PAGE_ORGANIZATIN_PHONE_TEXT").sendKeys(phone);
		log("Enter the phone="+phone);
	}
	
	public static void enterWebsite(String website)
	{
		getWebElement(ResourcePath.ORGANIZATION_PAGE, "ORAGANIZATION_PAGE_ORGANIZATIN_WEBSITE_TEXT").sendKeys(website);
		log("Enter the website="+website);
	}
	
	public static void clickSaveButton()
	{
		getWebElement(ResourcePath.ORGANIZATION_PAGE, "ORAGANIZATION_PAGE_ORGANIZATIN_SAVE_BUTTON").click();
		log("Clicked the Save Button");
	}
	
	public static void clickCancelButton()
	{
		getWebElement(ResourcePath.ORGANIZATION_PAGE, "ORAGANIZATION_PAGE_ORGANIZATIN_CANCEL_BUTTON").click();
		log("Clicked the Cancel Button");
	}

	public static void log(String data) {
		log.info(data);
		Reporter.log(data);
	}
}
