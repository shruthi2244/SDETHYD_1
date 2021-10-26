package com.vtiger.generic;


import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.vtiger.comcast.pomrepositorylib.Home;
import com.vtiger.comcast.pomrepositorylib.Login;



public class BaseClass {
	public static WebDriver driver;
	FileUtility  fu= new FileUtility();
	public static WebDriver sdriver;

	@BeforeSuite
	public void startconnection() 
	{
		Reporter.log("Start the connection with DataBase");
	}
	// @Parameters("browser")
	@BeforeClass(groups={"smoke" , "regression"})
	public void launchbrowser() throws Throwable {
		String browsername=fu.readDatafromPropfile("browser");
		if
		(browsername.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		//	     sdriver = driver;
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
	}
	@BeforeMethod(groups={"smoke" , "regression"})
	public void login() throws Throwable {
		Login ln=new Login(driver);	
		ln.loginToApp(fu.readDatafromPropfile("username"),fu.readDatafromPropfile("password"));

	}
	@AfterMethod(groups={"smoke" , "regression"})
	public void logout() throws InterruptedException  {
		Home hp=new Home(driver);
		Thread.sleep(3000);
		hp.logout();
	}
	@AfterClass()
	public void closebrowser() {
		driver.close();
	}


	@AfterSuite(groups={"smoke" , "regression"})
	public void closeconnection() {
		Reporter.log("close the connection with database");
	}


}
