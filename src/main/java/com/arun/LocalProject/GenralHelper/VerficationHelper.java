/**
 * @author arun.dhanasekaran
 *
 * 
 */
package com.arun.LocalProject.GenralHelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import com.arun.LocalProject.TestBase.TestBase;


public class VerficationHelper extends TestBase{
	public static Logger log = getMyLogger(VerficationHelper.class);

	public static synchronized boolean verifyElementPresent( WebElement element) {
		boolean isDispalyed = false;
		try {
			 isDispalyed= element.isDisplayed();
			 log(element.getText()+" is dispalyed");
		}
		catch(Exception ex) {
			log.error("Element not found " + ex);
		}
		return isDispalyed;
	}
	
	public static synchronized boolean verifyElementNotPresent( WebElement element) {
		boolean isDispalyed = false;
		try {
			 element.isDisplayed();
			 log(element.getText()+" is dispalyed");
		}
		catch(Exception ex) {
			log.error("Element not found " + ex);
			isDispalyed = true;
		}
		return isDispalyed;
	}
	
	public static synchronized boolean verifyTextEquals( WebElement element,String expectedText) {
		boolean flag = false;
		try {
			String actualText=element.getText();
			if(actualText.equals(expectedText)) {
				log("actualText is :"+actualText+" expected text is: "+expectedText);
				return flag=true;
			}
			else {
				log.error("actualText is :"+actualText+" expected text is: "+expectedText);
				return flag;
			}
		}
		catch(Exception ex) {
			log.error("actualText is :"+element.getText()+" expected text is: "+expectedText);
			log("text not matching" + ex);
			return flag;
		}
	}
	
	public static void log(String data)
	{
		log.info(data);
		Reporter.log(data);
	}

}
