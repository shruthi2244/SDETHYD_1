package com.vtiger.generic;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.vtiger.comcast.pomrepositorylib.Home;
import com.vtiger.comcast.pomrepositorylib.Login;


	public class BaseClass {
		public WebDriver driver;
		FileUtility  fu= new FileUtility();
		
	
    @BeforeSuite
	public void startconnection() {
	Reporter.log("Start the connection with DataBase");
}
    @BeforeClass
    public void launchbrowser() throws Throwable {
    	
		if
		(fu.readDatafromPropfile("browser").equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(fu.readDatafromPropfile("browser").equalsIgnoreCase("firefox"))
		{
		driver=new FirefoxDriver();
		}
		else {
			driver=new ChromeDriver();
		}
	
		driver.get(fu.readDatafromPropfile("url"));
		driver.manage().window().maximize();
    }
    @BeforeMethod
    public void login() throws Throwable {
    	Login ln=new Login(driver);	
		ln.loginToApp(fu.readDatafromPropfile("username"),fu.readDatafromPropfile("password"));
		
    }
    @AfterMethod
    public void logout() {
    	Home hp=new Home(driver);
    	hp.logout();
    }
    
    @AfterSuite
    public void closeconnection() {
    	Reporter.log("close the connection with database");
    }
    
    
}
