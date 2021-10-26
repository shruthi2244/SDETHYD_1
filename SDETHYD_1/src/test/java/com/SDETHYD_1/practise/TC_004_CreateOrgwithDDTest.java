package com.SDETHYD_1.practise;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TC_004_CreateOrgwithDDTest {
	public void createorgwithDD() throws Throwable {
//		Random random=new Random();
//		int randomnumber=random.nextInt(1000);
//		System.out.println(randomnumber);
		WebDriver driver;
	  ExtentHtmlReporter extentreport=new ExtentHtmlReporter("./src/test/resources/REports.html");
	  
	  extentreport.config().setDocumentTitle("SHRUTHI");
	  extentreport.config().setReportName("VTIGER");
	  extentreport.config().setTheme(Theme.DARK);
	  
	  ExtentReports reports=new ExtentReports();
	  reports.attachReporter(extentreport);
	  
	  reports.setSystemInfo("APPURL", "http://localhost:8888/");
	  reports.setSystemInfo("ENV","Test QA");
	  reports.setSystemInfo("Build", "4.1");
	  reports.setSystemInfo("Reporter name", "shruthi");
	  
	  ExtentTest test=reports.createTest("TC_004_CreateOrgwithDDTest ");
	  test.log(Status.PASS, "craeate org test");
		
		Random random=new Random();
		int randomnumber=random.nextInt(1000);
		System.out.println(randomnumber);
		String orgname="QSPHYD_5"+randomnumber;
		System.out.println(orgname);
		
		FileInputStream fis=new FileInputStream("./common.properties");
		Properties prop=new Properties();
		prop.load(fis);
		if
		(prop.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
		{
		driver=new FirefoxDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		//driver.get("http://localhost:8888/");
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.name("user_password")).sendKeys(prop.getProperty("password"));
	
		driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
		driver.findElement(By.xpath("//img[@title=\"Organizations Settings\"]")).click();
		//driver.findElement(By.xpath("")).click();
		reports.flush();
	}
}