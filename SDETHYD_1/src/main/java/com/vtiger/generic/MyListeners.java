package com.vtiger.generic;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListeners implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
		String failedtestcase = result.getMethod().getMethodName();
		String currentdate = new Date().toString().replace(":", "_").replace(" ", "_");
		EventFiringWebDriver ef=new EventFiringWebDriver(BaseClass.driver);
		File src = ef.getScreenshotAs(OutputType.FILE);
		//File dest = new File("./screenshot"+failedtestcase+".png");
		File dest = new File("./screenshot/"+failedtestcase+currentdate+".PNG");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}	

}