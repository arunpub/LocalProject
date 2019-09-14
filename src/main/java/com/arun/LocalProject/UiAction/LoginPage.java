/**
 * @author arun.dhanasekaran
 *
 * 
 */
package com.arun.LocalProject.UiAction;
import org.apache.log4j.Logger;
import org.testng.Reporter;

import com.arun.LocalProject.GenralHelper.VerficationHelper;
import com.arun.LocalProject.ResourcePath.ResourcePath;
import com.arun.LocalProject.TestBase.TestBase;

public class LoginPage extends TestBase{
	public static Logger log = getMyLogger(LoginPage.class);
	
	public static void validLogin(String UserName,String Password)
	{		
			getWebElement(ResourcePath.LOGIN_PAGE, "LOGIN_USERNAME").sendKeys(UserName);
			log("Entered UserName="+UserName);
			getWebElement(ResourcePath.LOGIN_PAGE, "LOGIN_PASSWORD").sendKeys(Password);
			log("Entered Password="+Password);
			getWebElement(ResourcePath.LOGIN_PAGE, "LOGIN_BUTTON").click();
			log("Clicked in Login Button");
	}
	
	
	public static void log(String data) {
		log.info(data);
		Reporter.log(data);
	}
}
