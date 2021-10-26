package com.mmt.practise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class AmazonDropDownTest {
	@Test
	public void sample() {
		
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("../SHRUTHI_Vtiger/src/main/resources/Extent.html");
		
		ExtentReports reports = new ExtentReports();
		reports.attachReporter(reporter);
		
		ExtentTest test = reports.createTest("sample");
		
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		List<WebElement> allDropDown = driver.findElements(By.xpath("//select[@id='searchDropdownBox']/option"));
		for(int i=0;i<=allDropDown.size()-1;i++)
		{
			String title = allDropDown.get(i).getText();
			System.out.println(title);
		}
		
		reports.flush();
	}

}
