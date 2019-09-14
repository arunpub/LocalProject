/**
 * @author arun.dhanasekaran
 *
 * 
 */
package com.arun.LocalProject.GenralHelper;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.arun.LocalProject.TestBase.TestBase;

public class Wait extends TestBase {

	public static void impliciteWait() {
		try {
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void pageLoadTimeOut() {
		try {
			driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static WebElement waitForElementIsClickable(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,2000);
			return wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement waitForElementIsVisible(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,2000);
			return wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}

	@SuppressWarnings("deprecation")
	public static WebElement waitForElementWithPollingInterval(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,2000);
			wait.pollingEvery(5, TimeUnit.SECONDS);
			wait.ignoring(NoSuchElementException.class);
			return wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;

	}

}
