/**
 * @author arun.dhanasekaran
 *
 * 
 */
package com.arun.LocalProject.Listener;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.arun.LocalProject.TestBase.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class ExtentTestNGITestListener extends TestBase implements ITestListener{
	private static ExtentReports extent = ExtentManager.createInstance("extent.html");
	private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
    
	public synchronized void onStart(ITestContext context) {
    	ExtentTest parent = extent.createTest(getClass().getName());
        parentTest.set(parent);
	}

	
	public synchronized void onFinish(ITestContext context) {
		extent.flush();
	}
	

	public synchronized void onTestStart(ITestResult result) {
		log("Test is Start:" + result.getInstanceName());
		ExtentTest child = parentTest.get().createNode(result.getInstanceName());
		test.set(child);
	}


	public synchronized void onTestSuccess(ITestResult result) {
		log("Test is Success:" + result.getInstanceName());
		test.get().pass("Test passed");
		String Passpath = getScreenShot(result.getInstanceName());
		try {
			test.get().pass("Screen_Shot_Passed_"+result.getInstanceName(), MediaEntityBuilder.createScreenCaptureFromPath(Passpath).build());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public synchronized void onTestFailure(ITestResult result) {
		log("Test is Failure:" + result.getInstanceName());
		String Failpath = getScreenShot(result.getInstanceName());
		try {
			test.get().fail("Screen_Shot_Fail_"+result.getInstanceName(), MediaEntityBuilder.createScreenCaptureFromPath(Failpath).build());
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.get().fail(result.getThrowable());
	}

	
	public synchronized void onTestSkipped(ITestResult result) {
		log("Test is Skipped:" + result.getInstanceName());
		test.get().skip(result.getThrowable());
	}


	public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	
	public static void log(String data) {
		log.info(data);
		Reporter.log(data);
	}
}
