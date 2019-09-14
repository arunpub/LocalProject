/**
 * @author arun.dhanasekaran
 *
 * 
 */
package com.arun.LocalProject.UiAction;

import org.apache.log4j.Logger;
import org.testng.Reporter;

import com.arun.LocalProject.GenralHelper.DropDown;
import com.arun.LocalProject.GenralHelper.JavaScriptHelper;
import com.arun.LocalProject.GenralHelper.Wait;
import com.arun.LocalProject.ResourcePath.ResourcePath;
import com.arun.LocalProject.TestBase.TestBase;

public class LeadsPage extends TestBase{
	public static Logger log = getMyLogger(LeadsPage.class);
	
	public static void createNewLeadsButton()
	{
		Wait.waitForElementIsClickable(getWebElement(ResourcePath.LEADS_PAGE, "LEADSPAGE_CREATE_LEADS"));
		getWebElement(ResourcePath.LEADS_PAGE, "LEADSPAGE_CREATE_LEADS").click();
		log("Clicked Create New Leads Button");
	}
	
	public static void selectFirstNameTitle(String firstNameTitle)
	{
		DropDown.selectUsingVisibleValue(getWebElement(ResourcePath.LEADS_PAGE, "LEADSPAGE_CREATING_NEW_LEADS_FIRSTNAME_TITLE_SELECT"), firstNameTitle);
		log("Select the First name title="+firstNameTitle);
	}
	
	public static void enterFirstName(String firstName)
	{
		getWebElement(ResourcePath.LEADS_PAGE, "LEADSPAGE_CREATING_NEW_LEADS_FIRSTNAME_TEXT").sendKeys(firstName);
		log("Enter the first name="+firstName);
	}
	
	public static void enterLastName(String lastName)
	{
		getWebElement(ResourcePath.LEADS_PAGE, "LEADSPAGE_CREATING_NEW_LEADS_LASTNAME_TEXT").sendKeys(lastName);
		log("Enter the first name="+lastName);
	}
	
	public static void enterCompanyName(String companyName)
	{
		getWebElement(ResourcePath.LEADS_PAGE,"LEADSPAGE_CREATING_NEW_LEADS_COMPANYNAME_TEXT").sendKeys(companyName);
		log("Enter the comapany name="+companyName);
	}
	
	public static void clickAssignedToUser()
	{
		getWebElement(ResourcePath.LEADS_PAGE, "LEADSPAGE_CREATING_NEW_LEADS_ASSIGNED_TO_USER_RADIO").click();
		log("clicked the Assignment to user");
	}
	
	public static void buttomSaveButton()
	{
		Wait.waitForElementIsClickable(getWebElement(ResourcePath.LEADS_PAGE, "LEADSPAGE_CREATING_NEW_LEADS_BUTTOM_SAVE_BUTTON"));
		JavaScriptHelper.scrollIntoViewAndClick(getWebElement(ResourcePath.LEADS_PAGE, "LEADSPAGE_CREATING_NEW_LEADS_BUTTOM_SAVE_BUTTON"));
		log("scroll down and clicked the save button");
	}
	
	
	
	public static void log(String data) {
		log.info(data);
		Reporter.log(data);
	}

}
