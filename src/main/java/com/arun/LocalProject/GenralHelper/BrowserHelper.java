/**
 * @author arun.dhanasekaran
 */
package com.arun.LocalProject.GenralHelper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.apache.log4j.Logger;
import org.testng.Reporter;

import com.arun.LocalProject.TestBase.TestBase;

public class BrowserHelper extends TestBase {
	public static Logger log = getMyLogger(BrowserHelper.class);

	public static void switchToFrameByIndex(int index) {
		try {
			driver.switchTo().frame(index);
			log("switch to frame by index" + index);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void switchToFrameBynameOrId(String nameOrId) {
		try {
			driver.switchTo().frame(nameOrId);
			log("switch to frame by nameOrId" + nameOrId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void switchToFrameByframeElement(String ProFileName, String key) {
		try {
			driver.switchTo().frame(getWebElement(ProFileName, key));
			log("switch to frame by WebElement" + key);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void switchToDefaultFrame() {
		try {
			driver.switchTo().defaultContent();
			log("switch to DefaultFrame");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void switchToWindowByIndex(int windowIndex) {
		try {
			Set<String> window = driver.getWindowHandles();
			Iterator<String> itr = window.iterator();
			ArrayList<String> arrayList = new ArrayList<String>();
			while (itr.hasNext()) {
				arrayList.add(itr.next());
			}
			driver.switchTo().window(arrayList.get(windowIndex));
			log("switch to window by index=" + windowIndex);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void switchToWindowTitle(String title) {
		try {
			Set<String> windows = driver.getWindowHandles();
			for (String eachWindow : windows) {
				driver.switchTo().window(eachWindow);
				String actualWindowTitle = driver.getTitle();
				if (actualWindowTitle.equalsIgnoreCase(title) || actualWindowTitle.contains(title)) {
					log("Switch to window by Title="+title);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void refreshWindow()
	{
		driver.navigate().refresh();
	}
	
	public static void navigateForword()
	{
		driver.navigate().forward();
		log("navigate forword");
	}
	
	public static void navigateBack()
	{
		driver.navigate().back();
		log("navigate back");
	}
	
	public static void log(String data) {
		log.info(data);
		Reporter.log(data);
	}

}
