/**
`` * @author arun.dhanasekaran
 *
 * 
 */
package com.arun.LocalProject.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import com.arun.LocalProject.ExcelReader.ExcelReader;
import com.arun.LocalProject.GenralHelper.Wait;
import com.arun.LocalProject.ResourcePath.ResourcePath;

public class TestBase {
	public static Logger log = getMyLogger(TestBase.class);
	public static WebDriver driver;
	public static ExcelReader excelReader;	
	private static void getBrowser(String browser){
		try {
			if(System.getProperty("os.name").contains("Window")){
				if(browser.equalsIgnoreCase("firefox")) {
					System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
					driver = new FirefoxDriver();
				}
				else if(browser.equalsIgnoreCase("chrome")){
					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
					driver = new ChromeDriver();
				}
			}
			else if(System.getProperty("os.name").contains("Mac")){
				System.out.println(System.getProperty("os.name"));
				if(browser.equalsIgnoreCase("firefox")){
					System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver");
					driver = new FirefoxDriver();
				}
				else if(browser.equalsIgnoreCase("chrome")){
					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver");
					driver = new ChromeDriver();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void getUrl()
	{
		try {
			driver.manage().window().maximize();
			log.info("Getting the URL");
			driver.get(getPropertiesFileValue(ResourcePath.GENRAL_PROPERTIES, "url"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void quitBrowser()
	{
		try {
			log.info("Closing the browser");
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void init()
	{
		getBrowser(getPropertiesFileValue(ResourcePath.GENRAL_PROPERTIES, "browser"));
		Wait.impliciteWait();
		Wait.pageLoadTimeOut();
		getUrl();
	}
	
	public static String getPropertiesFileValue(String ProFileName,String key) 
	{
		try {
			Properties p= new Properties();
			FileInputStream ip= new FileInputStream(ProFileName);
			p.load(ip);
			log.info("Loading the propertiesFile key="+key+" and value="+p.getProperty(key));
			return p.getProperty(key);
		} catch (FileNotFoundException e) {	
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return key;
	}

	public static Logger getMyLogger(Class cls)
	{
		try {
			PropertyConfigurator.configure(System.getProperty("user.dir")+"\\Log4j.properties");
			return Logger.getLogger(cls.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Object getCellData(String path,String sheetName,String colName,int rowNum)
	{
		excelReader= new ExcelReader(path);
		Object data = excelReader.getCellData(sheetName, colName, rowNum);
		return data;
	}

	public static String[][] getDataFromSheet(String path,String sheetName)
	{
		excelReader= new ExcelReader(path);
		String[][] data = excelReader.getDataFromSheet(sheetName);
		return data;
	}

	public static String getScreenShot(String name) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "\\src\\main\\java\\com\\arun\\LocalProject\\ScreenShot\\";
			File destFile = new File((String) reportDirectory + name + "_" + formater.format(calendar.getTime()) + ".png");
			FileUtils.copyFile(scrFile, destFile);
			// This will help us to link the screen shot in testNG report
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
			return destFile.toString();
		} catch (IOException e) {
			e.printStackTrace();			
		}
		return name;		
	}
	
	private static WebElement getLocator(String locator)
	{
		try {
			String[] split = locator.split(":");
			String locatorType = split[0];
			String locatorValue = split[1];
			if (locatorType.toLowerCase().equals("id"))
				return driver.findElement(By.id(locatorValue));
			else if (locatorType.toLowerCase().equals("name"))
				return driver.findElement(By.name(locatorValue));
			else if ((locatorType.toLowerCase().equals("classname"))|| (locatorType.toLowerCase().equals("class")))
				return driver.findElement(By.className(locatorValue));
			else if ((locatorType.toLowerCase().equals("tagname"))
					|| (locatorType.toLowerCase().equals("tag")))
				return driver.findElement(By.className(locatorValue));
			else if ((locatorType.toLowerCase().equals("linktext"))
					|| (locatorType.toLowerCase().equals("link")))
				return driver.findElement(By.linkText(locatorValue));
			else if (locatorType.toLowerCase().equals("partiallinktext"))
				return driver.findElement(By.partialLinkText(locatorValue));
			else if ((locatorType.toLowerCase().equals("cssselector"))
					|| (locatorType.toLowerCase().equals("css")))
				return driver.findElement(By.cssSelector(locatorValue));
			else if (locatorType.toLowerCase().equals("xpath"))
				return driver.findElement(By.xpath(locatorValue));
			else
				throw new Exception("Unknown locator type '" + locatorType + "'");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private static List<WebElement> getListOfLocators(String locator) {
		try {
			String[] split = locator.split(":");
			String locatorType = split[0];
			String locatorValue = split[1];
			if (locatorType.toLowerCase().equals("id"))
				return driver.findElements(By.id(locatorValue));
			else if (locatorType.toLowerCase().equals("name"))
				return driver.findElements(By.name(locatorValue));
			else if ((locatorType.toLowerCase().equals("classname"))
					|| (locatorType.toLowerCase().equals("class")))
				return driver.findElements(By.className(locatorValue));
			else if ((locatorType.toLowerCase().equals("tagname"))
					|| (locatorType.toLowerCase().equals("tag")))
				return driver.findElements(By.className(locatorValue));
			else if ((locatorType.toLowerCase().equals("linktext"))
					|| (locatorType.toLowerCase().equals("link")))
				return driver.findElements(By.linkText(locatorValue));
			else if (locatorType.toLowerCase().equals("partiallinktext"))
				return driver.findElements(By.partialLinkText(locatorValue));
			else if ((locatorType.toLowerCase().equals("cssselector"))
					|| (locatorType.toLowerCase().equals("css")))
				return driver.findElements(By.cssSelector(locatorValue));
			else if (locatorType.toLowerCase().equals("xpath"))
				return driver.findElements(By.xpath(locatorValue));
			else
				throw new Exception("Unknown locator type '" + locatorType + "'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static WebElement getWebElement(String ProFileName,String key)
	{
		try {
			return getLocator(getPropertiesFileValue(ProFileName, key));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static List<WebElement> getWebElementList(String ProFileName,String key)
	{
		try {
			return getListOfLocators(getPropertiesFileValue(ProFileName, key));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static void main(String[] args) {

	}

}
