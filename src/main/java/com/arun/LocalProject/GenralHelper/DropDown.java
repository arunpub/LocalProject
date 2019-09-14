/**
 * @author arun.dhanasekaran
 *
 * 
 */
package com.arun.LocalProject.GenralHelper;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import com.arun.LocalProject.TestBase.TestBase;

public class DropDown extends TestBase{
	public static Logger log = getMyLogger(DropDown.class);
	
	public static void selectUsingVisibleValue(WebElement element,String visibleValue) {
		try {
			Select select = new Select(element);
			select.selectByVisibleText(visibleValue);
			log("Locator : " + element + " Value : " + visibleValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void selectUsingIndex(WebElement element,int i)
	{
		try {
			Select select = new Select(element);
			select.selectByIndex(i);
			log("Locator : " + element + " index : " + i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void selectUsingValue(WebElement element,String value)
	{
		try {
			Select select = new Select(element);
			select.selectByValue(value);
			log("Locator : " + element + " value : " + value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<String> getAllDropDownValues(WebElement locator) {
		try {
			Select select = new Select(locator);
			List<WebElement> elementList = select.getOptions();
			List<String> valueList = new LinkedList<String>();
			
			for (WebElement element : elementList) {
				log(element.getText());
				valueList.add(element.getText());
			}
			return valueList;
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
