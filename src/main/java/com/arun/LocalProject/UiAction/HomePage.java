/**
 * @author arun.dhanasekaran
 *
 * 
 */
package com.arun.LocalProject.UiAction;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.arun.LocalProject.GenralHelper.ActionClass;
import com.arun.LocalProject.GenralHelper.DropDown;
import com.arun.LocalProject.GenralHelper.Wait;
import com.arun.LocalProject.ResourcePath.ResourcePath;
import com.arun.LocalProject.TestBase.TestBase;

public class HomePage extends TestBase {
	public static Logger log = getMyLogger(HomePage.class);
	
	public static void LeadsTab()
	{
		Wait.waitForElementIsClickable(getWebElement(ResourcePath.HOME_PAGE, "HOMEPAGE_MAIN_TABS_LEADS"));
		getWebElement(ResourcePath.HOME_PAGE, "HOMEPAGE_MAIN_TABS_LEADS").click();;
		log("clicked the Leads tab");
	}
	
	public static void logOff()
	{
		ActionClass.mouseOverToElement(getWebElement(ResourcePath.HOME_PAGE, "HOMEPAGE_USERIMAGE"));
		log("MouseOver to UserImg");
		getWebElement(ResourcePath.HOME_PAGE, "HOMEPAGE_SIGNOUT");
		log("Clicked signOut");
	}
	
	public static void clickHomePageTab()
	{
		getWebElement(ResourcePath.HOME_PAGE, "HOMEPAGE_MAIN_TABS_HOMEPAGE_TAB").click();
		log("Clicked on the HomePage button");
	}
	
	public static void selectQuickCreateOptions(String optionsName) {
		Wait.waitForElementIsVisible(getWebElement(ResourcePath.HOME_PAGE, "HOMEPAGE_MAIN_TABS_QUICKCREATE_DROPDOWN"));
		DropDown.selectUsingValue(getWebElement(ResourcePath.HOME_PAGE, "HOMEPAGE_MAIN_TABS_QUICKCREATE_DROPDOWN"), optionsName);
		log("Selected the QuickCreateOptions="+optionsName);
	}
	
	
	public static void log(String data) {
		log.info(data);
		Reporter.log(data);
	}

}
