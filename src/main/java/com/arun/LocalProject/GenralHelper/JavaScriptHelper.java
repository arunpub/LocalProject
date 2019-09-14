/**
 * @author arun.dhanasekaran
 *
 * 
 */

package com.arun.LocalProject.GenralHelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import com.arun.LocalProject.TestBase.TestBase;

public class JavaScriptHelper extends TestBase {
	public static Logger log = getMyLogger(JavaScriptHelper.class);
	
	public static Object executeScript(String script) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		log(script);
		return exe.executeScript(script);
	}

	public static Object executeScript(String script, Object... args) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		log(script);
		return exe.executeScript(script, args);
	}

	public static void scrollToElemet(WebElement element) {
		executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x, element.getLocation().y);
		log("element="+element);
	}

	public static void scrollToElemetAndClick(WebElement element) {
		scrollToElemet(element);
		element.click();
		log("element="+element);
	}

	public static void scrollIntoView(WebElement element) {
		executeScript("arguments[0].scrollIntoView()", element);
		log("element="+element);
	}

	public static void scrollIntoViewAndClick(WebElement element) {
		scrollIntoView(element);
		element.click();
		log("element="+element);
	}

	public static void scrollDownVertically() {
		executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public static void scrollUpVertically() {
		executeScript("window.scrollTo(0, -document.body.scrollHeight)");
	}

	public static void scrollDownByPixel() {
		executeScript("window.scrollBy(0,1500)");
	}

	public static void scrollUpByPixel() {
		executeScript("window.scrollBy(0,-1500)");
	}

	public static void ZoomInBypercentage() {
		executeScript("document.body.style.zoom='40%'");
	}

	public static void ZoomBy100percentage() {
		executeScript("document.body.style.zoom='100%'");
	}	

	public static void log(String data)
	{
		log.info(data);
		Reporter.log(data);
	}
}
