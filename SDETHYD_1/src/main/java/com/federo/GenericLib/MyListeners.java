package com.federo.GenericLib;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class MyListeners implements ITestListener{

	public void onTestStart(ITestResult result) {
		Reporter.log(result.getName()+"method started", true);
	}

	public void onTestSuccess(ITestResult result) {
		Reporter.log(result.getName()+"method passed", true);
	}

	public void onTestFailure(ITestResult result) {
		Reporter.log(result.getName()+" method failed", true);
		WebDriverCommonLib wlib= new WebDriverCommonLib();
		wlib.getFullpageScreenshot("C:\\Users\\Shruthi Badala\\git\\repository\\federo\\screenshot"+result.getName()+".png");
	}

	public void onTestSkipped(ITestResult result) {
		Reporter.log(result.getName()+" method skipped", true);
		
	}

	public void onStart(ITestContext context) {
		Reporter.log(context.getName()+"started", true);
	}

	public void onFinish(ITestContext context) {
		Reporter.log(context.getName()+" ended", true);
	}
	}
