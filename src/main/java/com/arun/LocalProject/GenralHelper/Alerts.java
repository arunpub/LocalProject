/**
 * @author arun.dhanasekaran
 *
 * 
 */
package com.arun.LocalProject.GenralHelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.testng.Reporter;
import com.arun.LocalProject.TestBase.TestBase;

public class Alerts extends TestBase{
	public static Logger log = getMyLogger(BrowserHelper.class);
	
	private static Alert getAlert()
	{
		try {
			log("switch to alert");
			return  driver.switchTo().alert();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void acceptAlert()
	{
		try {
			getAlert().accept();
			log("accept alert");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void dismissAlert()
	{
		try {
			getAlert().dismiss();
			log("accept alert");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getTextAlert()
	{
		try {
			log("getting text from Alert");
			return getAlert().getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void log(String data)
	{
		log.info(data);
		Reporter.log(data);
	}

}
