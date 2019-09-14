/**
 * @author arun.dhanasekaran
 *
 * 
 */
package com.arun.LocalProject.GenralHelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.arun.LocalProject.TestBase.TestBase;

public class ActionClass extends TestBase{
	public static Logger log = getMyLogger(ActionClass.class);
	
	public static void mouseOverToElement(WebElement element)
	{
		try {
			Actions action= new Actions(driver);
			action.moveToElement(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void dragAndDrop(WebElement source,WebElement destination)
	{
		try {
			Actions action= new Actions(driver);
			action.dragAndDrop(source, destination).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void doubleClick(WebElement element)
	{
		try {
			Actions action= new Actions(driver);
			action.doubleClick(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
